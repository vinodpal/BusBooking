/**
 * 
 */
package com.apnabus.apnabus.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.apnabus.apnabus.model.Passenger;
import com.apnabus.apnabus.model.Seat;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

public class BookingService {
	private static Map<String, Passenger> records;
	private static List<Integer> sideLower;
	private static int totalOldMale;
	private static int totalYoungFemale;
	private static int totalYoungMale;
	private static int totalOldFemale;

	public BookingService() {
		records = new HashMap<String, Passenger>();
		sideLower = new ArrayList<>(Arrays.asList(11, 14, 17, 21, 24, 27, 31, 34, 37, 41, 44, 47, 51, 54, 57, 61, 64,
				67, 71, 74, 77, 81, 84, 87, 91, 94, 97));
	}

	public static void main(String... strings) {
		new BookingService();
		sideLower.forEach(x -> System.out.print(x + " , "));
		System.out.println();
		sideLower.remove(0);
		sideLower.forEach(x -> System.out.print(x + " , "));
	}

	public String startBooking(List<Passenger> passengers) {
		if (passengers.size() >= 9) {
			return "Limit exceeded";
		}
		int oldMale = 0, youngMale = 0, oldFemale = 0, youngFemale = 0, countKids = 0;
		boolean flag = false;
		Map<String,List<Passenger>> passengerMap = new HashMap<>();
		passengerMap.put("seniorMale", new ArrayList<Passenger>());
		passengerMap.put("youngMale", new ArrayList<Passenger>());
		passengerMap.put("seniorFemale", new ArrayList<Passenger>());
		passengerMap.put("youngFemale", new ArrayList<Passenger>());
		try {
			for (Passenger passenger : passengers) {
				if (passenger.getAge() <= 5) {
					++countKids;
				} else
					switch (passenger.getGender().toLowerCase()) {
					case "male": {
						if (passenger.getAge() >= 60) {
							++oldMale;
							passengerMap.get("seniorMale").add(passenger);
						} else {
							++youngMale;
							passengerMap.get("youngMale").add(passenger);
						}
					}
						break;
					case "female": {
						if (passenger.getAge() >= 60) {
							++oldFemale;
							passengerMap.get("seniorFemale").add(passenger);
						} else {
							++youngFemale;
							passengerMap.get("youngFemale").add(passenger);
						}
					}
						break;

					default:
						System.out.println("Please provide gender for " + passenger.getName());

					}
			}
		} catch (Exception ex) {
			System.out.println("Please provide valid ");
			return "Please provide valid ";
		}
		if (countKids >= 3) {
			return "Kids Not Allowed More Then Two!!!";
		} else if (checkAvailable(oldMale, youngMale, oldFemale, youngFemale)) {
			// return "true";
			Booking(oldMale, youngMale, oldFemale, youngFemale,passengerMap);
		}
		return "Please provide valid records";
	}

	private boolean checkAvailable(int oldMale, int youngMale, int oldFemale, int youngFemale) {
		if (oldMale + oldFemale < sideLower.size()) {
			if (oldMale + oldFemale + youngMale + youngFemale <= Seat.getNumberOfAvilableSeat()) {
				return true;
			}
		}
		return false;
	}

	String Booking(int oldMale, int youngMale, int oldFemale, int youngFemale,
			Map<String, List<Passenger>> passengerMap) {
		totalOldMale += oldMale;
		totalYoungFemale += youngFemale;
		totalYoungMale += youngMale;
		totalOldFemale += oldFemale;
		Deque<Integer> setOfSeatNumber = new ArrayDeque<>();
		// First seat booking for all senior citizen passenger
		for (Passenger passenger : passengerMap.get("seniorMale")) {
			records.put("apnabus21" + sideLower.get(0), passenger);
			setOfSeatNumber.add(sideLower.get(0));
			sideLower.remove(0);
		}
		for (Passenger passenger : passengerMap.get("seniorFemale")) {
			records.put("apnabus21" + sideLower.get(0), passenger);
			setOfSeatNumber.add(sideLower.get(0));
			sideLower.remove(0);
		}
		int itertorForFemale = 0;
		int itertorForMale = 0;
		if (setOfSeatNumber.size() < 1) {
			// Booking seat for young female
			if (sideLower.get(0) != null && youngFemale > 0) {
				records.put("apnabus21" + sideLower.get(0), passengerMap.get("youngFemale").get(itertorForFemale++));
				setOfSeatNumber.add(sideLower.get(0));
				sideLower.remove(0);
			} else {

			}
		} else {
			// If senior citizen traveling then check for Female from last senior citizen
			// passenger which has same coach,
			// otherwise check nearest location staring seat of senior citizen passenger
			if (youngFemale > 0) {
				// Check last senior citizen passenger has nearest side lower birth in same
				// coach
				if ((setOfSeatNumber.getLast() % 10) < 7) {

				} // Check first senior citizen passenger has nearest any seat in any coach
				else {

				}
			}
			// booking seat for male from booked seat of starting seat of senior citizen
			// passenger
			else {

			}
		}
		return null;
	}
	
	//Searching adjacent seat for closer seat.
	int adjacentSeatSearch(boolean[][] seat, int row, int column, int adjacentSeatCount) {
		if (row < 1 || row > 9 || column < 1 || column > 8) {
			return Integer.MAX_VALUE;
		}
		if (seat[row][column]) {
			return adjacentSeatCount;
		}
		return 0;
	}
}
