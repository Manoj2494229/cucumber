package Utitlities;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptUtil {

	EncryptDecryptUtil() {
	}


	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/GCM/NoPadding";
	private static final int GCM_IV_LENGTH = 12;
	private static final int GCM_TAG_LENGTH = 16;
	private static final String SECRET_KEY = "TVFhMdk268s7DPnQ";

	private static SecretKeySpec setKey(String mykey) {
		SecretKeySpec secretKey = null;

		byte[] keyBytes = mykey.getBytes(StandardCharsets.UTF_8);
		secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
		return secretKey;
	}

	private static byte[] generateRandomBytes(int length) {
		byte[] bytes = new byte[length];
		SecureRandom random = new SecureRandom();
		random.nextBytes(bytes);
		return bytes;

	}

	/*
	 * @param plain Text
	 * 
	 * @param secretKey
	 * 
	 * @return Base64 encoded encrypted text
	 * 
	 * @throws Exception
	 */
	public static String encrypt(String plainText, String secretKey) {
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			byte[] iv = generateRandomBytes(GCM_IV_LENGTH);

			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
			cipher.init(Cipher.ENCRYPT_MODE, setKey(secretKey), gcmParameterSpec);
			byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
			byte[] encryptedData = new byte[iv.length + cipherText.length];
			System.arraycopy(iv, 0, encryptedData, 0, iv.length);
			System.arraycopy(cipherText, 0, encryptedData, iv.length, cipherText.length);

			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param encryptedTxt: Base64 encoded encrypted txt
	 * @param secretKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptedTxt, String secretKey) {
		try {
			byte[] encryptedData = Base64.getDecoder().decode(encryptedTxt);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			byte[] iv = new byte[GCM_IV_LENGTH];
			byte[] cipherText = new byte[encryptedData.length - GCM_IV_LENGTH];

			System.arraycopy(encryptedData, 0, iv, 0, GCM_IV_LENGTH);
			System.arraycopy(encryptedData, GCM_IV_LENGTH, cipherText, 0, cipherText.length);
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
			cipher.init(Cipher.DECRYPT_MODE, setKey(secretKey), gcmParameterSpec);
			byte[] plainText = cipher.doFinal(cipherText);
			return new String(plainText, StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is used to decrypt string
	 * 
	 * @param encryptedText : decryptData
	 * @return : string
	 */
	public static String decryptData(String encryptedText) {
		
		return decrypt(encryptedText, SECRET_KEY);
	}

	/**
	 * This method is used to encrypt string
	 * 
	 * @param plainText : String
	 * @return : string
	 */
	public static String encryptData(String plainText) {
		
		return encrypt(plainText, SECRET_KEY);
	}

	
	  public static void main(String[] args) throws Exception { 
		  String plainText = "liferay";
	  
	  String encryptedData = encrypt(plainText, SECRET_KEY);
	  
	  System.out.println("Encrypted data : " + encryptedData);
	 
	  String decryptData = decrypt("ClVISzy7Ia+M4Mg8hbWln4XXi9VRWDSO7TJ70ImIBDUdwA==",SECRET_KEY);
	  
	  System.out.println("decrypted data : " + decryptData); }
	  
	 

}