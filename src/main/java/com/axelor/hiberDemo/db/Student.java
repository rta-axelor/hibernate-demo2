package com.axelor.hiberDemo.db;

import java.util.List;

import javax.persistence.*;



@Entity
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	 private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ContactNo cno;
	
	public Student() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void  setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address1) {
		this.address =  address1;
	}

	public ContactNo getCno() {
		return cno;
	}

	public void setCno(ContactNo cno) {
		this.cno = cno;
	}


	
	
}
