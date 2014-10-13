import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class CipherBlockChain {
	
	// Imported class skeleton from: http://aesencryption.net/
	// Padding tip from: http://stackoverflow.com/questions/10759392/java-aes-encryption-and-decryption
	// 
	
	static Cipher cbcCipher = null;
	private static Integer bitLength = null;
	private static String plainText = null;

	class KeyAndIv {
		SecureRandom randomizer; 
		private byte[] secretKey; 
		private byte[] initVector;
		private SecretKeySpec key;
		
		KeyAndIv(int size) {
			secretKey = new byte[size/8];
			initVector = new byte[size/8];
		}
		public void setRandomData() {
			randomizer = new SecureRandom(); 
			randomizer.nextBytes(initVector);
			randomizer.nextBytes(secretKey);
		}
		public byte[] getSecretKey() {
		  return secretKey; 
		}
		public SecretKeySpec getKey() {
		  return key; 
		}
		public byte[] getInitVector() {
		  return initVector; 
		}
	}
	
	private static KeyAndIv byteArrays = null;
	
	public static class Encryption {
		private static byte[] encryptedData;
		private static String encryptedStr = null; 
		
		public static void setEncrypted() throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException {
			cbcCipher.init(Cipher.ENCRYPT_MODE, byteArrays.getKey(), new IvParameterSpec(byteArrays.getInitVector()));
		    byte[] plainT = plainText.getBytes();
			encryptedData = cbcCipher.doFinal(plainT);
		    encryptedStr = new String(encryptedData, "UTF8");
		}
		
		public static byte[] getEncryptedData() {
			return encryptedData;
		}
		
		public static String getEncryptedStr() {
			return encryptedStr;  
		}
	}
	
	public static class Decryption {
		static private byte[] decryptedData; 
		static private String decryptedStr = null;
		
		public static void setDecrypted() throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException {
			cbcCipher.init(Cipher.DECRYPT_MODE, byteArrays.getKey(), new IvParameterSpec(byteArrays.getInitVector()) );
		    byte[] encryptedBytes = Encryption.getEncryptedData();
		    decryptedData = cbcCipher.doFinal(encryptedBytes);
		    decryptedStr = new String(decryptedData, "UTF8");
		}
		
		public static byte[] getDecryptedData() {
			return decryptedData; 
		}
		
		public static String getDecryptedStr() {
			return decryptedStr;  
		}
	}
	
	public static void testCipherBlockChain() {
		StartCipherBlockChain("AES/CBC/NoPadding", "126", null);
		System.out.println("Plain Text: "); 
		System.out.println(plainText);
		System.out.println("Encrypted: "); 
		System.out.println(Encryption.getEncryptedStr());
		System.out.println("Decrypted: "); 
		System.out.println(Decryption.getDecryptedStr()); 
		System.out.println("Key: "); 
		System.out.println(byteArrays.getKey().toString()); 
		System.out.println("IV: "); 
		System.out.println(new String(byteArrays.getInitVector())); 
		System.out.println("Algorithm: "); 
		System.out.println(CipherBlockChain.getCipher().getAlgorithm()); 
	}
	
	
	// Test args: "AES/CBC/PKCS5PADDING", 128
	public static void StartCipherBlockChain(String cipherType, String numberBits, String plainText) {

		if (setUpCipher(cipherType, numberBits) == null) return; 
		
		if (plainText == null) plainText = getSampleText(); 
        
		bitLength = Integer.parseInt(numberBits); 
		if (bitLength == null) {
			System.out.println("Parse Number Bits Error!"); 
			return; 
		}
		
		StackTraceElement[] s = runEncrypt() ; 
		if (s == null) {
			s = runDecrypt(); 
			if (s == null) {
				if (Decryption.decryptedData.equals(plainText)) {
					System.out.println("Success!"); 
				}
			} else {
				System.out.println(s.toString()); 
			}
		} else {
			System.out.println(s.toString()); 
		}

	}
	
	public static Cipher buildCipher(String cipherType, String numberBits) throws NoSuchAlgorithmException, NoSuchPaddingException{
		String cipherInstance = new String(cipherType + " (" + numberBits + ") "); 
		Cipher cipher = Cipher.getInstance(cipherInstance);
		return cipher; 
	}
	
	public static Cipher setUpCipher(String cipherType, String numberBits) {
		try {
			cbcCipher = buildCipher(cipherType, numberBits); 
			return cbcCipher; 
		} catch (NoSuchAlgorithmException e1){
			e1.printStackTrace();
			return null; 
		} catch (NoSuchPaddingException e2) {
			e2.printStackTrace();
			return null;
		}
	};
	
	public static Cipher getCipher() {
		if (cbcCipher == null) {
			return cbcCipher; 			
		} else {
			return setUpCipher("AES/CBC/PKCS5PADDING", "128"); 
		}
	}
	
	public static String getSampleText() {
		return "Birthday Song Lyrics By Two Chains"
            + "She got a big booty so I call her Big Booty"
			+ "Scrr..Scrr.. wrists moving, cooking, getting to it"
			+ "I'm in the kitchen, yams everywhere"
			+ "Just made a juug, I got bands everywhere"; 
	}
	
	public static StackTraceElement[] runEncrypt() {
		try {
			Encryption.setEncrypted();
			System.out.println(Encryption.encryptedData);
			return null;
		} catch (IllegalBlockSizeException e) {
			return e.getStackTrace();
		} catch (InvalidKeyException e) {
			return e.getStackTrace();
		} catch (BadPaddingException e) {
			return e.getStackTrace();
		} catch (UnsupportedEncodingException e) {
			return e.getStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			return e.getStackTrace(); 
		}
	}
	
	public static StackTraceElement[] runDecrypt() {
		try {
			Decryption.setDecrypted();
			System.out.println(Encryption.encryptedData);
			return null;
		} catch (IllegalBlockSizeException e) {
			return e.getStackTrace();
		} catch (InvalidKeyException e) {
			return e.getStackTrace();
		} catch (BadPaddingException e) {
			return e.getStackTrace();
		} catch (UnsupportedEncodingException e) {
			return e.getStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			return e.getStackTrace(); 
		}
	}
	

	// public 
	//    MessageDigest sha = null;
	//  key = myKey.getBytes("UTF-8");
	//  System.out.println(key.length);
	//  sha = MessageDigest.getInstance("SHA-1");
	//  key = sha.digest(key);
	//  key = Arrays.copyOf(key, 16); // use only first 128 bit
	//  System.out.println(key.length);
	//  System.out.println(new String(key,"UTF-8"));
	//  secretKey = new SecretKeySpec(key, "AES");
		
}