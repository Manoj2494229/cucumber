package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;

import Utitlities.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class leadFormApproved extends base{
	WebDriver driver = Login.driver;

	@Given("the user Click on Partner Management tab")
	public void the_user_click_on_partner_management_tab() throws Exception {
		System.out.println("the_user_click_on_partner_management_tab");
		Thread.sleep(1000);
		// Click on "Partner Management"
		clickElement(driver, By.xpath("//a[normalize-space()='Partner Management']"));
		//reporter("Click on \"Partner Management\"");

	}

	@Given("Click on Partner Leads Task tab")
	public void click_on_partner_leads_task_tab() throws Exception{
		System.out.println("click_on_partner_leads_task_tab");
		// Click on "Partner Leads Task"
		clickElement(driver, By.xpath("//a[normalize-space()='Partner Leads Task']"));
		reporter("Click on \"Partner Leads Task");
	}

	@Given("Click on Assigned To My Roles")
	public void click_on_assigned_to_my_roles() throws Exception{
		System.out.println("click_on_assigned_to_my_roles");
		// Click on "Assigned To My Roles"
		Thread.sleep(4000);
		clickElement(driver, By.xpath("//span[normalize-space()='Assigned To My Roles']"));
		reporter("Click on \"Assigned To My Roles\"");
	}

	@Given("Click on Assign To Me")
	public void click_on_assign_to_me() throws Exception{
		System.out.println("click_on_assign_to_me");
		// Click on "Assign To Me"
		Thread.sleep(4000);
		clickElement(driver, By.xpath("//*[@class='lexicon-icon lexicon-icon-ellipsis-v']"));
		reporter("Click on \"Assign To Me\"");
		Thread.sleep(4000);
		clickElement(driver, By.xpath("//a[contains(text(),'Assign')]"));
		reporter("Click on Assign");
		Thread.sleep(3000);
		// Click on "Assigned To Me"
		clickElement(driver, By.xpath("//span[normalize-space()='Assigned To Me']"));
		reporter("Click on \"Assigned To Me\"");
		Thread.sleep(4000);
	}

	@Given("Click on Approve\\/Reject")
	public void click_on_approve_reject() throws Exception{
		System.out.println("click_on_approve_reject");
		// Click on "Approve/Reject"
		clickElement(driver, By.xpath("//*[@class='lexicon-icon lexicon-icon-ellipsis-v']"));
		reporter("Click on \"Approve/Reject\"");
		Thread.sleep(4000);
		clickElement(driver, By.xpath("//a[normalize-space()='Approve/Reject']"));
		reporter("Click on Approve/Reject");
	}

	@Given("Click on Comments Require")
	public void click_on_comments_require() throws Exception{
		System.out.println("click_on_comments_require");
		// Scroll down
		scrollDown(driver);

		// Click on "Comments Require"
		clickElement(driver, By.xpath("//textarea[@id='_com_vil_partner_lead_web_PartnerLeadApprovalPortlet_INSTANCE_js9XNuQaqVYX_comment_area']"));
		reporter("Click on \"Comments Require\"");
	}

	@Given("Enter {string} into Comments Require")
	public void enter_into_comments_require(String string) throws Exception{
		System.out.println("enter_into_comments_require");
		// Enter "approved" into "Comments Require"
		enterText(driver, By.xpath("//textarea[@id='_com_vil_partner_lead_web_PartnerLeadApprovalPortlet_INSTANCE_js9XNuQaqVYX_comment_area']"), "approved");
		reporter("Enter \"approved\" into \"Comments Require\"");
	}

	@Given("Click on Submit")
	public void click_on_submit() throws Exception{
		System.out.println("click_on_submit");
		// Click on "Submit"
		clickElement(driver, By.xpath("//span[@class='lfr-btn-label']"));
		reporter("Click on \"Submit\"");
	}

	@Then("Click on YES")
	public void click_on_yes() throws Exception{
		System.out.println("click_on_yes");
		// Click on "YES"
		clickElement(driver, By.xpath("//button[normalize-space()='YES']"));
		reporter("Click on \"YES\"");
		Thread.sleep(3000);
	}



















}
