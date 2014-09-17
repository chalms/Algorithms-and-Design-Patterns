
public class MultiThreadingExample {
	
	Integer x = null; 

	public MultiThreadingExample() {
		// TODO Auto-generated constructor stub
		
		ConsumerThread c1 = new ConsumerThread("Chalmee"); 
		c1.start();
		
	}

}
