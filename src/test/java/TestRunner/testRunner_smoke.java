package TestRunner;
//import org.junit.runner.RunWith;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import Utitlities.uploadFileOnServerAndEmail;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Utitlities.ExtentReportListners.class)

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/"},
		glue="smoke",
		dryRun = false,
		monochrome = true,
		tags = "@API", //scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)

//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
//		plugin = {"pretty","json:target/cucumber-reports/report_json.json"}

public class testRunner_smoke extends AbstractTestNGCucumberTests {

	
	//@AfterSuite
	public void afterAllScenarioFinish() throws Exception{
		//Upload file on SIT server and send email
		//uploadFileOnServerAndEmail.uploadFileOnSITServerAndEmail();
	}


}
