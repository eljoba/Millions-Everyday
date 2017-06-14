package com.myproject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "retailer_table")
@PrimaryKeyJoinColumn(name = "userID")
public class Retailer extends User{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email")
	private String email;
	

	
	@OneToOne(mappedBy = "retailer", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> request=new ArrayList<Request>();
	
	
	
	


	public List<Request> getRequest() {
		return request;
	}

	public void setRequest(List<Request> request) {
		this.request = request;
	}

	public Retailer(String name, String phone, String email) {
		
		this.name=name;
		this.phone=phone;
		this.email=email;

		
	}
	
	public Retailer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
