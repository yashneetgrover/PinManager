PIN Manager 

Steps : 

1. Download the entire project.
2. In the target folder there is a jar with the name : MSISDNOperations-0.0.1-SNAPSHOT.jar 
3. Go to the directory where the jar is present and run the command : java -jar MSISDNOperations-0.0.1-SNAPSHOT.jar 
4. This will run the application on your cmd. 
5. The application has been configured to run on port 8095 and if the port is occupied kindly change the port in server.port 
property in application.properties.
6. Service uses in-memory apache derby so it does not require any database installation.

After the application has started running refer below request/response 

1. Use POST HTTP method to generate a PIN for a msisdn.

Request :  {
       
        "msisdn" : "+2342324455"
       
    }
	
Response : 

{
    "statusCode": 201,
    "statusMsg": "success",
    "response": {
        "pin": "8735",
        "msisdn": "+2342324455"
    }
}

2. Use PUT HTTP method to validate the PIN.

{
   
        "pin": "8735",
        "msisdn": "+2342324455"
    
}

-- SUCCESS VALIDATION
{
    "statusCode": 200,
    "statusMsg": "success",
    "response": {
        "response": "Pin Validation Successful"
    }
}

-- FAILED VALIDATION

{
    "statusCode": 200,
    "statusMsg": "success",
    "response": {
        "response": "Entered Pin is wrong.Validation Failed."
    }
}

-- PIN ALREADY VALIDATED

{
    "statusCode": 200,
    "statusMsg": "success",
    "response": {
        "response": "Pin Already Validated"
    }
}

---------------------------------------------------------------------------------------------------------------------

1.The system also allows only 3 validation attempts before removing all the non-validated pins.
2.A method has also been scheduled to delete the non-validated pins in an hour.

