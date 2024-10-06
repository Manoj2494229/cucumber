package smoke;

import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class getProductList extends Help{
	
	static String customerId = null;
	static String keyword = null;
	String methodeName = null;
	
	static Response resp_getProductList;
	String getProductList 	= 	"https://vishopuat.myvi.in/o/vil-headless-product/1.0.0/getProductList";
	
	@Given("the user views products available in VI_SHOP using the getProductList API")
	public void the_user_views_products_available_in_vi_shop_using_the_get_product_list_api() throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getProductList = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getProductList)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_getProductList(customerId ,keyword )).
				when().
				post(getProductList);
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_getProductList(customerId ,keyword ),methodeName);
		logListner.writeRequestAndResponseInReport(resp_getProductList,methodeName);
	}
}
