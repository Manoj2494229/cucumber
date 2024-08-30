package Utitlities;

import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class AesEncryptionDxlUtility {

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	
	private static final String SECRET_KEY = "VE1LLVNFRUQtRU5DLURFQw==AAAAAqwe";

	/**
	 * <p>Method to encrypt input text using given secret key</p>
	 * @param strToEncrypt
	 * @param secretKey
	 * @return
	 */
	public static String encrypt(String strToEncrypt, String secretKey) {
		try {

			SecureRandom sr = new SecureRandom();
			byte[] salt = new byte[8];
			sr.nextBytes(salt);

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, salt, secretKey.getBytes(StandardCharsets.UTF_8),md5);
			SecretKeySpec key = new SecretKeySpec(keyAndIV[0], ALGORITHM);
			IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);

			byte[] encryptedData = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
			byte[] prefixAndSaltAndEncryptedData = new byte[16 + encryptedData.length];
			
			// Copy prefix (0-th to 7-th bytes)
			System.arraycopy("Salted__".getBytes(StandardCharsets.UTF_8), 0, prefixAndSaltAndEncryptedData, 0, 8);
		
			// Copy salt (8-th to 15-th bytes)
			System.arraycopy(salt, 0, prefixAndSaltAndEncryptedData, 8, 8);
			
			// Copy encrypted data (16-th byte and onwards)
			System.arraycopy(encryptedData, 0, prefixAndSaltAndEncryptedData, 16, encryptedData.length);

			return Base64.getEncoder().encodeToString(prefixAndSaltAndEncryptedData);

		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * <p>Method to decrypt input text using given secret key</p>
	 * @param strToDecrypt
	 * @param secretKey
	 * @return
	 */
	public static String decrypt(String strToDecrypt, String secretKey) {
		try {

			byte[] cipherData = Base64.getDecoder().decode(strToDecrypt);
			byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, saltData, secretKey.getBytes(StandardCharsets.UTF_8),md5);
			SecretKeySpec key = new SecretKeySpec(keyAndIV[0], ALGORITHM);
			IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

			byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
			Cipher aesCBC = Cipher.getInstance(TRANSFORMATION);
			aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
			byte[] decryptedData = aesCBC.doFinal(encrypted);

			return new String(decryptedData, StandardCharsets.UTF_8);

		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}

		return null;
	}

	/**
	 * Generates a key and an initialization vector (IV) with the given salt and password.
	 * <p>
	 * This method is equivalent to OpenSSL's EVP_BytesToKey function
	 * (see https://github.com/openssl/openssl/blob/master/crypto/evp/evp_key.c).
	 * By default, OpenSSL uses a single iteration, MD5 as the algorithm and UTF-8 encoded password data.
	 * </p>
	 * @param keyLength the length of the generated key (in bytes)
	 * @param ivLength the length of the generated IV (in bytes)
	 * @param iterations the number of digestion rounds 
	 * @param salt the salt data (8 bytes of data or <code>null</code>)
	 * @param password the password data (optional)
	 * @param md the message digest algorithm to use
	 * @return an two-element array with the generated key and IV
	 */
	public static byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

	    int digestLength = md.getDigestLength();
	    int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
	    byte[] generatedData = new byte[requiredLength];
	    int generatedLength = 0;

	    try {
	        md.reset();

	        // Repeat process until sufficient data has been generated
	        while (generatedLength < keyLength + ivLength) {

	            // Digest data (last digest if available, password data, salt if available)
	            if (generatedLength > 0)
	                md.update(generatedData, generatedLength - digestLength, digestLength);
	            md.update(password);
	            if (salt != null)
	                md.update(salt, 0, 8);
	            md.digest(generatedData, generatedLength, digestLength);

	            // additional rounds
	            for (int i = 1; i < iterations; i++) {
	                md.update(generatedData, generatedLength, digestLength);
	                md.digest(generatedData, generatedLength, digestLength);
	            }

	            generatedLength += digestLength;
	        }

	        // Copy key and IV into separate byte arrays
	        byte[][] result = new byte[2][];
	        result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
	        if (ivLength > 0)
	            result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

	        return result;

	    } catch (DigestException e) {
	        throw new RuntimeException(e);

	    } finally {
	        // Clean out temporary data
	        Arrays.fill(generatedData, (byte)0);
	    }
	}

	/**
	 * This method is used to decrypt string
	 * 
	 * @param encryptedText : decryptData
	 * @return : string
	 */
	public static String decryptData(String encryptedText) {
		
		String	secretKey = SECRET_KEY;
		
		return decrypt(encryptedText, secretKey);
	}

	/**
	 * This method is used to encrypt string
	 * 
	 * @param plainText : String
	 * @return : string
	 */
	public static String encryptData(String plainText) {
		String secretKey = SECRET_KEY;		

		return encrypt(plainText, secretKey);
	}

}
