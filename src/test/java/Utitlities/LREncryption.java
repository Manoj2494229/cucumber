package Utitlities;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LREncryption {
	
	public static final String APP = "APP";
	private static final String CREATE_ORDER = "CREATE_ORDER";
	private static final String ENCRYPT = "ENCRYPT";
	private static final String DECRYPT = "DECRYPT";
	
	private static final String APP_SECRET_KEY = "VE1LLVNFRUQtRU5DLURFQw==AAAAAqwe";
	private static final String CREATE_ORDER_SECRET_KEY = "TVFhMdk268s7DPnQ";
	
	

	public static void main(String[] args) {
		
		String aenc = convertString("jeswanth", ENCRYPT, CREATE_ORDER);
		String de = aenc;
		String adec = convertString(de, DECRYPT, CREATE_ORDER);
		//System.out.println(aenc);
		System.out.println(adec);

	}

	
	@Test
	public void test()
	{
		String de = "manoj";
		String erc = convertString(de, ENCRYPT, APP);
		System.out.println(erc);
		String adec = convertString(erc, DECRYPT, APP);
		System.out.println(adec);
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String convertString(String plainTxt,String convType,String useCase) {
		
		String convString = null;
		
		try {
			
			switch (useCase) {
			case APP:
				if(convType.equalsIgnoreCase(ENCRYPT)) {
					convString = URLEncoder.encode(AesEncryptionDxlUtility.encrypt(plainTxt,APP_SECRET_KEY));
				}
				
				if(convType.equalsIgnoreCase(DECRYPT)) {
					convString = AesEncryptionDxlUtility.decrypt(URLDecoder.decode(plainTxt),APP_SECRET_KEY);
				}
				break;
				
			case CREATE_ORDER:
				if(convType.equalsIgnoreCase(ENCRYPT)) {
					convString = EncryptDecryptUtil.encrypt(plainTxt,CREATE_ORDER_SECRET_KEY);
				}
				
				if(convType.equalsIgnoreCase(DECRYPT)) {
					convString = EncryptDecryptUtil.decrypt(plainTxt,CREATE_ORDER_SECRET_KEY);
				}
				break;

			default:
				break;
			}
			
			
		}catch (Exception e) {
			return null;
		}
		
		return convString;
		
	}

}
