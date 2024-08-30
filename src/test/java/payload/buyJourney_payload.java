package payload;

import Utitlities.LREncryption;
import Utitlities.base;

public class buyJourney_payload {


	public static String payload_add(String CID ,String type ,String ecomid ,String PID , String SID)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"customerId\": "+CID+",\r\n"
				+ "        \"customerMSISDN\": \"7265902544\",\r\n"
				+ "        \"ecommOrderId\": "+ecomid+",\r\n"
				+ "        \"promoId\": \"\",\r\n"
				+ "        \"orderItems\": [\r\n"
				+ "            {\r\n"
				+ "                \"beneficiaryDetails\": {\r\n"
				+ "                    \"address\": {\r\n"
				+ "                       \"addressLine1\": \""+LREncryption.convertString("TCS", "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"addressLine2\": \""+LREncryption.convertString("YANTRA PARK", "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"city\": \""+LREncryption.convertString("THANE", "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"country\": \""+LREncryption.convertString("INDIA", "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"landmark\": \""+LREncryption.convertString("NEAR KORUM MALL", "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"postalCode\": \""+LREncryption.convertString("400604", "ENCRYPT", "APP")+"\"\r\n"
				+ "                    },\r\n"
				+ "                    \"beneficiaryName\": \""+LREncryption.convertString("MANOJ", "ENCRYPT", "APP")+"\",\r\n"
				+ "                    \"emailAddress\": \""+LREncryption.convertString("MB@GMAIL.COM", "ENCRYPT", "APP")+"\",\r\n"
				+ "                    \"giftMessage\": \"\",\r\n"
				+ "                    \"mobileNo\": \""+LREncryption.convertString("9373737606", "ENCRYPT", "APP")+"\"\r\n"
				+ "                },\r\n"
				+ "                \"itemPrice\": 0,\r\n"
				+ "                \"consentFlag\": 1,\r\n"
				+ "                \"isLeadProduct\": 0,\r\n"
				+ "                \"leadDetails\": [],\r\n"
				+ "                \"productId\": "+PID+",\r\n"
				+ "                \"productName\": \"Lifestyle E-Gift Card\",\r\n"
				+ "                \"quantity\": 1,\r\n"
				+ "                \"skuId\": "+SID+"\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"requestId\": \"1234567890\",\r\n"
				+ "    \"requestType\": \""+type+"\",\r\n"
				+ "    \"serviceName\": \"manageOrder\"\r\n"
				+ "}";	
		base.log("payload_ added -- manageOrder_add");
		return post;
	
	}

	public static String payload_UPSERT( String orderId ,String CID, String  msidn)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": 123,\r\n"
				+ "    \"serviceName\": \"manageOrder\",\r\n"
				+ "    \"requestType\": \"UPSERT_ADDRESS\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"ecommOrderId\": "+orderId+",\r\n"
				+ "        \"customerId\": \""+CID+"\",\r\n"
				+ "        \"customerMSISDN\": "+msidn+",\r\n"
				+ "        \"availGST\": \"No\",\r\n"
				+ "        \"GSTNumber\": \"\",\r\n"
				+ "        \"saveAddressForFuture\": \"yes\",\r\n"
				+ "        \"billingAddress\": {\r\n"
				+ "            \"addressId\": -1,\r\n"
				+ "            \"city\": \""+LREncryption.convertString("Thane", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"country\": \""+LREncryption.convertString("India", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"name\": \""+LREncryption.convertString("manoj", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"postalCode\": \""+LREncryption.convertString("400604", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"region\": \""+LREncryption.convertString("MAHARASHTRA", "ENCRYPT", "APP")+"\",\r\n"
				+ "           \"street1\": \""+LREncryption.convertString("ROAD NO 2", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street2\": \""+LREncryption.convertString("THANE WEST", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street3\": \""+LREncryption.convertString("NEAR MALL", "ENCRYPT", "APP")+"\"\r\n"
				+ "        },\r\n"
				+ "        \"shippingAddress\": {\r\n"
				+ "            \"addressId\": -1,\r\n"
				+ "            \"city\": \""+LREncryption.convertString("Thane", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"country\": \""+LREncryption.convertString("India", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"name\": \""+LREncryption.convertString("manoj", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"postalCode\": \""+LREncryption.convertString("400604", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"region\": \""+LREncryption.convertString("MAHARASHTRA", "ENCRYPT", "APP")+"\",\r\n"
				+ "           \"street1\": \""+LREncryption.convertString("ROAD NO 2", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street2\": \""+LREncryption.convertString("THANE WEST", "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street3\": \""+LREncryption.convertString("NEAR MALL", "ENCRYPT", "APP")+"\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";	
		return post;
	}
	public static String payload_UPDATE( String CID ,String msidn ,String ecomid ,String productName ,String paymentAmount ,String cardConvenienceFee ,String orderAmount , String orderItemId)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": 234,\r\n"
				+ "    \"serviceName\": \"updateOrder\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"customerId\": "+CID+",\r\n"
				+ "        \"customerMSISDN\": "+msidn+",\r\n"
				+ "        \"ecommOrderId\": "+ecomid+",\r\n"
				+ "        \"orderDate\": \"\",\r\n"
				+ "        \"orderItems\": [\r\n"
				+ "            {\r\n"
				+ " \"orderItemId\": \""+orderItemId+"\",\r\n"
				+ " \"productName\": \""+productName+"\",\r\n"
				+ " \"amount\": \""+orderAmount+"\"\r\n"
				+ "}\r\n"
				+ "        ],\r\n"
				+ "        \"paymentDetails\": {\r\n"
				+ "            \"paymentOrderId\": \"PRE0984996373769038\",\r\n"
				+ "            \"paymentDateTime\": \"16/08/2024 14:07:24\",\r\n"
				+ "            \"paymentChannel\": \"JUSPAY\",\r\n"
				+ "            \"gatewayTransactionId\": \"1234567899\",\r\n"
				+ "            \"paymentMode\": \"card\",\r\n"
				+ "            \"paymentMethodType\": \"card\",\r\n"
				+ "            \"paymentGateway\": \"TPSL\",\r\n"
				+ "            \"cardIssuer\": \"ICICI Bank\",\r\n"
				+ "            \"paymentMethod\": \"VISA\",\r\n"
				+ "            \"cardType\": \"Credit\",\r\n"
				+ "            \"paymentAmount\": "+paymentAmount+",\r\n"
				+ "            \"paymentStatus\": \"success\",\r\n"
				+ "            \"paymentGatewayId\": \"0\",\r\n"
				+ "            \"cardConvenienceFee\": "+cardConvenienceFee+",\r\n"
				+ "            \"orderPaymentAmount\": "+orderAmount+",\r\n"
				+ "            \"rechargeAmount\": 0\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";	
		return post;
	}
	
	public static String payload_getOrderDetails( String orderId)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"and1040\",\r\n"
				+ "    \"serviceName\": \"getOrderDetails\",\r\n"
				+ "    \"customerId\": \"-1\",\r\n"
				+ "    \"orderId\": "+orderId+"\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "}";	
		return post;
	}
	
	public static String payload_getOrders( String searchKeyword , String customerId)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"customerId\": \""+customerId+"\",\r\n"
				+ "    \"end\": 1000,\r\n"
				+ "    \"orderStatus\": \"\",\r\n"
				+ "    \"orderType\": \"\",\r\n"
				+ "    \"requestId\": \"and1040\",\r\n"
				+ "    \"searchKeyword\": \""+searchKeyword+"\",\r\n"
				+ "    \"serviceName\": \"getOrders\",\r\n"
				+ "    \"start\": 0\r\n"
				+ "}";	
		return post;
	}
	
	
}
