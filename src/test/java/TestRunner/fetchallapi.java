package TestRunner;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Utitlities.ExtentReportListners.class)


@CucumberOptions(
		features = {".//Features/"},
		glue="smoke", //Step definition package name
		dryRun = false,
		monochrome = true,
		tags = "@fetch_ALL_API",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)


public class fetchallapi extends AbstractTestNGCucumberTests {

}
