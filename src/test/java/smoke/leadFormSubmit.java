package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import Utitlities.ConfigListner;
import Utitlities.base;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class leadFormSubmit extends base{
	WebDriver driver ;
	
	@Given("the user opens the website {string}")
	public void the_user_opens_the_website(String string) throws Exception {
		driver = base.openTerminal(string);
		System.out.println("the_user_opens_the_website");
		
		reporter("the_user_opens_the_website = "+string);
	}

	@When("the user clicks on Sign Up Button")
	public void the_user_clicks_on_sign_up_button() throws Exception {
		clickElement(driver, By.xpath("//a[normalize-space()='Sign Up']"));
		System.out.println("the_user_clicks_on_sign_up_button");
	}

	@When("the user enters {string} into company\\/legal entity name Required")
	public void the_user_enters_into_company_legal_entity_name_required(String string) throws Exception {
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_companylegalName']"), ConfigListner.getLoginConfigData("username"));
		System.out.println("the_user_enters_into_company_legal_entity_name_required");
	}

	@When("the user enters {string} into business address {int} Required")
	public void the_user_enters_into_business_address_required(String string, Integer int1) throws Exception {
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_registeredAddress"+int1+"']"), string);
		System.out.println("the_user_enters_into_business_address_required");
	}

	@When("the user enters {string} into pin code Required")
	public void the_user_enters_into_pin_code_required(String string) throws Exception {
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_pinInput']"), string);
		
		System.out.println("the_user_enters_into_pin_code_required");
	}

	@When("the user enters {string} into contact person name Required")
	public void the_user_enters_into_contact_person_name_required(String string) throws Exception {
		
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_contactPersonName']"), string);
		System.out.println("the_user_enters_into_contact_person_name_required");
	}

	@When("the user enters {string} into official email id Required")
	public void the_user_enters_into_official_email_id_required(String string) throws Exception {
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_officialEmailId']"), "Regression"+generateRandomMob(3)+"@TCS.COM");
		System.out.println("the_user_enters_into_official_email_id_required");
	}

	@When("the user enters {string} into mobile number Required")
	public void the_user_enters_into_mobile_number_required(String string) throws Exception {
		enterText(driver, By.xpath("//input[@id='_com_vil_partner_lead_registration_VilLeadFormPortlet_INSTANCE_dsym_mobileNumber']"), generateRandomMob(10));
		System.out.println("the_user_enters_into_mobile_number_required");
	}

	@When("the user selects {string}")
	public void the_user_selects(String string) throws Exception{
		//Enter Captcha Detail
		Thread.sleep(5000);
		System.out.println("the_user_selects");
	}

	@When("the user enters Text into Text Verification Required")
	public void the_user_enters_text_into_text_verification_required() throws Exception{
		Thread.sleep(5000);
		System.out.println("the_user_enters_text_into_text_verification_required");
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string) throws Exception{
		if(string.equalsIgnoreCase("Submit"))
		{
			// Step 10: Click on "Submit"
			clickElement(driver, By.xpath("//span[@class='lfr-btn-label']"));
			Thread.sleep(1000);
		}else
		{
			// Step 11: Click on "YES"
			clickElement(driver, By.xpath("//button[normalize-space()='YES']"));
		}
		System.out.println("the_user_clicks_on");
	}

	@Then("the form should be submitted successfully")
	public void the_form_should_be_submitted_successfully() throws Exception{

		System.out.println("the_form_should_be_submitted_successfully");
		driver.close();
	}
	
	//screenshot 
	@AfterStep
	public void doSomethingAfterStep(Scenario scenario) throws Exception{
		Thread.sleep(500);
		System.out.println("screenshot " +scenario.getName());
		reporter("AfterStep = "+scenario.getName());
		//sscapture();
		
	}

}
