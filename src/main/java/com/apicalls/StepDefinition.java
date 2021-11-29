package com.apicalls;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.commonfunctions.ApiMethods;
import com.sample.config.BPConstants;
import com.sample.dto.RegisterRequest;





public class StepDefinition {
	
	Response response;
	ApiMethods apimethods = new ApiMethods();
	RegisterRequest register  =new RegisterRequest();
	
	
	@Test
	public void callTheUserService( ) {
		/// Get Method
		response = apimethods.getCall(apimethods.getHeaderConnectJsonAcceptJson(), BPConstants.GET_ENDPOINT);
		System.out.println("res"+response.asString());
		
	}
	
	@Test
	public void postCall() {
		  register.setJob("tester"); 
		  register.setName("Hari"); 
		  response = apimethods.postCall(apimethods.getHeaderConnectJsonAcceptJson(),
		  BPConstants.USERS_ENDPOINT, register);
		  System.out.println(response.asString());
	}
	
	@AfterTest
	public void verifyTheUserServices() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}


}
