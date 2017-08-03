/**
 * 
 */
package com.apnabus.apnabus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		sideLower = new ArrayList<>(Arrays.asList(11, 12, 15, 21, 22, 25, 31, 32, 35, 41, 42, 45, 51, 52, 55, 61, 62,
				65, 71, 72, 75, 81, 82, 85, 91, 92, 95));
	}

	public static void main(String... strings) {
		new BookingService();
		sideLower.forEach(x -> System.out.print(x + " , "));
		System.out.println();
		sideLower.remove(0);
		sideLower.forEach(x -> System.out.print(x + " , "));
	}

	public String check(List<Passenger> passengers) {
		if (passengers.size() >= 9) {
			return "Limit exceeded";
		}
		int oldMale = 0, youngMale = 0, oldFemale = 0, youngFemale = 0, countKids = 0;
		boolean flag = false;
		try {
			for (Passenger passenger : passengers) {
				if (passenger.getAge() <= 5) {
					++countKids;
				} else
					switch (passenger.getGender().toLowerCase()) {
					case "male": {
						if (passenger.getAge() >= 60) {
							++oldMale;
						} else
							++youngMale;
					}
						break;
					case "female": {
						if (passenger.getAge() >= 60) {
							++oldFemale;
						} else
							++youngFemale;
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
			return "true";
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
	public String startBooking(List<Passenger> passengers) {
		
		return null;
	}
}
