package smoke;

import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class productReview extends Help{
	
	static Response resp_reviewProduct;
	String methodeName = null;
	
	String reviewProduct 	= 	"https://vishopuat.myvi.in/o/vil-headless-customer/v1.0/reviewProduct";
	
	@Given("the user submits a review for a product using the reviewProduct API")
	public void the_user_submits_a_review_for_a_product_using_the_review_product_api()  throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_reviewProduct = RestAssured.given().
				auth().
				oauth2(TokenListner.token(reviewProduct)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_reviewProduct()).
				when().
				post(reviewProduct);
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_reviewProduct(),methodeName);
		logListner.writeRequestAndResponseInReport(resp_reviewProduct,methodeName);
		
		reporterAPI("This is assert");
	}

}
