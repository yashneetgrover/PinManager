package com.pin.manager.service;

import java.util.List;

import com.pin.manager.dao.GeneratePinRequest;
import com.pin.manager.dao.GeneratePinResponse;
import com.pin.manager.dao.MsisdnValidationTrialData;
import com.pin.manager.dao.PinData;
import com.pin.manager.dao.ValidatePinRequest;
import com.pin.manager.dao.ValidatePinResponse;

public interface PinManagerService {

	public GeneratePinResponse generatePin (GeneratePinRequest pinReq) throws Exception;
	
	public ValidatePinResponse validatePin(ValidatePinRequest validateReq);
	
	public List<PinData> getAllPinData();
	public List<MsisdnValidationTrialData> getAllTrialData();
	
}
