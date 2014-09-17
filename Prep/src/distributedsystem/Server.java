package distributedsystem;

import java.io.*; 
import java.net.*; 


public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
		 String clientSentence;          
		 String capitalizedSentence;         
		 ServerSocket welcomeSocket;
		try {
			welcomeSocket = new ServerSocket(6789);     
		 while(true)          {             
			 Socket connectionSocket = welcomeSocket.accept();             
			 BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));             
			 DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());             
			 clientSentence = inFromClient.readLine();             
			 System.out.println("Received: " + clientSentence);             
			 capitalizedSentence = clientSentence.toUpperCase() + '\n';             
			 outToClient.writeBytes(capitalizedSentence);          
		 } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}

}
