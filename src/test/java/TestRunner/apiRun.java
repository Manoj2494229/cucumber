package TestRunner;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Utitlities.ExtentReportListners.class)



@CucumberOptions(
		features = {".//Features/"},
		glue="API",
		dryRun = false,
		monochrome = true,
		tags = "@api_regression",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)
public class apiRun extends AbstractTestNGCucumberTests {
//
}
