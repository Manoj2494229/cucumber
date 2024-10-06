package smoke;

import Utitlities.ConfigListner;
import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class buy_Journey extends Help{
	static Response resp_add;
	static Response resp_UPSERT;
	static Response resp_checkout;
	static Response resp_update;
	static Response resp_getOrderDetails;
	static Response resp_getOrders;
	static Response resp_EXPRESS_CHECKOUT;
	static Response resp_managePromotion;
	String CID = null;
	String PID= null;
	String SID = null;
	String Discount = null;
	static String ecomid = null;
	static String msidn = null;
	static String orderItemId = null;
	static String productName = null;
	static String itemNetPrice = null;
	static String orderAmount = null;	
	String cardConvenienceFee = null;
	static double paymentAmount   = 0;
	String methodeName = null;


	String manageOrder 	= 	"https://vishopuat.myvi.in/o/vil-headless-manage-order/1.0.0/manageOrder";
	String updateOrder = 	"https://vishopuat.myvi.in/o/vil-headless-order/v1.0/updateOrder";
	String getOrderDetails = 	"https://vishopuat.myvi.in/o/vil-headless-order/v1.0/getOrderDetails";
	String getOrders = 	"https://vishopuat.myvi.in/o/vil-headless-order/v1.0/getOrders";
	String managePromotion =  "https://vishopuat.myvi.in/o/vil-headless-manage-order/1.0.0/managePromotion";


	@Before
	public void runBefore() throws Exception
	{
		this.CID = ConfigListner.readBuyJourneyConfig("customerId");
		this.PID = ConfigListner.readBuyJourneyConfig("productId");
		this.SID = ConfigListner.readBuyJourneyConfig("skuId");
		this.Discount = ConfigListner.readBuyJourneyConfig("promoId");
		this.cardConvenienceFee = ConfigListner.readBuyJourneyConfig("cardConvenienceFee");
	}
	@Given("the user adds a product to the cart using the manageOrder API")
	public void the_user_adds_a_product_to_the_cart_using_the_manage_order_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_add = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageOrder)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_add(CID , "add","-1" ,PID , SID)).
				when().
				post(manageOrder);

		JsonPath output = new JsonPath(resp_add.asString());
		ecomid = 		output.getString("data.ecommOrderId");
		msidn = 		output.getString("data.customerMSISDN");

		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_add(CID , "add","-1" ,PID , SID),methodeName);
		logListner.writeRequestAndResponseInReport(resp_add,methodeName );
	}

	@Given("the user adds a product to the cart using the Buy Now button through the manageOrder API")
	public void the_user_adds_a_product_to_the_cart_using_the_buy_now_button_through_the_manage_order_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_EXPRESS_CHECKOUT = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageOrder)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_add(CID , "EXPRESS_CHECKOUT","-1" ,PID , SID)).
				when().
				post(manageOrder);
		
		JsonPath output = new JsonPath(resp_EXPRESS_CHECKOUT.asString());
		ecomid = 		output.getString("data.ecommOrderId");
		msidn = 		output.getString("data.customerMSISDN");

		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_add(CID , "EXPRESS_CHECKOUT","-1" ,PID , SID),methodeName);
		logListner.writeRequestAndResponseInReport(resp_EXPRESS_CHECKOUT,methodeName);
	}

	@Given("the user updates or adds the delivery address using the manageOrder API")
	public void the_user_updates_or_adds_the_delivery_address_using_the_manage_order_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_UPSERT = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageOrder)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_UPSERT(ecomid, CID, msidn)).
				when().
				post(manageOrder);

		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_UPSERT(ecomid, CID, msidn),methodeName);
		logListner.writeRequestAndResponseInReport(resp_UPSERT,methodeName);

	}

	@Given("the user applies a discount to the cart total using the managePromotion API")
	public void the_user_applies_a_discount_to_the_cart_total_using_the_manage_promotion_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_managePromotion = RestAssured.given().
				auth().
				oauth2(TokenListner.token(managePromotion)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_managePromotion(CID ,ecomid,  Discount)).
				when().
				post(managePromotion);

		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_managePromotion(CID ,ecomid,  Discount),methodeName);
		logListner.writeRequestAndResponseInReport(resp_managePromotion,methodeName);

	}

	@Given("the user selects the Checkout option using the manageOrder API")
	public void the_user_selects_the_checkout_option_using_the_manage_order_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_checkout = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageOrder)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_add(CID , "checkout" ,ecomid ,PID , SID)).
				when().
				post(manageOrder);

		JsonPath checkout = new JsonPath(resp_checkout.asString());
		productName = 		checkout.getString("data.orderItems[0].productName");
		itemNetPrice = 		checkout.getString("data.orderItems[0].itemNetPrice");
		orderAmount = 		checkout.getString("data.orderAmount");
		orderItemId = 		checkout.getString("data.orderItems[0].orderItemId");


		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_add(CID , "checkout" ,ecomid ,PID , SID),methodeName);
		logListner.writeRequestAndResponseInReport(resp_checkout,methodeName);
	}

	@Given("the user receives an updated order status from the partner using the updateOrder API")
	public void the_user_receives_an_updated_order_status_from_the_partner_using_the_update_order_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		paymentAmount = Double.parseDouble(cardConvenienceFee) + Double.parseDouble(orderAmount);
		String totalPaymentAmount  = String.valueOf(paymentAmount);

		resp_update = RestAssured.given().
				auth().
				oauth2(TokenListner.token(updateOrder)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_UPDATE( CID , msidn , ecomid , productName , totalPaymentAmount , cardConvenienceFee , orderAmount ,orderItemId)).
				when().
				post(updateOrder);

		JsonPath output3 = new JsonPath(resp_update.asString());
		System.out.println(output3.prettify());


		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_UPDATE( CID , msidn , ecomid , productName , totalPaymentAmount , cardConvenienceFee , orderAmount ,orderItemId),methodeName);
		logListner.writeRequestAndResponseInReport(resp_update,methodeName);
	}

	@Then("the user verifies the order status using the getOrderDetails API")
	public void the_user_verifies_the_order_status_using_the_get_order_details_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getOrderDetails = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getOrderDetails)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_getOrderDetails(ecomid)).
				when().
				post(getOrderDetails);
		
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_getOrderDetails(ecomid),methodeName);
		logListner.writeRequestAndResponseInReport(resp_getOrderDetails,methodeName);
	}

	@Then("the user confirms the order is listed in their order history using the getOrders API")
	public void the_user_confirms_the_order_is_listed_in_their_order_history_using_the_get_orders_api() throws Exception {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getOrders = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getOrders)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_getOrders(ecomid, CID)).
				when().
				post(getOrders);
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_getOrders(ecomid, CID),methodeName);
		logListner.writeRequestAndResponseInReport(resp_getOrders,methodeName);
	}
}
