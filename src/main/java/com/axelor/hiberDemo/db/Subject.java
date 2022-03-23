package com.axelor.hiberDemo.db;

import java.util.*;

import javax.persistence.*;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long id;
	String sname;
	@ManyToMany(cascade=CascadeType.ALL)
	
	private List<Student> subjects = new ArrayList<>();
	
	
	public Subject() {
	}

	public Subject(String sname) {
		this.sname = sname;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
