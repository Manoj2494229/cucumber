package Utitlities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;
import com.relevantcodes.extentreports.LogStatus;

public class Help extends ExtentReportListners{
	static base bs = new base();

	public static void clickElement(WebDriver driver, final By locator) throws Exception {
		
		
		// explicit wait - to wait for the compose button to be click-able
//		WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		webdwait.until(ExpectedConditions.elementToBeClickable(locator));

		base.log("clickElement " +locator);
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(10000)) // this defines the total amount of time to wait for
				.pollingEvery(Duration.ofMillis(100)) // this defines the polling frequency
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore 

		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver)  //in this method defined your own subjected conditions for which we need to wait for
			{  
				return driver.findElement(locator);
			}
		}
				);	

		//driver.navigate().refresh();

		Thread.sleep(1000);
		element.click();


	}

	public static void enterText(WebDriver driver, final By locator, String text)throws Exception  {


		base.log("enterText " +locator +" and message =  "+text);
		System.out.println(text);
		Help.clickElement(driver, locator);



		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofMillis(10000)) // this defines the total amount of time to wait for
				.pollingEvery(Duration.ofMillis(200)) // this defines the polling frequency
				.ignoring(NoSuchElementException.class); // this defines the exception to ignore 

		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver)  //in this method defined your own subjected conditions for which we need to wait for
			{  
				return driver.findElement(locator);
			}
		}
				);
		//		element.click();
		//		new Actions(driver)
		//		.moveToElement(element)
		//		.pause(Duration.ofSeconds(1))
		//		.clickAndHold()
		//		.pause(Duration.ofSeconds(1))
		//		.sendKeys(text)
		//		.perform();
		System.out.println(element.getText());
		
		
		
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		webdwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
		//Thread.sleep(1000);
		element.clear();
		element.click();
		int a = 0 ;
		if(text.contains("500"))
		{
			a = Integer.parseInt(text);
			element.sendKeys(String.valueOf(a));
			element.sendKeys(Keys.CONTROL+"A" , Keys.BACK_SPACE);
			element.clear();
			element.sendKeys("500");
		}else
		{
			element.sendKeys(text);
		}
	}
	public static void scrollDown(WebDriver driver)
	{
		base.log("scrollDown " +driver);
		// Scroll down
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN);
	}


	public static void selectOption(WebDriver driver, By locator, String option) {
		base.log("selectOption " +locator);
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(option);
	}

	public static void pressTabKey(WebDriver driver) {
		base.log("pressTabKey " +driver);
		driver.switchTo().activeElement().sendKeys("\t");
	}

	public static void scrollUp(WebDriver driver) {
		base.log("scrollUp " +driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -250)");
	}

	public static void Actions (WebDriver driver , By locator ,String text )
	{
		base.log("Actions " +locator);
		WebElement clickable = driver.findElement(locator);
		new Actions(driver)
		.moveToElement(clickable)
		.pause(Duration.ofSeconds(1))
		.clickAndHold()
		.pause(Duration.ofSeconds(1))
		.sendKeys(text)
		.perform();
		((RemoteWebDriver) driver).resetInputState();
	}

	public static String generateRandomString(int length) {

		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) 
		{
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}
		base.log("generateRandomString " +sb.toString());
		return sb.toString();
	}

	public static String generateRandomMob(int length) {
		String characters = "667788991234567890";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();

		for (int i = 0; i < length; i++) 
		{
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}
		base.log("generateRandomMob " +sb.toString());
		return sb.toString();
	}

	public static String firstname()
	{


		String[] FIRST_NAMES = {
				"John", "Emma", "Michael", "Olivia", "William", "Ava", "James", "Sophia", "Benjamin", "Isabella"
				// Add more first names to the array
		};
		Random random = new Random();

		// Generate a random index to select a first name from the array
		int randomIndex = random.nextInt(FIRST_NAMES.length);

		// Generate a random 6-digit PIN code
		int pinCode = random.nextInt(900000) + 100000;

		// Get the random first name
		String randomFirstName = FIRST_NAMES[randomIndex];

		return randomFirstName;

	}
	public static void reporter(String message) throws Exception
	{
		base.log("reporter " +message);
		test.log(LogStatus.INFO, "Log = "+ message);
		//System.out.println(message);
		Thread.sleep(200);
		sscapture();
	}


	public static void allOption(WebDriver driver, By locator , By iframeElement) throws Exception
	{
		List<WebElement> element = driver.findElements(locator);
		// Switch to the iframe by index

		int i = 0 ;
		for(i = 0 ;i<=element.size();i++)
		{
			element.get(i).click();
			System.out.println(element.get(i).getText());
			System.out.println(element.get(i).getText()+"test");
			// Switch to the iframe
			Thread.sleep(15000);

			//WebElement iframeElements = driver.findElement(By.xpath("//div[@role='tabpanel']//iframe"));

			Thread.sleep(15000);
			System.out.println(element.get(i).getText()+"test12");
			driver.switchTo().frame(driver.findElement(iframeElement));
			try {
				// Perform actions within the iframe
				System.out.println(element.get(i).getText()+"test123");
				Thread.sleep(5000);
				enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), ConfigListner.getLoginConfigData("NUMDV"));
				clickElement(driver, By.xpath("//span[normalize-space()='Save']"));
			} catch (StaleElementReferenceException e) {
				// Handle the StaleElementReferenceException
				// Refresh or re-locate the iframe or element
				System.out.println("Stale element reference exception occurred. Retrying...");
				WebElement iframeElement1 = driver.findElement(By.xpath("//div[@role='tabpanel']//iframe"));
				driver.switchTo().frame(iframeElement1);
				System.out.println(element.get(i).getText()+"test1231234567890");
				Thread.sleep(5000);
				enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), ConfigListner.getLoginConfigData("NUMDV"));
				clickElement(driver, By.xpath("//span[normalize-space()='Save']"));
			}
			//enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), "Test_ "+i+"");
			driver.switchTo().defaultContent();
			System.out.println(element.get(i).getText());
		}


	}
}
