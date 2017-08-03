/**
 * 
 */
package com.apnabus.apnabus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apnabus.apnabus.model.Passenger;
import com.apnabus.apnabus.repository.Booking;




@RestController
public class ApnabusBooking {
	@Autowired
	Booking booking;
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public /*ResponseEntity<?>*/List<Passenger> booking(@RequestBody List<Passenger> holiday) throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>("benefits", HttpStatus.OK);
		holiday = booking.booking(holiday);
		System.out.println(holiday);
		return holiday;
	}
	
	@RequestMapping(value="/seatinfo", method = RequestMethod.GET)
	public String seatInformation(){
		String info = booking.seatInformation();
		return info;
	}

}
