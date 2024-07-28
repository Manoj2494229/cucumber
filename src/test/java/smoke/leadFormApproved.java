package smoke;

import Utitlities.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class leadFormApproved extends base{
	
	
	@Given("the user Click on Partner Management tab")
	public void the_user_click_on_partner_management_tab() {
		System.out.println("the_user_click_on_partner_management_tab");
		
		
		log("the_user_click_on_partner_management_tab");
	}

	@Given("Click on Partner Leads Task tab")
	public void click_on_partner_leads_task_tab() {
		System.out.println("click_on_partner_leads_task_tab");
	}

	@Given("Click on Assigned To My Roles")
	public void click_on_assigned_to_my_roles() {
		System.out.println("click_on_assigned_to_my_roles");
	}

	@Given("Click on Assign To Me")
	public void click_on_assign_to_me() {
		System.out.println("click_on_assign_to_me");
	}

	@Given("Click on Approve\\/Reject")
	public void click_on_approve_reject() {
		System.out.println("click_on_approve_reject");
	}

	@Given("Click on Comments Require")
	public void click_on_comments_require() {
		System.out.println("click_on_comments_require");
	}

	@Given("Enter {string} into Comments Require")
	public void enter_into_comments_require(String string) {
		System.out.println("enter_into_comments_require");
	}

	@Given("Click on Submit")
	public void click_on_submit() {
		System.out.println("click_on_submit");
	}

	@Then("Click on YES")
	public void click_on_yes() {
		System.out.println("click_on_yes");
	}
}
