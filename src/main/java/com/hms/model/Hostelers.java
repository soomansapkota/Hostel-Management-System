package com.hms.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="hostelers_tbl")
public class Hostelers {
	@Id
	@GeneratedValue
	private int StudentId;
	private String fname;
	private String lname;
	private int age;
	private long phone_no;
	private String institutions;
	private String emailId;
	
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	public int getStudentId() {
		return StudentId;
	}



	public void setStudentId(int studentId) {
		StudentId = studentId;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public long getPhone_no() {
		return phone_no;
	}



	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}



	public String getInstitutions() {
		return institutions;
	}



	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}




	

	
}
