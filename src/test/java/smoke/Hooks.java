package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import Utitlities.ConfigListner;
import Utitlities.base;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks extends base{
	WebDriver driver = base.driver;
	Scenario scenario;
	@Before
	public void beforeScenario(Scenario scenario){
//		System.setProperty("http.proxyHost", "proxy.tcs.com");
//		System.setProperty("http.proxyPort", "8080");
//		System.setProperty("https.proxyHost", "proxy.tcs.com");
//		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
		this.scenario = scenario;
		System.out.println("This will run before the every Scenario");
		test = reports.startTest(scenario.getName());
		System.out.println(scenario.getName());
	}	
	@Before
	public void beforeScenarioStart(){
		System.out.println("-----------------Start of Scenario-----------------");
	}	

	//	@AfterStep
	//	public void afterStep() throws Exception{
	//		System.out.println("-----------------afterStep-----------------");
	//		scenario.getClass();
	//		test.log(LogStatus.INFO, "Log = "+ scenario.getName());
	//	}	

	@After("@smoke and not @API")
	public void afterScenarioFinish() throws Exception{
		System.out.println("-----------------End of Scenario-----------------");
		base.getDriver().close();
		Thread.sleep(2000);

	}	









	//	@After
	//	public void afterScenario() throws Exception{
	//		base.getDriver().close();
	//		
	//		Thread.sleep(2000);
	//		System.out.println("This will run after the every Scenario");
	//	}	
}
