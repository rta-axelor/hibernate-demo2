package com.axelor.hiberDemo.db;
import javax.persistence.*;

@Entity
public class ContactNo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long id;
	
	@Column(length=10)
	Long number;
	public ContactNo() {}
	
	public ContactNo(long number) {
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
}
