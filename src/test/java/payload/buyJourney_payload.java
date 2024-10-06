package payload;

import Utitlities.ConfigListner;
import Utitlities.LREncryption;
import Utitlities.base;

public class buyJourney_payload {


	public static String payload_add(String CID ,String type ,String ecomid ,String PID , String SID) throws Exception
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
				+ "                       \"addressLine1\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryAddressLine1"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"addressLine2\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryAddressLine2"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"city\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryCity"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"country\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryCountry"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"landmark\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryLandmark"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                        \"postalCode\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryPostalcode"), "ENCRYPT", "APP")+"\"\r\n"
				+ "                    },\r\n"
				+ "                    \"beneficiaryName\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                    \"emailAddress\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryEmailAddress"), "ENCRYPT", "APP")+"\",\r\n"
				+ "                    \"giftMessage\": \"\",\r\n"
				+ "                    \"mobileNo\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryMobileNo"), "ENCRYPT", "APP")+"\"\r\n"
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

	public static String payload_UPSERT( String orderId ,String CID, String  msidn) throws Exception
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
				+ "            \"city\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingCity"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"country\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingCountry"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"name\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"postalCode\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingPostalCode"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"region\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingRegion"), "ENCRYPT", "APP")+"\",\r\n"
				+ "           \"street1\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingStreet1"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street2\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingStreet2"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street3\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("billingStreet3"), "ENCRYPT", "APP")+"\"\r\n"
				+ "        },\r\n"
				+ "        \"shippingAddress\": {\r\n"
				+ "            \"addressId\": -1,\r\n"
				+ "            \"city\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingCity"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"country\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingCountry"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"name\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"postalCode\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingPostalCode"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"region\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingRegion"), "ENCRYPT", "APP")+"\",\r\n"
				+ "           \"street1\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingStreet1"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street2\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingStreet2"), "ENCRYPT", "APP")+"\",\r\n"
				+ "            \"street3\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("shippingStreet3"), "ENCRYPT", "APP")+"\"\r\n"
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
	
	public static String payload_managePromotion(String CID ,String ecomid ,String promoId)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"8pmnoj_202408302311121725039672276\",\r\n"
				+ "    \"requestType\": \"apply_coupon\",\r\n"
				+ "    \"serviceName\": \"managePromotion\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"customerId\": "+CID+",\r\n"
				+ "        \"ecommOrderId\": "+ecomid+",\r\n"
				+ "        \"promoId\": \""+promoId+"\"\r\n"
				+ "    }\r\n"
				+ "}";	
		base.log("payload_ added -- payload_managePromotion");
		return post;
	
	}
	
	public static String payload_reviewProduct()
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"12345678Regession\",\r\n"
				+ "    \"serviceName\": \"reviewProduct\",\r\n"
				+ "    \"requestType\": \"ManageReview\",\r\n"
				+ "    \"requestIdentifier\":\"824917\",\r\n"
				+ "    \"customerId\": \"1000050201\",\r\n"
				+ "    \"rating\": \"3\",\r\n"
				+ "    \"review\": \"Regession Review\",\r\n"
				+ "    \"orderLineItemId\": \"-1\"\r\n"
				+ "}";	
		base.log("payload_ added -- payload_reviewProduct");
		return post;
	}
	public static String payload_manageCustomer(String msisdn) throws Exception
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"9pmnoj_202409012106101725204970466\",\r\n"
				+ "    \"serviceName\": \"manageCustomer\",\r\n"
				+ "    \"customerCategory\": \"Prepaid\",\r\n"
				+ "    \"customerType\": \"VI\",\r\n"
				+ "    \"emailId\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryEmailAddress"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"firstName\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"lastName\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"msisdn\": \""+msisdn+"\",\r\n"
				+ "    \"requestType\": \"add\",\r\n"
				+ "   \"customerId\": 1000071602\r\n"
				+ "}";	
		base.log("payload_ added -- payload_manageCustomer");
		return post;
	}
	public static String payload_validateCustomer(String msisdn)throws Exception
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"1698311047232\",\r\n"
				+ "    \"validateType\": \"MSISDN\",\r\n"
				+ "    \"serviceName\": \"validateCustomer\",\r\n"
				+ "    \"validateIdentifier\": \""+msisdn+"\",\r\n"
				+ "    \"customerCategory\": \"Prepaid\",\r\n"
				+ "    \"customerType\": \"VI\",\r\n"
				+ "    \"emailId\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryEmailAddress"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"firstName\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"lastName\": \""+LREncryption.convertString(ConfigListner.readBuyJourneyConfig("beneficiaryName"), "ENCRYPT", "APP")+"\",\r\n"
				+ "    \"msisdn\": \""+msisdn+"\"\r\n"
				+ "}";	
		base.log("payload_ added -- payload_validateCustomer");
		return post;
	}
	public static String payload_recordConsent(String msisdn , String termsConditionId , String version)throws Exception
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"1234\",\r\n"
				+ "    \"serviceName\": \"recordConsent\",\r\n"
				+ "    \"validateType\": \"MSISDN\",\r\n"
				+ "    \"validateIdentifier\": \""+msisdn+"\",\r\n"
				+ "    \"termsConditionId\": "+termsConditionId+",\r\n"
				+ "    \"version\": \""+version+"\"\r\n"
				+ "}";	
		base.log("payload_ added -- payload_recordConsent");
		return post;
	}
	
	public static String payload_getProductList(String customerId , String keyword)
	{
		String post = "{\r\n"
				+ "  \"channel\": \"DXL\",\r\n"
				+ "  \"products\": {\r\n"
				+ "    \"categorySearch\": [\r\n"
				+ "      {\r\n"
				+ "        \"categoryId\": 1660964\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"customerId\": "+customerId+",\r\n"
				+ "    \"customerSegment\": \"\",\r\n"
				+ "    \"end\": 1,\r\n"
				+ "    \"filterType\": \"\",\r\n"
				+ "    \"keyword\": \""+keyword+"\",\r\n"
				+ "    \"partnerId\": \"\",\r\n"
				+ "    \"productType\": \"\",\r\n"
				+ "    \"rating\": [],\r\n"
				+ "    \"responseListingType\": \"Short\",\r\n"
				+ "    \"sort\": {\r\n"
				+ "      \"sortOn\": \"\",\r\n"
				+ "      \"sortOrder\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"specificationsSearch\": [],\r\n"
				+ "    \"start\": 1,\r\n"
				+ "    \"tagsSearch\": [\r\n"
				+ "      {\r\n"
				+ "        \"tag\": \"bata_950\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"tag\": \"bata_1000\"\r\n"
				+ "      } \r\n"
				+ "    ],\r\n"
				+ "    \"useFactes\": true\r\n"
				+ "  },\r\n"
				+ "  \"requestId\": \"AND10301712038883538\",\r\n"
				+ "  \"serviceName\": \"getProductList\"\r\n"
				+ "}";	
		base.log("payload_ added -- payload_getProductList");
		return post;
	}
	
	public static String payload_getSearchedKeywords(String customerId)
	{
		String post = "{\r\n"
				+ "    \"channelName\": \"DXL\",\r\n"
				+ "    \"requestId\": \"12345678\",\r\n"
				+ "    \"serviceName\": \"getSearchedKeywords\",\r\n"
				+ "    \"records\": 5,\r\n"
				+ "    \"customerId\": \""+customerId+"\"\r\n"
				+ "}";	
		base.log("payload_ added -- payload_getSearchedKeywords");
		return post;
	}
	
	
}
