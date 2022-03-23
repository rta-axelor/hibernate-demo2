package com.axelor.hiberDemo.db;

import javax.persistence.*;

@Entity
@Table(name="email")
public class Email{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	String emailid;
	String pswd;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	public Email() {}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}