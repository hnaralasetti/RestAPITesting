package com.commonfunctions;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ApiMethods {
	
	public static Response getCall(Headers requestHeaders,String endpoint) {
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.headers(requestHeaders)
				.when().log().headers()
				.get(endpoint);
	}
	
	
	static Header HeaderContentTypeJson = new Header("Content-Type","application/json");
	static Header HeaderAcceptJson = new Header("Accept","application/json");
	
	public static Headers getHeaderConnectJsonAcceptJson()
	{
		List <Header> headerList=new LinkedList<Header>();
		headerList.add(HeaderContentTypeJson);
		headerList.add(HeaderAcceptJson);
		return new Headers(headerList);
	}
	
	public static Response postCall(Headers requestHeaders,String endpoint,Object obj) {
		return RestAssured
				.given()
				.relaxedHTTPSValidation()
				.headers(requestHeaders)
				.when().log().headers()
				.body(new Gson().toJson(obj))
				.when().log().body()
				.patch(endpoint);
	}

}
