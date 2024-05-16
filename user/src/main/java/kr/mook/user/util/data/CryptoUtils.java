package kr.mook.user.util.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {
	
	public static String toSHA256(final String text) {
		String encryptText = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(text.getBytes());
			byte[] encryptTextBytes = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : encryptTextBytes) {
				sb.append(String.format("%02x", b));
			}
			
			encryptText = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encryptText;
	}

}
