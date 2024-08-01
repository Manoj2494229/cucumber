package Utitlities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
public class base {
	static WebDriver driver;

	public static void log(String logs)
	{
		Logger log = LogManager.getLogger("StepDef");
		log.info(logs);
	}
	public static void report(String report)
	{
		ExtentReportListners es = new ExtentReportListners();
		es.test.log(LogStatus.PASS, report);
	}
	
	public static  WebDriver setUp(String url) throws Exception
	{
//		if(ConfigListner.getConfigData("browser").equalsIgnoreCase("chrome"))
//		{	
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver ().clearDriverCache ();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("user-data-dir=C:/Users/2494229/AppData/Local/Google/Chrome/User Data/Default");
			WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(url);
		//}
			log("chrome browser started.");
		return driver;
	}

}
