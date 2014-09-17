
public class ConsumerThread implements Runnable {
	Thread thread = null; 
	String consumerName = null; 
	Singleton mine = null; 
	ConsumerThread(String consumer) {
		consumerName = consumer; 
	}
	
	public void askForSingleton() {
		mine = Singleton.getSingleton(consumerName); 
		if (mine == null) System.out.println(consumerName + " couldnt get singleton");
	}
	
	public void run() {
		// should test if it keeps running for a while or just terminates 
	}

	 public void start ()
	 {
	      if (thread == null)
	      {
	         thread = new Thread (this, consumerName);
	         thread.start (); // this calls run(); 
	      }
	 }
	 
	 public void join() {
		 try {
			 // hopefully this kills the thread
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
