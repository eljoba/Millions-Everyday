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
@Table(name="winning_table")
public class WinningNumbers {
	
	@Id
    @GeneratedValue 
    @Column(name="winningId", unique = true, nullable = false)
	private long Id;
	
	@Column(name="num1")
	private Integer num1;
	
	@Column(name="num2")
	private Integer num2;
	
	@Column(name="num3")
	private Integer num3;
	
	@Column(name="num4")
	private Integer num4;
	
	@Column(name="num5")
	private Integer num5;
	
	@Column(name="num6")
	private Integer num6;
	
	@Column(name="prize")
	private Integer prize;
	
	@Column(name="jackpotDate")
	private Date jackpotDate;
	
	@Column(name="nextJackpot")
	private Date nextJackpot;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lotteryId", nullable = false)
	private Lottery lottery;


	public Lottery getLottery() {
		return lottery;
	}

	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Integer getNum1() {
		return num1;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public Integer getNum2() {
		return num2;
	}

	public void setNum2(Integer num2) {
		this.num2 = num2;
	}

	public Integer getNum3() {
		return num3;
	}

	public void setNum3(Integer num3) {
		this.num3 = num3;
	}

	public Integer getNum4() {
		return num4;
	}

	public void setNum4(Integer num4) {
		this.num4 = num4;
	}

	public Integer getNum5() {
		return num5;
	}

	public void setNum5(Integer num5) {
		this.num5 = num5;
	}

	public Integer getNum6() {
		return num6;
	}

	public void setNum6(Integer num6) {
		this.num6 = num6;
	}

	public Integer getPrize() {
		return prize;
	}

	public void setPrize(Integer prize) {
		this.prize = prize;
	}

	public Date getJackpotDate() {
		return jackpotDate;
	}

	public void setJackpotDate(Date jackpotDate) {
		this.jackpotDate = jackpotDate;
	}

	public Date getNextJackpot() {
		return nextJackpot;
	}

	public void setNextJackpot(Date nextJackpot) {
		this.nextJackpot = nextJackpot;
	}
	
	

}
