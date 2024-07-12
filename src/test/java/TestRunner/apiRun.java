package TestRunner;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Utitlities.ExtentReportListners.class)


@CucumberOptions(
		features = {".//Features/"},
		glue="API", //Step definition package name
		dryRun = false,
		monochrome = true,
		tags = "@HDFC_026",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)


public class apiRun extends AbstractTestNGCucumberTests {

}
