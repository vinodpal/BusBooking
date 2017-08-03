package com.apnabus.apnabus.model;


public class Seat {
	private int numberOfSeat;
	private static int numberOfAvilableSeat;
	static boolean[][] seat = new boolean[][]{
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
		{true,true,true,true,true,true,true,true,true},
	};
	public int getNumberOfSeat() {
		return numberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}
	public static int getNumberOfAvilableSeat() {
		return numberOfAvilableSeat;
	}
	public void setNumberOfAvilableSeat(int numberOfAvilableSeat) {
		this.numberOfAvilableSeat = numberOfAvilableSeat;
	}
	public static boolean[][] getSeat() {
		return seat;
	}
	public static void setSeat(boolean[][] seat) {
		Seat.seat = seat;
	}
	@Override
	public String toString() {
		return "Seat [numberOfSeat=" + numberOfSeat + ", numberOfAvilableSeat=" + numberOfAvilableSeat + "]";
	}
	
	
}
