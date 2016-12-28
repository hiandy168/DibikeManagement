package com.Dibike.common;

import java.security.*;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.*;
import org.apache.commons.codec.binary.Base64;

public class SimpleDESUtil {

	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;
	private String strKey = "chengbai123";

	public SimpleDESUtil() throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException {
		init();
	}

	public SimpleDESUtil(String strKey) throws Exception {
		this.strKey = strKey;
		init();
	}

	private void init() throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchPaddingException {
		DESKeySpec desKeySpec = new DESKeySpec(strKey.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	public String encryptBase64(String unencryptedString) throws Exception {
		// Encode the string into bytes using utf-8
		byte[] unencryptedByteArray = unencryptedString.getBytes("UTF8");

		// Encrypt
		byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);

		// Encode bytes to base64 to get a string
		byte[] encodedBytes = Base64.encodeBase64(encryptedBytes);

		return new String(encodedBytes);
	}

	public String decryptBase64(String encryptedString) throws Exception {
		// Encode bytes to base64 to get a string
		byte[] decodedBytes = Base64.decodeBase64(encryptedString.getBytes());

		// Decrypt
		byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);

		// Decode using utf-8
		return new String(unencryptedByteArray, "UTF8");
	}

	public static void main(String[] args) throws Exception {
		SimpleDESUtil simp = new SimpleDESUtil("chengbai123");
		String a = simp.encryptBase64("Cbshangcheng@702");
		System.out.println(a);

		String b = simp.decryptBase64(a);
		System.out.println(b);

	}
}
