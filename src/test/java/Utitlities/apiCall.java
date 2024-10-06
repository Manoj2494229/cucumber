package Utitlities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiCall {
	
public static Response post_credilio(String baseuri , String payload)
{
	Response response = 
			RestAssured.given().
			auth().
			oauth2(TokenListner.token(baseuri)).
			header("Content-Type","application/json").
			header("x-provider","credilio").
			body(payload).
			when().
			post(baseuri);
	return response ;
}

public static Response post(String baseuri , String payload)
{
	Response response = 
			RestAssured.given().
			auth().
			oauth2(TokenListner.token(baseuri)).
			header("Content-Type","application/json").
			header("x-provider","credilio").
			body(payload).
			when().
			post(baseuri);
	return response ;
}
}
