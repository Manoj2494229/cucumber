package smoke;

import Utitlities.TokenListner;
import Utitlities.base;
import Utitlities.readExcelConfig;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class fetch_ALL_API extends base{
	
	private static String SIT = "https://webserver-vil-sit.lfr.cloud";
	private static String UAT = "https://vishopuat.myvi.in";
	
	@When("hit api all api within VI SHOP")
	public void hit_api_all_api_within_vi_shop() throws Exception {
		reporterAPI(Thread.currentThread().getStackTrace()[1].getMethodName());
		RestAssured.useRelaxedHTTPSValidation();
	}

	@When("check status code and Health Check")
	public void check_status_code_and_health_check() throws Exception {
		reporterAPI(Thread.currentThread().getStackTrace()[1].getMethodName());
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
			//get response time
			long c = resp1.getTime();
			String StatusLine = resp1.getStatusLine();

			reporterAPI(" | "+i +"| API Name = " + BaseURI  +" | Response time in milliseconds: " + c +" | StatusLine: "+StatusLine);
			
		}
	}
	

}
