package distributedsystem;
import java.io.*; 
import java.net.*; 

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
		String sentence;   
		String modifiedSentence;   
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		Socket clientSocket;
		try {
			clientSocket = new Socket("localhost", 6789); 
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());  
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   
			sentence = inFromUser.readLine();   outToServer.writeBytes(sentence + '\n');   
			modifiedSentence = inFromServer.readLine();   
			System.out.println("FROM SERVER: " + modifiedSentence);   
			clientSocket.close(); 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
		

}
