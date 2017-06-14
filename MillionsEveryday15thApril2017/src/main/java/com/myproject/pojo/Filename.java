package com.myproject.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "filename_table")
public class Filename {
	
	@Id
	@GeneratedValue
	@Column(name = "fileid", unique = true, nullable = false)
	private long id;

	@Column(name="fname")
	private String fname;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "requestId", nullable = false)
	private Request request;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}
