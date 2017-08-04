/**
 * 
 */
package com.apnabus.apnabus.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apnabus.apnabus.model.Passenger;
import com.apnabus.apnabus.service.BookingService;

@Repository
public class Booking {

	@Autowired
	BookingService bookginService;

	public List<Passenger> booking(List<Passenger> passengers) {
		bookginService.startBooking(passengers);
		return null;
	}

	public String seatInformation() {
		return null;
	}
}
