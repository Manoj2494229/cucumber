package API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;

import Utitlities.apiCall;
import io.cucumber.java.en.Given;
import payload.leadJourney_payload;

public class leadJourney {
	//initialise logger
	Logger log = LogManager.getLogger("StepDef1");
	static String leadId = "";

	@Given("fill lead form with {string}, {string}, {string}, {string}, {string}, {string} details in UAT")
	public void fill_lead_form_with_details_in_uat(String string, String string2, String string3, String string4, String string5, String string6) {

		//generate unique lead id 
		Faker faker = new Faker();
		leadId = faker.number().digits(10);

		//base url
		String  baseuri = "https://webserver-vil-sit.lfr.cloud/o/vil-headless-create-order/v1.0/clickOutWebhook";
		//		apiCall.post(baseuri, leadJourney_payload.payload(leadId , string , string2, string3, string4, string5));
		log.info("chrome browser test_one" +leadId);
	}

	@Given("hit the clickOutWebhook_APPLICATION_STATUS_UPDATION with {string} and {string} in UAT")
	public void hit_the_click_out_webhook_application_status_updation_with_and_in_uat(String string, String string2) {
		System.out.println(leadId);

	}

	@Given("with the help of unique lead ID fetch create order API response from DB")
	public void with_the_help_of_unique_lead_id_fetch_create_order_api_response_from_db() {

		System.out.println("strp 3");
		System.out.println(leadId);
	}

	@Given("fetch orderID from response and hit getOrderDetails API and check leadDisplayStatus and orderStatus")
	public void fetch_order_id_from_response_and_hit_get_order_details_api_and_check_lead_display_status_and_order_status() {

		System.out.println("strp 4");
		System.out.println(leadId);
	}

	@Given("store status, substatus, leadDisplayStatus, orderStatus in Excel")
	public void store_status_substatus_lead_display_status_order_status_in_excel() {
		System.out.println("strp 5");
		System.out.println(leadId);

	}



}
