
public class Singleton {
	public String data = null; 
	private Singleton(String s) { data = s;  }
	static Singleton obj; 
	public static synchronized Singleton getSingleton(String s) {
		if (obj == null) {
			obj = new Singleton(s);  
		}
		return obj;
	}
}
