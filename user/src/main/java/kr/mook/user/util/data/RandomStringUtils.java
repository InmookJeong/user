package kr.mook.user.util.data;

import java.util.Random;

/**
 * RandomStringUtils generates randomly combined string data.
 * 
 * @since 2024.03.14
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class RandomStringUtils {
	
	private static final String ALPHABET_UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHABET_LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$_-";
	
	/**
	 * When you enter a length, this method creates a string that randomly combines English letters, numbers, and special characters to the length entered.
	 * 
	 * @param length
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public static String getRandomString(int length) {
		
		String characters = ALPHABET_UPPERCASE_LETTERS
				+ ALPHABET_LOWERCASE_LETTERS
				+ NUMBERS
				+ SPECIAL_CHARACTERS;
		StringBuilder result = new StringBuilder(length);
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}
		
		return result.toString();
	}
}
