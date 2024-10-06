package smoke;

import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class customer_Registration_Journey extends Help{

	static Response resp_manageCustomer;
	static Response resp_validateCustomer;
	static Response resp_recordConsent;
	String msidn = generateRandomMob(10);
	String termsConditionId = null;
	String version = null;
	String methodeName = null;

	String manageCustomer 	= 	"https://vishopuat.myvi.in/o/vil-headless-customer/v1.0/manageCustomer";
	String validateCustomer 	= 	"https://vishopuat.myvi.in/o/vil-headless-customer/v1.0/validateCustomer";
	String recordConsent 	= 	"https://vishopuat.myvi.in/o/vil-headless-customer/v1.0/recordConsent";




	@Given("the user enters VI_SHOP and completes validation")
	public void the_user_enters_vi_shop_and_completes_validation() throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		//reporterAPI(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(msidn);
		resp_manageCustomer = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageCustomer)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_manageCustomer(msidn)).
				when().
				post(manageCustomer);
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_manageCustomer(msidn),methodeName);
		logListner.writeRequestAndResponseInReport(resp_manageCustomer,methodeName);
	}

	@Given("the system determines if the user is new or existing and creates an entry for a new user using the validateCustomer API")
	public void the_system_determines_if_the_user_is_new_or_existing_and_creates_an_entry_for_a_new_user_using_the_validate_customer_api() throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		//reporterAPI(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(msidn);

		System.out.println(msidn);
		resp_validateCustomer = RestAssured.given().
				auth().
				oauth2(TokenListner.token(validateCustomer)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_validateCustomer(msidn)).
				when().
				post(validateCustomer);

		JsonPath output = new JsonPath(resp_validateCustomer.asString());
		termsConditionId = 		output.getString("data.termsConditionId");
		version = 		output.getString("data.version");

		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_validateCustomer(msidn),methodeName);
		logListner.writeRequestAndResponseInReport(resp_validateCustomer,methodeName);
	}

	@Given("the system ensures the user accepts the terms and conditions before entering VI_SHOP using the recordConsent API")
	public void the_system_ensures_the_user_accepts_the_terms_and_conditions_before_entering_vi_shop_using_the_record_consent_api() throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		reporterAPI(Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println(msidn);

		System.out.println(msidn);
		resp_recordConsent = RestAssured.given().
				auth().
				oauth2(TokenListner.token(recordConsent)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_recordConsent(msidn , termsConditionId ,version )).
				when().
				post(recordConsent);
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_recordConsent(msidn , termsConditionId ,version ),methodeName);
		logListner.writeRequestAndResponseInReport(resp_recordConsent,methodeName);
	}

}
