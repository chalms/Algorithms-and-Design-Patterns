import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
	// used as reference: 
	// http://stackoverflow.com/questions/4895523/java-string-to-sha1
	
	private String plainText = null;
	private MessageDigest messageEater = null; 
	private byte[] encryptedBytes; 
	private String filePath = ""; 
	
	static public String byteString(byte[] bites) {
		StringBuilder stringBuilder = new StringBuilder();
	    for (byte b : bites) {
	        stringBuilder.append(String.format("%02X ", b));
	    }
	    return stringBuilder.toString();
	}
	
	public SHA1(String fp) {
		filePath = fp; 
		System.out.println("Filepath: " + filePath);
		plainText = getSampleText(filePath);
		System.out.println("Plaintext: " + plainText);
		try {
			encryptedBytes = digest(plainText.getBytes()); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Resulting Hash: " +  byteString(encryptedBytes));
	}
	
	public byte[] digest(byte[] input) throws NoSuchAlgorithmException  {
	    messageEater = MessageDigest.getInstance("SHA-1");
	    return messageEater.digest(input); 
	}
	
	public static String getSampleText(String filePath) {
		String all = ""; 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
			String in = null;
			boolean firstLine = true;
			while((in = reader.readLine()) != null) {
				if(firstLine) { 
					all = all + in; 
					firstLine = false; 
				} else {
					break; 
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace(); 
			return null;
		}
		return all; 
	}
}
