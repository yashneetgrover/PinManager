package com.pin.manager.service.impl;

import org.springframework.stereotype.Service;

import com.pin.manager.dao.Response;

@Service
public class PublishResponse {

	
	public Response publishSuccessPostResponse (Object response) {
		
		Response resp = new Response();
		resp.setStatusCode(201);
		resp.setStatusMsg("success");
		resp.setResponse(response);
		
		return resp;
	}
	
	public Response publishFailResponse (int statusCode, String statusMsg) {
		
		Response resp = new Response();
		resp.setStatusCode(statusCode);
		resp.setStatusMsg(statusMsg);
		
		return resp;
	}
	
	public Response publishSuccessPutResponse (Object response) {
		
		Response resp = new Response();
		resp.setStatusCode(200);
		resp.setStatusMsg("success");
		resp.setResponse(response);
		
		return resp;
	}
}
