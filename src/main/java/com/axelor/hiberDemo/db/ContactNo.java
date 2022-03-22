package com.axelor.hiberDemo.db;
import javax.persistence.*;

@Entity
public class ContactNo {
	
	@Id
	int id;
	int number;
	
	public ContactNo(int number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
