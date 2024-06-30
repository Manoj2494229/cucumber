package API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;

import Utitlities.ExtentReportListners;
import Utitlities.TokenListner;
import Utitlities.base;
import Utitlities.readExcelConfig;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
@Listeners(Utitlities.ExtentReportListners.class)

public class fetchallapi extends base {
	private static String SIT = "https://webserver-vil-sit.lfr.cloud";
	private static String UAT = "https://webserver-vil-uatnew.lfr.cloud";
	
	@When("hit api")
	public void hit_api() {
//		System.setProperty("http.proxyHost", "proxy.tcs.com");
//		System.setProperty("http.proxyPort", "8080");
//		System.setProperty("https.proxyHost", "proxy.tcs.com");
//		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
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

}
