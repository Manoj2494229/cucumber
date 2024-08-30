package Utitlities;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
public class logListner extends ExtentReportListners{


	public static void writeRequestAndResponseInReport(Response response) {
		String a = "";
		//formatAPIAndLogInReport(request);
		
		String responseBody = response.asPrettyString();
		System.out.println(responseBody);
		formatAPIAndLogInReport(responseBody);
	}
	public static void formatAPIAndLogInReport(String content) {
		String prettyPrint = content.replace("\n", "<br>");
		test.log(LogStatus.INFO, "<pre>" + prettyPrint + "</pre>");
	}
}
