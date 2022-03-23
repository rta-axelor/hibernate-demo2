package com.axelor.hiberDemo.db;

import javax.persistence.*;

@Entity
public class Address{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long addressId;
	int houseNumber;
	String street;
	String city;
	String state;
	int zipcode;
	
	@OneToOne(cascade=CascadeType.ALL)
	public Student student;
	
	public Address() {}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {  
	        this.addressId = addressId;  
	    }  
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
