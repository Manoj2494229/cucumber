package Utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;


public class ConfigListner extends ExtentReportListners{

	public static String getConfigData(String Key) throws Exception  {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/login.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);	
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getLoginConfigData(String Key) throws Exception  {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/login_1.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);	
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String discount(String Key) throws Exception  {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/discount.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);	
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String getleadConfigData(String Key) throws Exception  {
		FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/leadform.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty(Key); 
	}

	public static void keyValue(String val) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/login.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(val);
		System.out.println(value);
		Thread.sleep(1000);
		String screenshotPath = ExtentReportListners.getScreenshot(base.driver, "testing");
		test.log(LogStatus.INFO, test.addBase64ScreenShot(screenshotPath)+val +" = " +value );
	}
	
	public static String getGiftIdRazerpay(String Key) throws Exception  {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/razerpay.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);	
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String readBuyJourneyConfig(String Key) throws Exception  {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/propertiesFile/buyJourney.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(Key);	
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}


}
