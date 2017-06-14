package com.myproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "address_table")
public class Address {
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "retailer"))
	@Column(name = "addressid", unique = true, nullable = false)
	private long id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Retailer retailer;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	public Address()
	{
		
	}
	
	public Address(String street, String city, String state)
	{
		this.street=street;
		this.city=city;
		this.state=state;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
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
	
	

}
