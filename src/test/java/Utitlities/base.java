package Utitlities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
public class base extends Help{

	public static WebDriver driver;

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

	public static  WebDriver openTerminal(String url) throws Exception
	{
//		System.setProperty("http.proxyHost", "proxy.tcs.com");
//		System.setProperty("http.proxyPort", "8080");
//		System.setProperty("https.proxyHost", "proxy.tcs.com");
//		System.setProperty("https.proxyPort", "8080");
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver ().clearDriverCache ();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("user-data-dir=C:/Users/2494229/AppData/Local/Google/Chrome/User Data/Default");
		options.addArguments("window-size=1200x600");
		options.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		log("chrome browser started." +url);
		return driver;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		base.driver = driver;
	}
	
	

}
