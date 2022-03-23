package com.axelor.hiberDemo.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="student")
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	 private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cno_id")
	private ContactNo cno;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "student")
	private List<Email> email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private List<Subject> sub = new ArrayList<>();
	
	
	public Student() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long i) {
		this.id = i;
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
	
	
	public void addEmailListItem(Email email) {
		
		if(this.email == null) {
			this.email = new ArrayList<>();
		}
		email.setStudent(this);
		this.email.add(email);
	}

	public List<Email> getEmail() {
		return email;
	}

	public void setEmail(List<Email> email) {
		for (Email em : email) {
			em.setStudent(this);
		}
		this.email = email;
	}

	public List<Subject> getSubject() {
		return sub;
	}

	public void setSubject(Subject subject) {
		sub.add(subject);
		
	}

	

	 
}
