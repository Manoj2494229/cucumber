package smoke;

import Utitlities.TokenListner;
import Utitlities.apiCall;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import payload.wishList_payload;

public class wishList {
	
	public static String manageWishList_url = "https://vishopuat.myvi.in/o/vil-headless-wishlist/1.0.0/manageWishlist";
	public static String processWishlist_url = "https://vishopuat.myvi.in/o/vil-headless-wishlist/1.0.0/processWishlist";
	
	public static String customerId = "1000054801";
	public static String wishListId = "";
	public static String productId = "";
	public static String skuId = "";
	public static String wishListItemId = "";
	String methodeName = null;
	static Response resp_createWishlist;
	static Response resp_add_item_to_wishlist;
	static Response resp_remove_item_from_wishlist;
	static Response resp_featch_all_wishlist;
	static Response resp_get_all_wishlist_items;
	static Response resp_delete_wishlist;



	@When("Create blank Wishlist with name \\(ABCD)")
	public void create_blank_wishlist_with_name_abcd() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_createWishlist = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageWishList_url)).
				header("Content-Type","application/json").
				body(wishList_payload.create_blank_wishlist()).
				when().
				post(manageWishList_url);
		
		JsonPath output = new JsonPath(resp_createWishlist.asString());
		wishListId = 		output.getString("data.wishList[0].wishListId");
		String responseBody = resp_createWishlist.asPrettyString();
		System.out.println(wishList_payload.create_blank_wishlist());
		System.out.println(responseBody);
		
		
		//logListner.formatAPIAndLogInReport(wishList_payload.create_blank_wishlist(customerId),methodeName);
		//logListner.writeRequestAndResponseInReport(resp_createWishlist,methodeName);
	}

	@When("user Add item to the \\(ABCD) Wishlist")
	public void user_add_item_to_the_abcd_wishlist() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		//API Post Call 
		resp_add_item_to_wishlist = apiCall.post(manageWishList_url, wishList_payload.user_add_item_to_the_abcd_wishlist(wishListId));
		
		
		
		
		
		JsonPath output = new JsonPath(resp_add_item_to_wishlist.asString());
		wishListItemId = output.getString("data.wishList[0].products[0].wishListItemId");
	
		String responseBody = resp_add_item_to_wishlist.asPrettyString();
		System.out.println(wishList_payload.user_add_item_to_the_abcd_wishlist(wishListId));
		System.out.println(responseBody);
		
	}

	@When("user remove item from \\(ABCD) Wishlist")
	public void user_remove_item_from_abcd_wishlist() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_remove_item_from_wishlist = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageWishList_url)).
				header("Content-Type","application/json").
				body(wishList_payload.create_blank_wishlist()).
				when().
				post(manageWishList_url);
	}

	@When("user get list all Wishlist for ourself created")
	public void user_get_list_all_wishlist_for_ourself_created() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_featch_all_wishlist = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageWishList_url)).
				header("Content-Type","application/json").
				body(wishList_payload.create_blank_wishlist()).
				when().
				post(manageWishList_url);

	}

	@When("user get all Wishlist Items from \\(ABCD)")
	public void user_get_all_wishlist_items_from_abcd() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_get_all_wishlist_items = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageWishList_url)).
				header("Content-Type","application/json").
				body(wishList_payload.create_blank_wishlist()).
				when().
				post(manageWishList_url);
	}

	@When("user Delete Wishlist \\(ABCD)")
	public void user_delete_wishlist_abcd() {
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();
		resp_delete_wishlist = RestAssured.given().
				auth().
				oauth2(TokenListner.token(manageWishList_url)).
				header("Content-Type","application/json").
				body(wishList_payload.create_blank_wishlist()).
				when().
				post(manageWishList_url);
	}
}
