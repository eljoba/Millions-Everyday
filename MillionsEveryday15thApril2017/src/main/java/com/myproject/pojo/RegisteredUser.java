package com.myproject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "registeredUser_table")
@PrimaryKeyJoinColumn(name = "userID")
public class RegisteredUser extends User{

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	@Column(name="phone")
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name="email")
	private String email;
	
	@Column(name="sex")
	private String sex;
	
	@OneToMany(mappedBy="registeredUser", cascade = CascadeType.ALL)
	private List<MillionsEveryday> millionsEveryday =new ArrayList<MillionsEveryday>();
	
	@OneToMany(mappedBy="regUser", cascade = CascadeType.ALL)
	private List<Payment> Payment =new ArrayList<Payment>();
	
	public List<Payment> getPayment() {
		return Payment;
	}

	public void setPayment(List<Payment> payment) {
		Payment = payment;
	}

	public List<MillionsEveryday> getMillionsEveryday() {
		return millionsEveryday;
	}

	public void setMillionsEveryday(List<MillionsEveryday> millionsEveryday) {
		this.millionsEveryday = millionsEveryday;
	}

	public RegisteredUser() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
