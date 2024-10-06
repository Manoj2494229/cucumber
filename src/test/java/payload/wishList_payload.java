package payload;

import smoke.wishList;

public class wishList_payload {
	
	public static  String customerId = wishList.customerId;
	public static  String productId = wishList.productId;
	public static  String skuId = wishList.skuId;
	
	public static String create_blank_wishlist()
	{
		String payload = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"9pmnoj_202409282022291727535149836\",\r\n"
				+ "    \"serviceName\": \"manageWishList\",\r\n"
				+ "    \"requestType\": \"CreateWishlist\",\r\n"
				+ "    \"requestIdentifier\": \"ABCD1\",\r\n"
				+ "    \"wishListId\": \"0\",\r\n"
				+ "    \"customerId\": "+customerId+"  \r\n"
				+ "}";
		return payload;
	}
	
	public static String user_add_item_to_the_abcd_wishlist(String wishListId)
	{
		String payload = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"12345678\",\r\n"
				+ "    \"serviceName\": \"manageWishList\",\r\n"
				+ "    \"requestType\": \"AddToWishlist\",\r\n"
				+ "    \"requestIdentifier\": \""+wishListId+"\",\r\n"
				+ "    \"customerId\": "+customerId+",\r\n"
				+ "    \"wishListId\": \"0\",\r\n"
				+ "    \"wishListItems\": [\r\n"
				+ "      {\r\n"
				+ "            \"productId\": \""+productId+"\",\r\n"
				+ "            \"skuId\": \""+skuId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	public static String user_remove_item_from_abcd_wishlist()
	{
		String payload = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"9pmnoj_202409261434411727341481194\",\r\n"
				+ "    \"serviceName\": \"manageWishList\",\r\n"
				+ "    \"requestType\": \"RemoveWishlistItem\",\r\n"
				+ "    \"requestIdentifier\": 14901,\r\n"
				+ "    \"customerId\": "+customerId+",\r\n"
				+ "    \"wishListId\": 33213882,\r\n"
				+ "    \"wishListItems\": [\r\n"
				+ "        {\r\n"
				+ "            \"productId\": \""+productId+"\",\r\n"
				+ "            \"skuId\": \""+skuId+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	public static String user_get_list_all_wishlist_for_ourself_created()
	{
		String payload = "  {\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"1234567\",\r\n"
				+ "    \"requestType\": \"CustomerWishlist\",\r\n"
				+ "    \"serviceName\": \"processWishlist\",\r\n"
				+ "    \"requestIdentifier\": \"1000101902\",\r\n"
				+ "    \"customerId\":\""+customerId+"\",\r\n"
				+ "    \"start\": 0,\r\n"
				+ "    \"end\": 10\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	public static String user_get_all_wishlist_items_from_abcd()
	{
		String payload = "  {\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"1222222\",\r\n"
				+ "    \"requestType\": \"FetchWishlist\",\r\n"
				+ "    \"serviceName\": \"processWishlist\",\r\n"
				+ "    \"requestIdentifier\": \"33213893\",\r\n"
				+ "    \"customerId\":\""+customerId+"\",\r\n"
				+ "    \"start\": 0,\r\n"
				+ "    \"end\": 10\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	public static String user_delete_wishlist_abcd()
	{
		String payload = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"9pmnoj_202409261435291727341529234\",\r\n"
				+ "    \"serviceName\": \"manageWishList\",\r\n"
				+ "    \"requestType\": \"RemoveWishlist\",\r\n"
				+ "    \"requestIdentifier\": 33213882,\r\n"
				+ "    \"customerId\": "+customerId+",\r\n"
				+ "    \"wishListId\": 33213882\r\n"
				+ "}\r\n"
				+ "";
		return payload;
	}
	
	
	

}
