package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utitlities.ConfigListner;
import Utitlities.base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class discount_Management extends base{

	@When("I click on Discount Management")
	public void i_click_on_discount_management() throws Exception {

		clickElement(driver, By.xpath("//a[normalize-space()='Discount Management']"));
		reporter("Click on \"Discount Management\"");
	}

	@When("I click on Discount List")
	public void i_click_on_discount_list() throws Exception {
		Thread.sleep(2000);
		// Click on \"Discount List\"

		clickElement(driver, By.xpath("//a[normalize-space()='Discount List']"));
		reporter("Click on \"Discount List\"");

	}

	@When("I click on New")
	public void i_click_on_new() throws Exception {
		Thread.sleep(2000);
		// Click on "New""

		clickElement(driver, By.xpath("//*[@class='lexicon-icon lexicon-icon-plus']"));
		reporter("Click on \"New\"");

	}

	@When("I enter {string} into Name Required")
	public void i_enter_into_name_required(String string) throws Exception {
		Thread.sleep(2000);

		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='_com_vil_commerce_discount_management_web_VilCommerceDiscountManagementWebPortlet_dialog_iframe_']"));

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);
		// Enter "discount_product" into "Name Required"

		enterText(driver, By.xpath("//input[@id='title']"), string);
		Thread.sleep(1000);
		reporter("Enter \"discount_product\" into \"Name Required\"");

	}

	@When("I select Discount from Type Required")
	public void i_select_discount_from_type_required() throws Exception {
		// select"Discount" into "Type Required"

		selectOption(driver, By.xpath("//select[@id='type']"), "Discount");
		Thread.sleep(1000);
		reporter("select\"Discount\" into \"Type Required\"");

	}

	@When("I select Total from Apply To Required")
	public void i_select_total_from_apply_to_required() throws Exception {
		// Click on "Type Required"

		selectOption(driver, By.xpath("//select[@id='commerceDiscountTarget']"), "SKUs");
		Thread.sleep(1000);
		reporter("Click on \"Type Required\"");
	}

	@When("I select {string} from Click on Type")
	public void i_select_from_click_on_type(String string) throws Exception {

		selectOption(driver, By.xpath("//select[@id='commerceDiscountType']"), string);
		reporter("i_select_from_click_on_type");
	}

	@When("I Click on Submit")
	public void i_click_on_submit() throws Exception {
		Thread.sleep(1000);

		clickElement(driver, By.xpath("//button[normalize-space()='Submit']"));
		driver.switchTo().defaultContent();
		reporter("Click on \"Submit\"");
	}

	@When("I enter Percentage Discount into Description Required")
	public void i_enter_percentage_discount_into_description_required() throws Exception {
		Thread.sleep(1000);

		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_description']"), ConfigListner.discount("description"));
		reporter("Enter the description ");


	}

	@When("I select Type from Percentage")
	public void i_select_type_from_percentage() throws Exception {
		Thread.sleep(1000);

		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_target']"), "Total");
		reporter("Click on \"Total\"");

	}

	@When("I enter {string} into Amount Required")
	public void i_enter_into_amount_required(String string) throws Exception {
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_amount']"), ConfigListner.discount("amount"));
		reporter("Enter the discount amount ");


	}

	@When("I click on the coupon toggle switch")
	public void i_click_on_the_coupon_toggle_switch() throws Exception {
		Thread.sleep(1000);

		clickElement(driver, By.xpath("//span[@id='rght___toggle-switch']//span[@class='toggle-switch-bar']"));
		reporter("click on coupen toggle switch ");

	}

	@When("I enter {string} into Coupon Code")
	public void i_enter_into_coupon_code(String string) throws Exception {
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_couponCode']"),  string.concat(generateRandomString(10)) );
		reporter("Enter coupen Code");

	}

	@When("I click and enter {string} into Maximum Total Uses")
	public void i_click_and_enter_into_maximum_total_uses(String string) throws Exception {
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_limitationTimes']"),  "1000");
		reporter("Enter Max Count");

	}

	@When("I click and enter {string} into Maximum Uses Per Account")
	public void i_click_and_enter_into_maximum_uses_per_account(String string) throws Exception {
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_limitationTimesPerAccount']"), "1000");
		reporter("Enter Max User Count");

	}

	@When("I click on Active")
	public void i_click_on_active() throws Exception {
		scrollUp(driver);
		scrollUp(driver);
		Thread.sleep(1000);

		clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_active']"));
		reporter("Enter Active Switch");

	}

	@When("I click on Submit for Workflow")
	public void i_click_on_submit_for_workflow() throws Exception {
		Thread.sleep(1000);
		//clickElement(driver, By.xpath("//a[@id='header-action_dlys__']"));



		clickElement(driver, By.xpath("//a[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_publishButton']"));
		Thread.sleep(3000);
		reporter("Enter Submit Button");

	}

	@Then("I click on Active to set it to In-active")
	public void i_click_on_active_to_set_it_to_in_active() throws Exception {
		Thread.sleep(4000);

		clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_active']"));
		reporter("Enter Active and close Button");

	}



	@When("I enter Fixed Amount into Description Required")
	public void i_enter_fixed_amount_into_description_required() throws Exception {

		Thread.sleep(1000);

		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_description']"), ConfigListner.discount("description"));
		reporter("Enter the description ");


	}

	@When("I select Type from Fixed Amount")
	public void i_select_type_from_fixed_amount() throws Exception {
		Thread.sleep(1000);

		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_target']"), "Total");
		reporter("Click on \"Total\"");

	}

	@When("I enter BuyX-GetY into Name Required")
	public void i_enter_buy_x_get_y_into_name_required() throws Exception {
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='_com_vil_commerce_discount_management_web_VilCommerceDiscountManagementWebPortlet_dialog_iframe_']"));


		// Switch to the iframe
		driver.switchTo().frame(iframeElement);


		// Enter "discount_product" into "Name Required"

		enterText(driver, By.xpath("//input[@id='title']"), "Buy_x_Get_Y_Discount");
		reporter("Enter \"discount_product\" into \"Name Required\"   Buy_x_Get_Y_Discount");

	}

	@When("I select BuyX-GetY from Apply To Required")
	public void i_select_buy_x_get_y_from_apply_to_required() throws Exception {
		Thread.sleep(1000);
		// select"Discount" into "Type Required"

		selectOption(driver, By.xpath("//select[@id='type']"), "Discount");
		reporter("select\"Discount\" into \"Type Required\"");
		Thread.sleep(1000);
		// Click on "Type Required"

		selectOption(driver, By.xpath("//select[@id='commerceDiscountTarget']"), "BuyX-GetY");
		reporter("Click on \"Type Required\"");
		Thread.sleep(1000);

		Thread.sleep(1000);

		clickElement(driver, By.xpath("//button[normalize-space()='Submit']"));
		reporter("Click on \"Submit\"");
		driver.switchTo().defaultContent();



	}

	@When("I enter {string} into Description Required")
	public void i_enter_into_description_required(String string) throws Exception {

		Thread.sleep(1000);

		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_description']"), ConfigListner.discount("description"));
		reporter("Enter the description ");


	}

	@When("I enter buy X and Y value")
	public void i_enter_buy_x_and_y_value() throws Exception {
		//enter buy x value
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_buyx']"), "1");
		reporter("enter buy x value");

		//enter buy y value
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_pricing_web_internal_portlet_CommerceDiscountPortlet_gety']"), "1");
		reporter("enter buy y value");

	}

	@When("I enter {string} into Find a SKU and select the SKU")
	public void i_enter_into_find_a_sku_and_select_the_sku(String string) throws Exception {
		//enter Find a SKU
		Thread.sleep(1000);

		enterText(driver, By.xpath("//input[@placeholder='Find a SKU']"), "1126726");
		reporter("enter Find a SKU");

		//select SKU
		Thread.sleep(1000);

		clickElement(driver, By.xpath("(//button[@type='button'][normalize-space()='Select'])[1]"));

		//select SKU
		Thread.sleep(1000);
		reporter("select SKU");
		clickElement(driver, By.xpath("//div[@class='expose__backdrop']"));
		scrollUp(driver);
		scrollUp(driver);
		Thread.sleep(1000);

	}

}
