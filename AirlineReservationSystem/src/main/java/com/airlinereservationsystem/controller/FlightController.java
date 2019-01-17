package com.airlinereservationsystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.airlinereservationsystem.model.FlightDetails;
import com.airlinereservationsystem.model.PassengerDetails;
import com.airlinereservationsystem.model.ReservationDetails;
import com.airlinereservationsystem.modelview.FlightSearch;
import com.airlinereservationsystem.modelview.FlightSelectionDetails;
import com.airlinereservationsystem.modelview.PassengerInformation;
import com.airlinereservationsystem.repository.FlightDetailsRepository;
import com.airlinereservationsystem.repository.ReservationDetailsRepository;

@Controller
@SessionAttributes({"username", "flightId"})
@Scope(value = "prototype")
@RequestMapping("/flightdetails")
@PropertySource("/static/source-destination.properties")
public class FlightController {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private ReservationDetailsRepository reservationDetailsRepository;
		
	@Autowired
	private List<PassengerInformation> passengerInformation;
	
	@Value("#{'${flight-places}'.split(',')}")
	private List<String> flightPlaces;

	@RequestMapping("/")
	public String welcomepage(Model theModel) {
		theModel.addAttribute("flightPlaces", flightPlaces);
		theModel.addAttribute("flightSearch", new FlightSearch());
		return "flightsearch";
	}
	
	@GetMapping("/flightsearch")
	public String flightSearch(@Valid @ModelAttribute("flightSearch") FlightSearch flightSearch, BindingResult theBindingResult, Model theModel) {
		Optional<List<ReservationDetails>> flightDetails = reservationDetailsRepository
															.findByDepartureDateAndSourceAndDestination
															(flightSearch.getDate(), flightSearch.getSource(), flightSearch.getDestination());
		if(flightDetails.isPresent()) {
			List<ReservationDetails> flightSearchResults = flightDetails.get();
			for (ReservationDetails reservationDetails : flightSearchResults) {
				System.out.println(reservationDetails.getDepartureDate() + " " + reservationDetails.getSource() + " " + reservationDetails.getDestination());
			}
			//Optional<List<ReservationDetails>> flightSearchAvailableSeats =  reservationDetailsRepository.findByFlightDetailsIn(flightSearchResults);
			theModel.addAttribute("flightSearchResults", flightSearchResults);
			theModel.addAttribute("flightSelectionDetails", new FlightSelectionDetails());
			//theModel.addAttribute("flightSearchAvailableSeats", flightSearchAvailableSeats);
			return "flightsearchresults";
		}
		else {
			theModel.addAttribute("flightSearchError", "No flight exists with current selection");
			theModel.addAttribute("flightPlaces", flightPlaces);
			return "flightsearch";
		}
	}
	
	@GetMapping("/bookflight")
	public String bookflight(@RequestParam("flightId") String flightId, Model theModel) {
		System.out.println(flightId);
		theModel.addAttribute("flightId", flightId);
		theModel.addAttribute
					("flightDetails", 
							reservationDetailsRepository.findByFlightDetails(flightDetailsRepository.findById(flightId).get()).get());
		theModel.addAttribute("passengerInformation", passengerInformation);
		return "passengerdetails";
	}
	
	@GetMapping("savereservation")
	public String saveReservation(@RequestParam("flightId") String flightId) {
		FlightDetails selectedFlight = flightDetailsRepository.findById(flightId).get();
		Optional<ReservationDetails> selectedReservation = reservationDetailsRepository.findByFlightDetails(selectedFlight);
		ReservationDetails selectedReservationDetails = selectedReservation.get();
		Integer modifySeats = selectedReservationDetails.getAvailableSeats()-1;
		selectedReservationDetails.setAvailableSeats(modifySeats);
		reservationDetailsRepository.save(selectedReservationDetails);
		return null;
	}
}
