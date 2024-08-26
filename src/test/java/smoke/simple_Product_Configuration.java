package smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Utitlities.ConfigListner;
import Utitlities.ExtentReportListners;
import Utitlities.base;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class simple_Product_Configuration extends base{



	
	   WebDriver driver = Login.driver;
	





	@When("the user clicks on the Product List tab")
	public void the_user_clicks_on_the_product_list_tab() throws Exception {

		reporter("Click on \"Product Management\" Page");
		clickElement(driver, By.xpath("//a[normalize-space()='Product Management']"));

		// Click on "Product List" link
		reporter("Click on \"Product List\" link");
		clickElement(driver, By.xpath("//a[normalize-space()='Product List']"));
	}

	@When("the user clicks on the New button to create a new product")
	public void the_user_clicks_on_the_new_button_to_create_a_new_product() throws Exception {
		// Click on the "New" button to create a new product
		reporter("Click on the \"New\" button to create a new product");
		clickElement(driver, By.xpath("//*[@class='lexicon-icon lexicon-icon-plus']"));
	}

	@When("the user clicks on the Simple button to select the product type")
	public void the_user_clicks_on_the_simple_button_to_select_the_product_type() throws Exception {
		// Click on the "Simple" button to select the product type
		reporter("Click on the \"Simple\" button to select the product type");
		clickElement(driver, By.xpath("//button[normalize-space()='Simple']"));
	}

	@When("the user enters {string} into the Type Here field and clicks on")
	public void the_user_enters_into_the_type_here_field_and_clicks_on(String string) throws Exception {
		// Enter "Shoppers Stop (15101)" into "Type Here"
		reporter("Enter \"Shoppers Stop (15101)\" into \"Type Here\"");
		// Switch to the iframe by index
		WebElement iframeElement = driver.findElement(By.xpath("//div[@class='fds-modal-body modal-body modal-body-iframe']//iframe"));

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		enterText(driver, By.xpath("//input[@placeholder='Type Here']"), "Shoppers Stop (15101)");

		// Click on "Shoppers Stop (15101)"
		reporter("Click on \"Shoppers Stop (15101)\"");
		clickElement(driver, By.xpath("//button[normalize-space()='Shoppers Stop (15101)']"));
	}

	@When("the user clicks on Category Requir dropdown and selects {string} from the Category Requir dropdown")
	public void the_user_clicks_on_category_requir_dropdown_and_selects_from_the_category_requir_dropdown(String string) throws Exception {
		// Click on "Category Requir"
		reporter("Click on \"Category Require\"");
		clickElement(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_partnerCategory']"));

		// Select "Entertainment > OTT" into "Category Requir"
		reporter("Select \"Entertainment > OTT\" into \"Category Require\"");
		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_partnerCategory']"), "Entertainment > OTT");
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_on_the_button(String string) throws Exception {
		// Click on submit
		reporter("Click on submit");
		clickElement(driver, By.xpath("//button[normalize-space()='Submit']"));
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}

	@Then("the user should see the product details page")
	public void the_user_should_see_the_product_details_page() throws Exception {

	}

	@When("the user clicks on the Details button")
	public void the_user_clicks_on_the_details_button() throws Exception {
		//Click on details Button 
		clickElement(driver, By.xpath("//a[@class='nav-link active']"));
		Thread.sleep(3000);
//		clickElement(driver, By.xpath("//span[normalize-space()='Media']"));
//		Thread.sleep(3000);
//		clickElement(driver, By.xpath("//button[@title='Add Image']"));
//		Thread.sleep(3000);
//
//		WebElement iframeElement_1 = driver.findElement(By.xpath("//div[@role='tabpanel']//iframe"));
//
//		// Switch to the iframe
//		driver.switchTo().frame(iframeElement_1);
//		
//		////////////////////////////////////////////////////////////////////////////////////////////////////////
//		for(int i =1 ;i<=1 ;i++)
//		{
//			String ingUrl = "https://webserver-vil-uatnew.lfr.cloud/webdav/global/document_library/SIT%20Testing/image"+1+".jpg";
//			String imgLocationxpath = "//h3[normalize-space()='Add Image']";
//			String img = "https://webserver-vil-uatnew.lfr.cloud/webdav/global/document_library/VI%20Images/VV.png";
//			String Fromxpath = "//img[@src='https://webserver-vil-uatnew.lfr.cloud/webdav/global/document_library/SIT%20Testing/image"+i+".jpg']";
//			String Toxpath = "//div[@class='browse-image-controls']";
//			new uploadFile(driver, imgLocationxpath, ingUrl, Fromxpath, Toxpath);
//			Thread.sleep(3000);
//			enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_title']"), "Automation");
//			scrollDown(driver);
//			enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_priority']"), ""+i+"");
//			clickElement(driver, By.xpath("//span[normalize-space()='Submit for Workflow']"));
//			Thread.sleep(5000);
//		}
//		//Click on cancel Button
//		clickElement(driver, By.xpath("//span[normalize-space()='Cancel']"));
//
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//		// Switch to the Default iframe
//		driver.switchTo().defaultContent();
//
//
//		
//		
//		
//		
//		
		
	}

	@When("the user enters {string} into the Name Required field")
	public void the_user_enters_into_the_name_required_field(String string) throws Exception {
		// Enter "test" into "Name Required"
		reporter("Enter \"test\" into \"Name Required\"");
		//Explicit wait

		Thread.sleep(3000);
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_nameMapAsXML']"), ConfigListner.getLoginConfigData("PID"));
		// Click on tab
		reporter("Click on tab");
		pressTabKey(driver);
	}

	@When("the user enters {string} into the Short Description field")
	public void the_user_enters_into_the_short_description_field(String string) throws Exception {
		// Enter "test" into "Short Description"
		reporter("Enter \"test\" into \"Short Description\"");
		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_shortDescriptionMapAsXML']"), ConfigListner.getLoginConfigData("SHORT"));
	}

	@When("the user enters {string} into the Validity Duration field")
	public void the_user_enters_into_the_validity_duration_field(String string) throws Exception {
		// Enter "1" into "validity duration"
		reporter("Enter \"1\" into \"validity duration\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_validity']"), "1");
		// Click on tab
		reporter("Click on tab");
		pressTabKey(driver);
	}

	@When("the user selects {string} from the Validity Requir dropdown")
	public void the_user_selects_from_the_validity_requir_dropdown(String string) throws Exception {
		// Click on "validity Requir"
		reporter("Click on \"validity Require\"");
		clickElement(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_validityType']"));

		// Click on tab
		pressTabKey(driver);

		// Select "Year" into "validity Requir"
		reporter("Select \"Year\" into \"validity Require\"");
		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_validityType']"), "Year");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_validity']"), "1");
		// Click on tab
		pressTabKey(driver);
	}

	@When("the user enters {string} into the Brand Name Requ field")
	public void the_user_enters_into_the_brand_name_requ_field(String string) throws Exception {
		// Enter "tata" into "Brand Name Requ"
		reporter("Enter \"tata\" into \"Brand Name Require\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_brandName']"), "TATA");

	}

	@When("the user enters {string} into the HSN\\/SAC Code field")
	public void the_user_enters_into_the_hsn_sac_code_field(String string) throws Exception {

		// Click on tab
		pressTabKey(driver);

		// Enter "11111" into "hsn/sac code Re"
		reporter("Enter \"11111\" into \"hsn/sac code Require\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_hsnSacCode']"), "123456");
	}

	@When("the user enters {string} into the terms & conditions field")
	public void the_user_enters_into_the_terms_conditions_field(String string) throws Exception {
		reporter("the_user_enters_into_the_terms_conditions_field");
		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_termsMapAsXML']"), "the_user_enters_into_the_terms_conditions_field");
	}

	@When("the user enters {string} into the How to Redeem field")
	public void the_user_enters_into_the_how_to_redeem_field(String string) throws Exception {
		reporter("the_user_enters_into_the_how_to_redeem_field");
		enterText(driver, By.xpath("//textarea[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_howToRedeem']"), "the_user_enters_into_the_how_to_redeem_field");
	}

	@When("the user enters {string} into the display order field")
	public void the_user_enters_into_the_display_order_field(String string) throws Exception {
		reporter("the_user_enters_into_the_display_order_field");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_displayOrder']"), "99999");
	}

	@When("the user enters {string} into the product of type field")
	public void the_user_enters_into_the_product_of_type_field(String string) throws Exception {
		reporter("the_user_enters_into_the_product_of_type_field");
		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_productOfType']"), "AmazonGiftCard");
	}

	@When("the user enters All {string} into the Specifications field")
	public void the_user_enters_all_into_the_specifications_field(String string) throws Exception {
		// Click on "Number of Devices"
		reporter("Click on \"Number of Devices\"");
		clickElement(driver, By.xpath("//a[normalize-space()='Number of Devices']"));

		// Switch to the iframe by index
		WebElement iframeElement_11 = driver.findElement(By.xpath("//div[@role='tabpanel']//iframe"));

		// Switch to the iframe
		driver.switchTo().frame(iframeElement_11);

		// Enter "1" into "_com_liferay_commerce_product_"
		//reporter("Enter \"1\" into \"_com_liferay_commerce_product_\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), ConfigListner.getLoginConfigData("NUMDV"));

		// Click on "Save"
		reporter("Click on \"Save\"");
		clickElement(driver, By.xpath("//span[normalize-space()='Save']"));
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		// Click on "Type of Devices"

		clickElement(driver, By.xpath("//a[normalize-space()='Type of Devices']"));

		// Switch to the iframe

		driver.switchTo().frame(iframeElement_11);

		// Enter "1" into "_com_liferay_commerce_product_"
		reporter("Enter \"1\" into Type of Devices\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), ConfigListner.getLoginConfigData("DV"));

		// Click on "Save"
		//reporter("");
		clickElement(driver, By.xpath("//span[normalize-space()='Save']"));
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		// Click on "Video Quality"
		reporter("Click on \"Video Quality\"");
		clickElement(driver, By.xpath("//a[normalize-space()='Video Quality']"));

		// Switch to the iframe
		driver.switchTo().frame(iframeElement_11);

		// Enter "1" into "_com_liferay_commerce_product_"
		reporter("Enter \"1\" into Video Quality\"");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_value']"), ConfigListner.getLoginConfigData("VC"));

		// Click on "Save"
		reporter("Click on \"Save\"");
		clickElement(driver, By.xpath("//span[normalize-space()='Save']"));

		// Click on "close icon"
		reporter("Click on \"close icon\"");
		Thread.sleep(2000);
		clickElement(driver, By.xpath("//button[@class='btn btn-unstyled side-panel-iframe-close']//*[name()='svg']"));

		driver.switchTo().defaultContent();
	}
	@When("the user Click on save draft Button")
	public void the_user_click_on_save_draft_button() throws Exception{
		// Scroll up
		scrollUp(driver);

		// Click on "save draft"
		reporter("Click on \"save draft\"");
		clickElement(driver, By.xpath("//a[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_saveAsDraftButton']"));
		Thread.sleep(5000);
	}

	@When("the user clicks on the sku tab")
	public void the_user_clicks_on_the_sku_tab() throws Exception{
		// Click on "go to sku"
		reporter("Click on \"go to sku\"");
		clickElement(driver, By.xpath("//span[normalize-space()='SKUs']"));
	}

	@When("the user Click on add SKU button")
	public void the_user_click_on_add_sku_button() throws Exception{
		// Click on "add SKU"
		reporter("Click on \"add SKU\"");
		clickElement(driver, By.xpath("//button[@title='Add SKU']"));
	}

	@When("the user enters {string} into the SKU NAME field")
	public void the_user_enters_into_the_sku_name_field(String string) throws Exception{
		// Switch to the iframe
		WebElement iframeElement_2 = driver.findElement(By.xpath("//div[@role='tabpanel']//iframe"));
		Thread.sleep(2000);
		driver.switchTo().frame(iframeElement_2);

		// ADD SKU NAME
		reporter("ADD SKU NAME");
		Thread.sleep(2000);
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_sku']"),generateRandomString(10));
	}

	@When("the user Click on Purchasable button")
	public void the_user_click_on_purchasable_button() throws Exception{
		// Click on "Purchasable"
		reporter("Click on \"Purchasable\"");
		clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_purchasable']"));
	}

	@When("the user selects partner from the partner dropdown")
	public void the_user_selects_partner_from_the_partner_dropdown() throws Exception{
		//select partner
		reporter("select partner Shoppers Stop (230800021) ");
		selectOption(driver, By.xpath("//select[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_partnerCatalog']"), "Shoppers Stop (230800021)");


	}

	@When("the user enters inventory into the inventory field")
	public void the_user_enters_inventory_into_the_inventory_field() throws Exception{
		//Enter inventory
		reporter("Enter inventory 1000");
		clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_quantity']"));
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_quantity']"), "1000");
	}

	@When("the user enters base PRICE into the Base Price field like {string}")
	public void the_user_enters_base_price_into_the_base_price_field_like(String string) throws Exception{
		//Enter base
		reporter("Enter base price 1000");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_price']"), ""+1000);
	}

	@When("the user enters promo Price into the Promo Price field like {string}")
	public void the_user_enters_promo_price_into_the_promo_price_field_like(String string) throws Exception{
		//Enter @param
		reporter("Enter promo price 500");
		enterText(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_promoPrice']"), ""+500);
	}

	@When("the user Click on Submit For Publication button")
	public void the_user_click_on_submit_for_publication_button() throws Exception{
		// Click on "Submit For Publication"
		reporter(" Click on \"Submit For Publication\"");
		clickElement(driver, By.xpath("//span[normalize-space()='Submit for Publication']"));
	}

	@When("the user Click on close button")
	public void the_user_click_on_close_button() throws Exception{
		// Click on "close"
		reporter("Click on \"close\"");
		Thread.sleep(2000);
		clickElement(driver, By.xpath("//button[@class='btn btn-unstyled side-panel-iframe-close']//*[name()='svg']"));
		driver.switchTo().defaultContent();
	}

	@When("the user Click on Details button")
	public void the_user_click_on_details_button() throws Exception{
		// Click on "Details"
		reporter("Click on \"Details\"");
		clickElement(driver, By.xpath("//span[normalize-space()='Details']"));
	}

	@When("the user select checkbox on never expiry button")
	public void the_user_select_checkbox_on_never_expiry_button() throws Exception{
		Thread.sleep(1000);
		// Click on "never expiry"
		reporter(" Click on \"Details\"");
		if(driver.findElement(By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_fmexpirationDate']")).isSelected())
		{
			System.out.println("The_user_select_checkbox_on_never_expiry_button --> already selected ");
		}else
		{
			clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_fmexpirationDate']"));
		}
		
	}

	@When("the user select checkbox on Publish button")
	public void the_user_select_checkbox_on_publish_button() throws Exception{
		// Click on "Publish"
		reporter(" Click on \"Details\"");
		clickElement(driver, By.xpath("//input[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_published']"));
	}

	@When("the user Click on Submit button")
	public void the_user_click_on_submit_button() throws Exception{
		// Click on "Submit"
		reporter("Click on \"Submit\"");
		clickElement(driver, By.xpath("//a[@id='_com_liferay_commerce_product_definitions_web_internal_portlet_CPDefinitionsPortlet_publishButton']"));
		Thread.sleep(1000);
	}


	@Then("the product should be created successfully")
	public void the_product_should_be_created_successfully() throws Exception {
		Thread.sleep(1000);
		reporter("\"Submit Success\"");
		Thread.sleep(4000);
		
	}
}
