package API;

import org.openqa.selenium.WebDriver;

import Utitlities.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks extends base{
	 WebDriver driver = base.driver;
	Scenario scenario;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll-----------------Start of Scenario-----------------order = 1");
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("https.proxyHost", "proxy.tcs.com");
		System.setProperty("https.proxyPort", "8080");
		RestAssured.useRelaxedHTTPSValidation();
	}
	@Before
    public void beforeScenario(Scenario scenario){
		this.scenario = scenario;
       System.out.println("This will run before the every Scenario");
        test = reports.startTest(scenario.getName());
       System.out.println(scenario.getName());
    }	
	@Before
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    }	
	@After
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }	
	@After
    public void afterScenario(){
        System.out.println("This will run after the every Scenario");
    }	
}
