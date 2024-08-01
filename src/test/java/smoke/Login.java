package smoke;

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
		driver = base.setUp(string);
		log("open_the_website." +string);
		System.out.println("open_the_website 2");
	}

	@When("Enter {string} into enter email mobile and click on OTP")
	public void enter_into_enter_email_mobile_and_click_on_otp(String string) {
		System.out.println("enter_into_enter_email_mobile_and_click_on_otp" +string);
	}

	@When("Enter four time {string} into OTP section")
	public void enter_four_time_into_otp_section(String string) {
		System.out.println("enter_four_time_into_otp_section");
	}

	@Then("Click on the verify & login button")
	public void click_on_the_verify_login_button() {
		System.out.println("click_on_the_verify_login_button");
	}
}
