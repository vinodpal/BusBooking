/**
 * 
 */
package com.apnabus.apnabus.model;


public class Passenger {
	private String name;
	private int age;
	private String address;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender + "]";
	}
	
}
