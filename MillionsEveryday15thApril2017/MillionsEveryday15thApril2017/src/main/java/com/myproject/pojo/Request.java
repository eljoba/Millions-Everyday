package com.myproject.pojo;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


import org.springframework.web.multipart.commons.CommonsMultipartFile;




@Entity
@Table(name="request_table")
public class Request {
	
	@Id
    @GeneratedValue 
    @Column(name="requestId", unique = true, nullable = false)
	private long requestId;
	
	@Column(name="requestDate")
	@Temporal(TemporalType.DATE)
	private Date requestDate;
	
	@Column(name = "longitude")
	private float longitude;
	
	@Column(name = "latitude")
	private float latitude;
	
	@Transient
	private CommonsMultipartFile[] photo;
	
	@OneToMany(mappedBy="request",cascade = CascadeType.ALL)
	private List<Payment> payment=new ArrayList<Payment>();
	
	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	@Transient
	private String imagename;
	
	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	@OneToMany(fetch = FetchType.LAZY,mappedBy="request", cascade = CascadeType.ALL)
	private List<Filename> filename =new ArrayList<Filename>();
	
	@Column(name="itvn")
	private String itvn;
	
	@Column(name = "fsvn")
	private String fsvn;
	
	@Column(name="city")
	private String city;
	
	@Column(name = "zip")
	private int zip;
	
	@Column(name="address")
	private String address;
	
	@Column(name="status")
	private String status;
	
	@Column(name="retailerName")
	private String retailerName; 
	
	
	
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	@Column(name="retId")
	private long retId;
	
	
	

	public long getRetId() {
		return retId;
	}

	public void setRetId(long retId) {
		this.retId = retId;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItvn() {
		return itvn;
	}

	public void setItvn(String itvn) {
		this.itvn = itvn;
	}

	public String getFsvn() {
		return fsvn;
	}

	public void setFsvn(String fsvn) {
		this.fsvn = fsvn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	
	public List<Filename> getFilename() {
		return filename;
	}

	public void setFilename(List<Filename> filename) {
		this.filename = filename;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public CommonsMultipartFile[] getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile[] photo) {
		this.photo = photo;
	}

	

}
