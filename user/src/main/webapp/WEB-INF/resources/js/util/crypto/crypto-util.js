/**
 * crypto-util.js
 * This script provides the ability to encrypt or decrypt text.
 * This script requires a script file of CryptoJS version 3.1.2.
 *   - aes.js
 *   - core.js
 *   - sha256.js
 * @author Inmook, Jeong
 * @since 2024.06.12
 */
var CryptoUtil = CryptoUtil || (function() {
	/**
	 * CryptoUtil namespace
	 */
	var C = {};
	
	/**
	 * Encryption namespace.
	 */
	var C_encrypt = C.encrypt = {};
	
	/**
	 * Decryption namespace.
	 */
	var C_decrypt = C.decrypt = {};
	
	/**
	 * SHA256 encryption function.
	 * 
	 * @param plainText Plain text to be encrypted
	 * @returns encrypted text
	 */
	C_encrypt.SHA256 = (function(plainText) {
		return CryptoJS.SHA256(plainText).toString(CryptoJS.enc.Hex);
	});
	
	/**
	 * AES encryption function.<br/>
	 * Use Base64 encoding to enable decryption on the server via HTTP communication.
	 * 
	 * @param plainText Plain text to be encrypted
	 * @param secretKey
	 * @param iv
	 * @returns encrypted text
	 */
	C_encrypt.AES = (function(plainText, secretKey, iv) {
		const encodedSecretKey = CryptoJS.enc.Utf8.parse(secretKey);
		const encodedIv = CryptoJS.enc.Utf8.parse(iv);
		const cipherText = CryptoJS.AES.encrypt(plainText, encodedSecretKey, {
			iv: encodedIv,
			mode: CryptoJS.mode.CBC,
			padding: CryptoJS.pad.Pkcs7
		});
		
		return cipherText.toString();
	});
	
	/**
	 * AES decryption function.
	 * Use Base64 decoding to enable decryption on the server via HTTP communication.
	 * 
	 * @param plainText Plain text to be encrypted
	 * @param secretKey
	 * @param iv
	 * @returns encrypted text
	 */
	C_decrypt.AES = (function(cipherText, secretKey, iv) {
		const encodedSecretKey = CryptoJS.enc.Utf8.parse(secretKey);
		const plainText = CryptoJS.AES.decrypt(replaceUtf8Character(cipherText), encodedSecretKey, {
			iv: CryptoJS.enc.Utf8.parse(iv),
			padding: CryptoJS.pad.Pkcs7,
			mode: CryptoJS.mode.CBC
		});
		
		return plainText.toString(CryptoJS.enc.Utf8);
	});
	
	/**
	 * Converts special characters in UTF-8 encoded ciphertext to Base64 special characters.
	 * 
	 * @param ciperText
	 * @returns ciphertext to Base64 special characters
	 */
	replaceBase64Character = (function(ciperText) {
		ciperText = ciperText.replace(/[/]/gi, '_');
		ciperText = ciperText.replace(/[+]/gi, '-');
		return ciperText;
	});
	
	/**
	 * Converts special characters in UTF-8 encoded ciphertext to Base64 special characters.
	 * 
	 * @param ciperText
	 * @returns ciphertext to Base64 special characters
	 */
	replaceUtf8Character = (function(ciperText) {
		ciperText = ciperText.replace(/[_]/gi, '/');
		ciperText = ciperText.replace(/[-]/gi, '+');
		return ciperText;
	});
	
	return C;
}());