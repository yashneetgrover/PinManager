package com.pin.manager.repository;

import org.springframework.data.repository.CrudRepository;

import com.pin.manager.dao.MsisdnValidationTrialData;

public interface MsisdnTrialRepository extends CrudRepository<MsisdnValidationTrialData, String> {

}
