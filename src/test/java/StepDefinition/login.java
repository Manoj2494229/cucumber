package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
	@Given("Open website {string}")
	public void open_website(String string) {
		System.out.println(string);
	}

	@When("Enter {string} into enter email mobile")
	public void enter_into_enter_email_mobile(String string) {
		System.out.println(string);
	}

	@When("Click on OTP")
	public void click_on_otp() {
		System.out.println("click_on_otp");
	}

	@When("Enter {string} into \"OTP expired.")
	public void enter_into_otp_expired(String string) {
		System.out.println(string);
	}

	@Then("Click on verify & login")
	public void click_on_verify_login() {
		System.out.println("click_on_verify_login");
	}
	
	@Given("check page title")
	public void check_page_title() {
System.out.println("check_page_title");
	}

	@Given("read\\({string})")
	public void read(String string) {
		System.out.println(string);
	}
}
