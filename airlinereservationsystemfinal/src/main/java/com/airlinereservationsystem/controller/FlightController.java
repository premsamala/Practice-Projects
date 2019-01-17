package com.airlinereservationsystem.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.airlinereservationsystem.model.CreditcardDetails;
import com.airlinereservationsystem.model.FlightDetails;
import com.airlinereservationsystem.model.ReservationDetails;
import com.airlinereservationsystem.model.TicketDetails;
import com.airlinereservationsystem.model.UserDetails;
import com.airlinereservationsystem.modelview.FlightSearch;
import com.airlinereservationsystem.modelview.FlightSelectionDetails;
import com.airlinereservationsystem.modelview.PassengerInformation;
import com.airlinereservationsystem.modelview.PassengerInformationList;
import com.airlinereservationsystem.modelview.PaymentDetails;
import com.airlinereservationsystem.repository.CreditCardDetailsRepository;
import com.airlinereservationsystem.repository.FlightDetailsRepository;
import com.airlinereservationsystem.repository.ReservationDetailsRepository;
import com.airlinereservationsystem.repository.TicketDetailsRepository;
import com.airlinereservationsystem.repository.UserDetailsRepository;

@Controller
@SessionAttributes({ "username", "flightId", "passengerDetails", "totalFare" })
@Scope(value = "prototype")
@RequestMapping("/flightdetails")
@PropertySource("/static/source-destination.properties")
public class FlightController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	@Autowired
	private ReservationDetailsRepository reservationDetailsRepository;

	@Autowired
	private List<PassengerInformation> passengerInformation = new ArrayList<PassengerInformation>();

	@Autowired
	private PassengerInformationList passengerInformationList;

	@Autowired
	private CreditCardDetailsRepository creditCardDetailsRepository;

	@Autowired
	private TicketDetailsRepository ticketDetailsRepository;

	private List<PassengerInformation> passengerDetails;

	@Value("#{'${flight-places}'.split(',')}")
	private List<String> flightPlaces;

	@RequestMapping("/")
	public String welcomepage(Model theModel) {
		if(theModel.containsAttribute("username")) {
		theModel.addAttribute("flightPlaces", flightPlaces);
		theModel.addAttribute("flightSearch", new FlightSearch());
		return "flightsearch";
		}
		else {
			return "welcome";
		}
	}

	@GetMapping("/flightsearch")
	public String flightSearch(@Valid @ModelAttribute("flightSearch") FlightSearch flightSearch,
			BindingResult theBindingResult, Model theModel) {
		Optional<List<ReservationDetails>> flightDetails = reservationDetailsRepository
				.findByDepartureDateAndSourceAndDestination(flightSearch.getDate(), flightSearch.getSource(),
						flightSearch.getDestination());
		if (flightDetails.isPresent()) {
			List<ReservationDetails> flightSearchResults = flightDetails.get();
			for (ReservationDetails reservationDetails : flightSearchResults) {
				System.out.println(reservationDetails.getDepartureDate() + " " + reservationDetails.getSource() + " "
						+ reservationDetails.getDestination());
			}
			// Optional<List<ReservationDetails>> flightSearchAvailableSeats =
			// reservationDetailsRepository.findByFlightDetailsIn(flightSearchResults);
			theModel.addAttribute("flightSearchResults", flightSearchResults);
			theModel.addAttribute("flightSelectionDetails", new FlightSelectionDetails());
			// theModel.addAttribute("flightSearchAvailableSeats",
			// flightSearchAvailableSeats);
			return "flightsearchresults";
		} else {
			theModel.addAttribute("flightSearchError", "No flight exists with current selection");
			theModel.addAttribute("flightPlaces", flightPlaces);
			return "flightsearch";
		}
	}

	@GetMapping("/bookflight")
	public String bookflight(@RequestParam("flightId") String flightId, Model theModel) {
		System.out.println(flightId);
		if (!theModel.containsAttribute("flightId")) {
			theModel.addAttribute("flightId", flightId);
		}
		theModel.addAttribute("flightDetails", reservationDetailsRepository
				.findByFlightDetails(flightDetailsRepository.findById(flightId).get()).get());
		// PassengerInformationList passengerInformationList = new
		// PassengerInformationList();
		for (int i = 1; i <= 3; i++) {
			passengerInformation.add(new PassengerInformation());
		}
		passengerInformationList.setPassengerInformationList(passengerInformation);
		theModel.addAttribute("passengerInformation", passengerInformationList);
		return "passengerdetails";
	}

	@PostMapping("/passengerdetails")
	public String PassengerDetails(
			@ModelAttribute("passengerInformation") PassengerInformationList passengerDetailsList,
			@ModelAttribute("flightId") String flightId, @RequestParam("passengerscount") Integer passengerCount,
			Model theModel) {

		passengerDetails = passengerDetailsList.getPassengerInformationList();
		// passengerDetails.removeAll(Collections.singleton(null));
		System.out.println(passengerCount);
		passengerDetails = passengerDetails.subList(1, passengerCount + 1);
		// System.out.println(passengerDetails.size());
		// while(passengerDetails.remove(null));
		// System.out.println(passengerDetails.size());
		for (PassengerInformation passengerInformation : passengerDetails) {
			System.out.println(passengerInformation.getName() + " " + passengerInformation.getAge());
		}
		theModel.addAttribute("passengerDetails", passengerDetails);
		theModel.addAttribute("creditcarddetails", new PaymentDetails());
		Double flightFare = flightDetailsRepository.findById(flightId).get().getFare();
		Double totalFare=flightFare * passengerDetails.size();
		
		theModel.addAttribute("totalFare", totalFare);
		return "paymentdetails";
	}

	@PostMapping("/processpayment")
	public ModelAndView processPayment(@ModelAttribute("creditcarddetails") PaymentDetails paymentDetails,
			Model theModel) {
		Optional<CreditcardDetails> creditcardDetails = creditCardDetailsRepository
				.findById(paymentDetails.getCardNumber());
		ModelAndView modelAndView = new ModelAndView();
		if (creditcardDetails.isPresent()) {
			modelAndView.setViewName("forward:/flightdetails/savereservation");
			modelAndView.addObject(theModel);
			return modelAndView;
		}

		modelAndView.setViewName("paymentdetails");
		// modelAndView.addObject(theModel);
		modelAndView.addObject("paymenterror", "Please enter valid payment credentials");
		return modelAndView;

		/*
		 * theModel.addAttribute("paymenterror",
		 * "Please enter valid payment credentials"); return
		 * ModelAndView("paymentdetails", theModel);
		 */
	}

	@RequestMapping("/savereservation")
	public String saveReservation(@ModelAttribute("flightId") String flightId,
			@ModelAttribute("totalFare") Double totalfare, @ModelAttribute("username") String username,
			Model theModel) {
		FlightDetails selectedFlight = flightDetailsRepository.findById(flightId).get();
		Optional<ReservationDetails> selectedReservation = reservationDetailsRepository
				.findByFlightDetails(selectedFlight);
		ReservationDetails selectedReservationDetails = selectedReservation.get();
		Integer modifySeats = selectedReservationDetails.getAvailableSeats() - 1;
		selectedReservationDetails.setAvailableSeats(modifySeats);
		reservationDetailsRepository.save(selectedReservationDetails);
		long millis = System.currentTimeMillis();
		Optional<UserDetails> tempUserDetails = userDetailsRepository.findById(username);
		UserDetails userDetails = tempUserDetails.get();
		byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		String pnr = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
		TicketDetails ticketDetails = new TicketDetails(pnr, new Date(millis),
				selectedReservationDetails.getDepartureDate(), selectedReservationDetails.getDepartureTime(), totalfare,
				selectedFlight, userDetails);
		ticketDetailsRepository.save(ticketDetails);
		theModel.addAttribute("reservationdetails", selectedReservationDetails);
		theModel.addAttribute("flightfare", totalfare);
		theModel.addAttribute("ticketdetails", ticketDetails);
		theModel.addAttribute("passengerdetails", passengerDetails);
		return "paymentsuccess";
	}
}
