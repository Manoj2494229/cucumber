package com.cucumber.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utitlities.ExtentReportListners;
import Utitlities.TokenListner;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
@Listeners(Utitlities.ExtentReportListners.class)
public class hooks_test extends ExtentReportListners {
	Scenario scenario;
	@Before
	public void beforeScenario(Scenario scenario){

		this.scenario = scenario;
		System.out.println("This will run before the every Scenario");
		test = reports.startTest(scenario.getName());
		System.out.println(scenario.getName());
	}
	String GetProductListAPI1 	= 	"https://vishopuat.myvi.in/o/vil-headless-product/1.0.0/getProductList";
	@Test
	public void fetchDataGetProductListAPI() throws Exception
	{
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.tcs.com");
		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.useRelaxedHTTPSValidation();
		Response GetProductListAPI = RestAssured.given().
				auth().
				oauth2(TokenListner.token(GetProductListAPI1)).
				header("Content-Type","application/json").
				body(hooks_test.payload()).
				when().
				post(GetProductListAPI1);

		hooks_test.formatAPIAndLogInReportnewInput(hooks_test.payload());
		hooks_test.writeRequestAndResponseInReportnewOutput(GetProductListAPI);
	}








	public static void writeRequestAndResponseInReportnewOutput(Response response) throws Exception {
		String a = "";
		//formatAPIAndLogInReport(request);

		String responseBody = response.asPrettyString();
		System.out.println(responseBody);
		String prettyPrint = responseBody.replace("\n", "<br>");
		//test.log(LogStatus.INFO, );
		String  testResponse  = "<pre>"+prettyPrint+"</pre>";
		 // Create a child test
        ExtentTest childTest = reports.startTest("Output Json", "Description of Output Json");
 
        // Log some information in the child test
        childTest.log(LogStatus.INFO, testResponse);
 
        // Append the child test to the parent test
        test.appendChild(childTest);
		
	}
	public static void formatAPIAndLogInReportnewInput(String content) throws Exception {
		String prettyPrint = content.replace("\n", "<br>");
		//test.log(LogStatus.INFO, );
		String  testResponse  = "<pre>"+prettyPrint+"</pre>";



 
        // Create a child test
        ExtentTest childTest = reports.startTest("Input Json", "Input Json");
 
        // Log some information in the child test
        childTest.log(LogStatus.INFO, testResponse);
 
        // Append the child test to the parent test
        test.appendChild(childTest);



	}






























	public static String payload()
	{
		String getProductList = "{\r\n"
				+ "  \"channel\": \"DXL\",\r\n"
				+ "  \"products\": {\r\n"
				+ "    \"categorySearch\": [\r\n"
				+ "      {\r\n"
				+ "        \"categoryId\": 1660964\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"customerId\": -1,\r\n"
				+ "    \"customerSegment\": \"\",\r\n"
				+ "    \"end\": 10,\r\n"
				+ "    \"filterType\": \"\",\r\n"
				+ "    \"keyword\": \"\",\r\n"
				+ "    \"partnerId\": \"\",\r\n"
				+ "    \"productType\": \"bundle\",\r\n"
				+ "    \"rating\": [],\r\n"
				+ "    \"responseListingType\": \"Short\",\r\n"
				+ "    \"sort\": {\r\n"
				+ "      \"sortOn\": \"\",\r\n"
				+ "      \"sortOrder\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"specificationsSearch\": [],\r\n"
				+ "    \"start\": 1,\r\n"
				+ "    \"tagsSearch\": [\r\n"
				+ "      {\r\n"
				+ "        \"tag\": \"bata_950\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"tag\": \"bata_1000\"\r\n"
				+ "      } \r\n"
				+ "    ],\r\n"
				+ "    \"useFactes\": true\r\n"
				+ "  },\r\n"
				+ "  \"requestId\": \"AND10301712038883538\",\r\n"
				+ "  \"serviceName\": \"getProductList\"\r\n"
				+ "}";
		return getProductList;
	}
}
