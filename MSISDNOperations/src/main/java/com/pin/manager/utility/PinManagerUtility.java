package com.pin.manager.utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pin.manager.dao.PinData;
import com.pin.manager.repository.MsisdnTrialRepository;
import com.pin.manager.repository.PinManagerRepository;

@Service
public class PinManagerUtility {

	// pattern string for formatting the number.
	@Value("${PinGenerationPattern}")
	 String pinPattern = "";
	// max limit for the random number.
	@Value("${MaxLimit}")
	 int maxLimit;
	// timeout for non-validated PINs
	@Value("${inValidPinTimeOutHrs}")
	int inValidPinTimeOutHrs;
	

	@Autowired
	PinManagerRepository pinManagerRepository;
	@Autowired
	MsisdnTrialRepository msisdnTrialRepository;

	// Generate a random 4 digit pin.
	public String generatePin() {

		// add try catch.
		Random random = new Random();
		System.out.println("Pin pattern " + pinPattern);

		String pin = String.format(pinPattern, random.nextInt(maxLimit));
		System.out.println("generated random number is " + pin);
		return pin;
	}

	// method executes every 1 hr to delete the invalidated pins.
	@Scheduled(fixedRate = 3600000)
	public void deleteNonValidatedPin() {

		System.out.println("delete Non Validated Pin Executed.");
		try {

			List<PinData> pinDataList = new ArrayList<PinData>();
			Date finalDate = addHoursToDate(new Date(), inValidPinTimeOutHrs);
			System.out.println("Final Date received is "+ finalDate);
			
			pinDataList = pinManagerRepository.findBygenerationDateLessThanOrEqualToAndValidated(finalDate, false);
			System.out.println("Items found for deleting are " + pinDataList.size());
			
			if (pinDataList.size() > 0) {
				pinManagerRepository.deleteAll(pinDataList);
				System.out.println("Items deleted.");
			}

		} catch (Exception e) {

			System.out.println("Exeption in method deleteNonValidatedPin");
			e.printStackTrace();
		}
	}

	// Method to add no of hours to a Date.
	protected Date addHoursToDate(Date date, int hours) {

		Date finalDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.HOUR, hours);
			finalDate = cal.getTime();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalDate;
	}

}
