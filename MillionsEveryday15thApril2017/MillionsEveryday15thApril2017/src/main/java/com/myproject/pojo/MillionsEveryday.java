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
import javax.persistence.Table;

@Entity
@Table(name="millionsEveryday_table")
public class MillionsEveryday {
	
	@Id
    @GeneratedValue 
    @Column(name="millionsId", unique = true, nullable = false)
	private long Id;
	
	@Column(name="num1")
	private int num1;
	
	@Column(name="num2")
	private int num2;
	
	@Column(name="num3")
	private int num3;
	
	@Column(name="num4")
	private int num4;
	
	@Column(name="num5")
	private int num5;
	
	@Column(name="num6")
	private int num6;
	
	@Column(name="prize")
	private int prize;
	
	@Column(name="datePlayed")
	private Date datePlayed;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	private RegisteredUser registeredUser;


	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public int getNum6() {
		return num6;
	}

	public void setNum6(int num6) {
		this.num6 = num6;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public Date getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
		this.datePlayed = datePlayed;
	}
	
	

}
