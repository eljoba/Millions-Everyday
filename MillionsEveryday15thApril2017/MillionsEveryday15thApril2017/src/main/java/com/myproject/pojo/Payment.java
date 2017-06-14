package com.myproject.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "payment_table")
public class Payment {
	
	@Id
    @GeneratedValue 
    @Column(name="paymentId", unique = true, nullable = false)
	private long Id;
	
	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Column(name="creditCard")
	private int creditCard;
	
	@Column(name="expiryDate")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	@Column(name="cvv")
	private int cvv;
	
	@Column(name="amount")
	private int amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "regUserId")
	private RegisteredUser regUser;
	
	@Transient
	private long requestId; 
	
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId")
	private Request request;

	@Column(name="playCount")
	int playCount;
	
	@Column(name="payDate")
	@Temporal(TemporalType.DATE)
	private Date payDate;
	
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public RegisteredUser getRegUser() {
		return regUser;
	}

	public void setRegUser(RegisteredUser regUser) {
		this.regUser = regUser;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Payment()
	{
		
	}

	
	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	
	
	

}
