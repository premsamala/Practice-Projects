package com.soapwebservicepractice.SoapWebService.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soapwebservicepractice.courses.CourseDetails;
import com.soapwebservicepractice.courses.GetCourseDetailsRequest;
import com.soapwebservicepractice.courses.GetCourseDetailsResponse;



@Endpoint
public class CourseDetailsEndPoint {
	
	@PayloadRoot(namespace="http://soapwebservicepractice.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processGetCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		CourseDetails courseDetails = new CourseDetails();
		
		courseDetails.setId(request.getId());
		
		courseDetails.setName("Java Web Services");
		
		courseDetails.setDescription("It's easy to learn, but needs practice");
		
		response.setCourseDetails(courseDetails);
		
		return response;
			
	}

}
