package smoke;

import Utitlities.Help;
import Utitlities.TokenListner;
import Utitlities.logListner;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.buyJourney_payload;

public class getAllCategories extends Help{
	
	static Response resp_getAllCategories;
	static Response resp_getChildCategories;
	static Response resp_getVocabularyCategoriesByName;
	static Response resp_getRootCategories;
	String methodeName = null;
	String getAllCategories 	= 	"https://vishopuat.myvi.in/o/vil-headless-category/1.0.0/getAllCategories?requestId=AND10301714117133874";
	String getChildCategories 	= 	"https://vishopuat.myvi.in/o/vil-headless-category/1.0.0/getChildCategories?categoryId=63674";
	String getVocabularyCategoriesByName 	= 	"https://vishopuat.myvi.in/o/vil-headless-category/1.0.0/getVocabularyCategoriesByName?vocabularyName=digital&requestId=ssss";
	String getRootCategories 	= 	"https://vishopuat.myvi.in/o/vil-headless-category/1.0.0/getRootCategories";
	
	
	
	@Given("the user views all categories using the getAllCategories API")
	public void the_user_views_all_categories_using_the_get_all_categories_api()  throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getAllCategories = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getAllCategories)).
				header("Content-Type","application/json").
				when().get(getAllCategories);
		
		logListner.writeRequestAndResponseInReport(resp_getAllCategories,methodeName);
	}

	@Given("the user views subcategories within a main category using the getChildCategories API")
	public void the_user_views_subcategories_within_a_main_category_using_the_get_child_categories_api()  throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getChildCategories = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getChildCategories)).
				header("Content-Type","application/json").
				when().get(getChildCategories);
		
		logListner.writeRequestAndResponseInReport(resp_getChildCategories,methodeName);
	}

	@Given("the user views a specific category by name using the getVocabularyCategoriesByName API")
	public void the_user_views_a_specific_category_by_name_using_the_get_vocabulary_categories_by_name_api()  throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getVocabularyCategoriesByName = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getVocabularyCategoriesByName)).
				header("Content-Type","application/json").
				when().get(getVocabularyCategoriesByName);
		
		logListner.writeRequestAndResponseInReport(resp_getVocabularyCategoriesByName,methodeName);
	}

	@Given("the user views a specific category by ID using the getVocabularyCategoriesById API")
	public void the_user_views_a_specific_category_by_id_using_the_get_vocabulary_categories_by_id_api()  throws Exception{
		methodeName = Thread.currentThread().getStackTrace()[1].getMethodName();

		resp_getRootCategories = RestAssured.given().
				auth().
				oauth2(TokenListner.token(getRootCategories)).
				header("Content-Type","application/json").
				when().get(getRootCategories);
		
		logListner.writeRequestAndResponseInReport(resp_getRootCategories,methodeName);
	}
}
