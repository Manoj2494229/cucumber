package API;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utitlities.TokenListner;
import Utitlities.base;
import Utitlities.readExcelConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.github.javafaker.Faker;
//@Listeners(Utitlities.ExtentReportListners.class)

public class fetchallapi extends base {
	private static String SIT = "https://webserver-vil-sit.lfr.cloud";
	private static String UAT = "https://webserver-vil-uatnew.lfr.cloud";
	private static String logInCsv = "";

	@Given("Fetch all api and check status code and node")
	public void fetch_all_api_and_check_status_code_and_node() throws Exception {
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.tcs.com");
		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
		readExcelConfig.getLeadData(1,2);
		for(int i = 1 ;i<=36 ;i++)
		{
			String BaseURI = UAT.concat(readExcelConfig.getBaseURI(i,1));
			//System.out.println(BaseURI);
			Response resp1 = RestAssured.given().
					auth().
					oauth2(TokenListner.token(BaseURI)).
					header("Content-Type","application/json").
					body(readExcelConfig.getBaseURI(i,2)).
					when().
					post(BaseURI);
			System.out.println(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());	
			report(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());
			log(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());
			String basePath = "C:\\\\Temp\\\\ReverseCouponPT\\\\";
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDD");
			String fileName=basePath+"RC_"+sdf.format(d)+".csv";
						  // object of BufferedWriter class
			BufferedWriter out = new BufferedWriter(
				            new FileWriter(fileName, true));

				        // Writing on output stream
			logInCsv = " | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode();
			out.write(logInCsv);
				        // Closing the connection
			out.close();
			
			
		}
	}

	@Given("store in csv file")
	public void store_in_csv_file() throws IOException {


				
		String basePath = "C:\\\\Temp\\\\ReverseCouponPT\\\\";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMDD");
		String fileName=basePath+"RC_"+sdf.format(d)+".csv";
					  // object of BufferedWriter class
		BufferedWriter out = new BufferedWriter(
			            new FileWriter(fileName, true));

			        // Writing on output stream
		out.write(logInCsv);
			        // Closing the connection
		out.close();
	}
	
	
	
	
	@When("hit api")
	public void hit_api() throws Exception {
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.tcs.com");
		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
		readExcelConfig.getLeadData(1,2);
	}

	@When("check status response")
	public void check_status_response() throws Exception {
		for(int i = 1 ;i<=36 ;i++)
		{
			String BaseURI = UAT.concat(readExcelConfig.getBaseURI(i,1));
			//System.out.println(BaseURI);
			Response resp1 = RestAssured.given().
					auth().
					oauth2(TokenListner.token(BaseURI)).
					header("Content-Type","application/json").
					body(readExcelConfig.getBaseURI(i,2)).
					when().
					post(BaseURI);
			System.out.println(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());	
			report(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());
			log(" | "+i +"| API Name = " + BaseURI  + "  | "+resp1.getStatusCode());
		}
	}

	@Test
	public void hit_api_test() throws Exception {
		final String path = "./src/test/resource/excel/leadDataFile.xlsx";
		
		
		String fetchQuery = "SELECT STATUS  FROM LD WHERE BANK LIKE '%Axis%'";
		
		ArrayList<String> list = readExcelConfig.getData( fetchQuery, "STATUS" , path);
		for(String s : list)
		{
			System.out.println(s);
		}
		Faker faker = new Faker();
		faker.name().firstName();
		System.out.println(faker.university().name());
		faker.university().name();
		System.out.println(faker.number().digits(10));
		System.out.println(faker.name().firstName());
		for(int i = 1;i<=143 ;i++)
		{
			String name = faker.name().firstName();
			String UpdateQuery = "UPDATE LD SET TEST = '"+name+"' WHERE SR = '"+i+"'";
			readExcelConfig.updateData(UpdateQuery, path);
			System.out.println(name);
		}


	}

}
