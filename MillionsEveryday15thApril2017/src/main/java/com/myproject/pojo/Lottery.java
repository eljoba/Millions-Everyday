package com.myproject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="lottery_table")
public class Lottery {
	
	@Id
    @GeneratedValue 
    @Column(name="lotteryId", unique = true, nullable = false)
	private long lotteryId;
	
	@Column(name="lotteryName")
	private String lotteryName;
	
	@OneToMany(mappedBy="lottery", cascade = CascadeType.ALL)
	private List<WinningNumbers> winningNumbers =new ArrayList<WinningNumbers>();
	
	@Transient
	private CommonsMultipartFile logo;
	
	@Column(name = "filename")
	private String filename;

	public CommonsMultipartFile getLogo() {
		return logo;
	}

	public void setLogo(CommonsMultipartFile logo) {
		this.logo = logo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<WinningNumbers> getWinningNumbers() {
		return winningNumbers;
	}

	public void setWinningNumbers(List<WinningNumbers> winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public long getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(long lotteryId) {
		this.lotteryId = lotteryId;
	}

	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}
	
	

}
