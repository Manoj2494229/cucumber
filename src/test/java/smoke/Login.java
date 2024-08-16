package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utitlities.ConfigListner;
import Utitlities.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends base{
	WebDriver driver;

	@Given("Open the website {string}")
	public void open_the_website(String string) throws Exception {
		driver = base.openTerminal(string);
		System.out.println("open_the_website");
	}

	@When("Enter {string} into enter email mobile and click on OTP")
	public void enter_into_enter_email_mobile_and_click_on_otp(String string) throws Exception {
		System.out.println("enter_into_enter_email_mobile_and_click_on_otp" +string);

		//driver.navigate().back();
		driver.navigate().refresh();

		//Login Page
		driver.findElement(By.xpath("//input[@id='_com_liferay_login_web_portlet_LoginPortlet_login']")).sendKeys(ConfigListner.getConfigData("username"));

		//OTP
		driver.findElement(By.xpath("//a[@class='otps']")).click();
		Thread.sleep(500);


	}

	@When("Enter four time {string} into OTP section")
	public void enter_four_time_into_otp_section(String string) throws Exception {
		System.out.println("enter_four_time_into_otp_section");
		for(int i = 1 ; i<=4 ;i++)
		{
			Thread.sleep(200);
			driver.findElement(By.xpath("//input[@class='otp']["+i+"]")).sendKeys("1");

		}
	}

	@Then("Click on the verify & login button")
	public void click_on_the_verify_login_button() throws Exception {
		System.out.println("click_on_the_verify_login_button");
		Thread.sleep(200);
		driver.findElement(By.xpath("//a[@id='submit-otp-button']")).click();
	}
}
