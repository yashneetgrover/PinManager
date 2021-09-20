package com.pin.manager.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MsisdnValidationTrialData {

	@Id
	String msisdn;
	int trialCount;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public int getTrialCount() {
		return trialCount;
	}
	public void setTrialCount(int trialCount) {
		this.trialCount = trialCount;
	}
	
	
}
