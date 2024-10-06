package smoke;

import Utitlities.ConfigListner;
import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class getSearchedKeywords extends Help{
	static String customerId = null;
	static String keyword = null;
	String methodeName = null;
	
	static Response resp_getProductList;
	static Response resp_getSearchedKeywords;
	
	String getProductList 	= 	"https://vishopuat.myvi.in/o/vil-headless-product/1.0.0/getProductList";
	String getSearchedKeywords 	= 	"https://vishopuat.myvi.in/o/vil-headless-product/1.0.0/getSearchedKeywords";
	
	@Given("the user searches for a term in VI_SHOP using the getProductList API")
	public void the_user_searches_for_a_term_in_vi_shop_using_the_get_product_list_api() throws Exception{
		
		customerId = ConfigListner.readBuyJourneyConfig("customerId");
		keyword = ConfigListner.readBuyJourneyConfig("keyword");
		
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getProductList = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getProductList)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_getProductList(customerId ,keyword )).
				when().
				post(getProductList);
		reporterAPI("Seach on Vi shop for = " +customerId);
//		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_getProductList(customerId ,keyword ));
//		logListner.writeRequestAndResponseInReport(resp_getProductList);
	}

	@Then("the user can view this searched keyword the next time they access VI_SHOP using the getSearchedKeywords API")
	public void the_user_can_view_this_searched_keyword_the_next_time_they_access_vi_shop_using_the_get_searched_keywords_api() throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getSearchedKeywords = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getSearchedKeywords)).
				header("Content-Type","application/json").
				body(buyJourney_payload.payload_getSearchedKeywords(customerId)).
				when().
				post(getSearchedKeywords);
		
		logListner.formatAPIAndLogInReport(buyJourney_payload.payload_getSearchedKeywords(customerId),methodeName);
		logListner.writeRequestAndResponseInReport(resp_getSearchedKeywords,methodeName);
	}
}
