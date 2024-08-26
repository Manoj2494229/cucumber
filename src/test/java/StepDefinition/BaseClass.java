package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Utitlities.ReadConfig;

import org.apache.logging.log4j.*;

/*Parent Class*/
public class BaseClass {
	public static  WebDriver driver;

	public static Logger log;
	public ReadConfig readConfig;
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
}
