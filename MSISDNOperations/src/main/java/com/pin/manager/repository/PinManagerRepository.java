package com.pin.manager.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pin.manager.dao.PinData;

@Repository
public interface PinManagerRepository extends CrudRepository<PinData, Long>{

	public List<PinData> findBymsisdnAndValidated(String msisdn,boolean isValidFlag);
	public List<PinData> findBymsisdn(String msisdn);
	public void deleteBymsisdnAndValidated(String msisdn,boolean validateFlag);
	
	@Query(value ="Select NEW com.pin.manager.dao.PinData( id,msisdn,pin,validated,generationDate,lastModifiedDate) from PinData p where p.generationDate <= :dateStamp and validated = :validateFlag" )
	public List<PinData> findBygenerationDateLessThanOrEqualToAndValidated(@Param("dateStamp")Date dateStamp, @Param("validateFlag") boolean validateFlag);
	
}
