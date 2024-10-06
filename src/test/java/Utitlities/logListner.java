package Utitlities;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
public class logListner extends ExtentReportListners{


	public static void writeRequestAndResponseInReport(Response response , String methodeName) {
		String a = "";
		//formatAPIAndLogInReport(request);
		
		String responseBody = response.asPrettyString();
//		System.out.println(responseBody);
//		formatAPIAndLogInReport(responseBody);
		String prettyPrint = responseBody.replace("\n", "<br>");
		
		//test.log(LogStatus.INFO, );
				String  testResponse  = "<pre>"+prettyPrint+"</pre>";
				 // Create a child test
		        ExtentTest childTest = reports.startTest("Output Json", "Output Json - "+methodeName+"-- Click to Open ");
		 
		        // Log some information in the child test
		        childTest.log(LogStatus.INFO, testResponse);
		 
		        // Append the child test to the parent test
		        test.appendChild(childTest);
	}
	public static void formatAPIAndLogInReport(String content , String methodeName) {
		String prettyPrint = content.replace("\n", "<br>");
		
		
		//test.log(LogStatus.INFO, "<pre>" + prettyPrint + "</pre>");
///////////////////////////////////////////////////////////////////////////////////////////////////	
		
		String  testResponse  = "<pre>"+prettyPrint+"</pre>";

		 
        // Create a child test
        ExtentTest childTest = reports.startTest("Input Json", "Input Json - "+methodeName+"-- Click to Open ");
 
        // Log some information in the child test
        childTest.log(LogStatus.INFO, testResponse);
 
        // Append the child test to the parent test
        test.appendChild(childTest);
		
	}
}
