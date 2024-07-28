package smoke;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class leadFormSubmit {
	@Given("the user opens the website {string}")
	public void the_user_opens_the_website(String string) {
		System.out.println("the_user_opens_the_website = Manoj");
		
		
	}

	@When("the user clicks on Sign Up Button")
	public void the_user_clicks_on_sign_up_button() {
		System.out.println("the_user_clicks_on_sign_up_button");
	}

	@When("the user enters {string} into company\\/legal entity name Required")
	public void the_user_enters_into_company_legal_entity_name_required(String string) {
		System.out.println("the_user_enters_into_company_legal_entity_name_required");
	}

	@When("the user enters {string} into business address {int} Required")
	public void the_user_enters_into_business_address_required(String string, Integer int1) {
		System.out.println("the_user_enters_into_business_address_required");
	}

	@When("the user enters {string} into pin code Required")
	public void the_user_enters_into_pin_code_required(String string) {
		System.out.println("the_user_enters_into_pin_code_required");
	}

	@When("the user enters {string} into contact person name Required")
	public void the_user_enters_into_contact_person_name_required(String string) {
		System.out.println("the_user_enters_into_contact_person_name_required");
	}

	@When("the user enters {string} into official email id Required")
	public void the_user_enters_into_official_email_id_required(String string) {
		System.out.println("the_user_enters_into_official_email_id_required");
	}

	@When("the user enters {string} into mobile number Required")
	public void the_user_enters_into_mobile_number_required(String string) {
		System.out.println("the_user_enters_into_mobile_number_required");
	}

	@When("the user selects {string}")
	public void the_user_selects(String string) {
		System.out.println("the_user_selects");
	}

	@When("the user enters Text into Text Verification Required")
	public void the_user_enters_text_into_text_verification_required() {
		System.out.println("the_user_enters_text_into_text_verification_required");
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string) {
		System.out.println("the_user_clicks_on");
	}

	@Then("the form should be submitted successfully")
	public void the_form_should_be_submitted_successfully() {
		System.out.println("the_form_should_be_submitted_successfully");
	}
}
