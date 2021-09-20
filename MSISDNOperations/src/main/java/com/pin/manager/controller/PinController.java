package com.pin.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pin.manager.dao.GeneratePinRequest;
import com.pin.manager.dao.GeneratePinResponse;
import com.pin.manager.dao.MsisdnValidationTrialData;
import com.pin.manager.dao.PinData;
import com.pin.manager.dao.Response;
import com.pin.manager.dao.ValidatePinRequest;
import com.pin.manager.dao.ValidatePinResponse;
import com.pin.manager.exception.InvalidMsisdnException;
import com.pin.manager.exception.MaxPinCountException;
import com.pin.manager.service.PinManagerService;
import com.pin.manager.service.impl.PublishResponse;

@RestController
@RequestMapping("/pinmanager")
public class PinController {

	@Autowired
	PinManagerService pinManagerService;
	@Autowired
	PublishResponse publishResponse;
	
	// Method to create a PIN
	@PostMapping("/pin")
	public Response generatePin(@RequestBody GeneratePinRequest genRequest) {
		
		try {
			
			GeneratePinResponse response = pinManagerService.generatePin(genRequest);
			return publishResponse.publishSuccessPostResponse(response);
			
		}
		catch(MaxPinCountException e) {
			e.printStackTrace();
			return publishResponse.publishFailResponse(200, e.getMessage());
		}
		catch(InvalidMsisdnException e ) {
			
			e.printStackTrace();
			return publishResponse.publishFailResponse(400, e.getMessage());
		}
		catch (Exception e) {
		
			e.printStackTrace();
			return publishResponse.publishFailResponse(500, e.getMessage());
		}
		
	}
	
	// method to update the PIN Validation Status.
	@PutMapping("/pin")
	public Response validatePin(@RequestBody ValidatePinRequest validateReq) {
		
		try {
			
			ValidatePinResponse response = pinManagerService.validatePin(validateReq);
			return publishResponse.publishSuccessPutResponse(response);
		}
		catch(Exception e) {
			e.printStackTrace();
			return publishResponse.publishFailResponse(500, e.getMessage());
		}
	}
	
	// below methods have been created to display the state of DB.
	

	@GetMapping(value="/pin" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PinData> getAllPinData()
	{
		
		return pinManagerService.getAllPinData();
		
	}	
	
	@GetMapping(value="/trial" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MsisdnValidationTrialData> getAllTrialData()
	{
		
		return pinManagerService.getAllTrialData();
		
	}	
	
}
