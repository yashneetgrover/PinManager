package com.pin.manager.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PinData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String msisdn;
	String pin;
	boolean validated = false;
	@JsonFormat(pattern="yyyy-MM-dd")
	Date generationDate = new Date();
	@JsonFormat(pattern="yyyy-MM-dd")
	Date lastModifiedDate = new Date();
	
	public PinData() {
		super();
	}
	
	public PinData(long id, String msisdn, String pin, boolean validated, Date generationDate, Date lastModifiedDate) {
		super();
		this.id = id;
		this.msisdn = msisdn;
		this.pin = pin;
		this.validated = validated;
		this.generationDate = generationDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Date getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
}
