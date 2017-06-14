package com.myproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_table")
public class Category {
	
	@Id
    @GeneratedValue 
    @Column(name="categoryId", unique = true, nullable = false)
	private long categoryId;
	
	@Column(name="match1")
	private int match1;
	
	@Column(name="match2")
	private int match2;
	
	@Column(name="prize")
	private int prize;

	public int getMatch1() {
		return match1;
	}

	public void setMatch1(int match1) {
		this.match1 = match1;
	}

	public int getMatch2() {
		return match2;
	}

	public void setMatch2(int match2) {
		this.match2 = match2;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

}
