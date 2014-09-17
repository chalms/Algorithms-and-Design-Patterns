import java.util.HashSet;

public class Solver {
	  public static HashSet <Character> set = null; 

	  public static String solve(String s, String t ) {
		Integer bestIndex = s.length()-1; 
		Integer bestSize = s.length(); 
	    set = buildSet(t);
	    HashQueue q = new HashQueue(); 
	    for (int i = 0; i < s.length(); i++) {
	    	if (set.contains(s.charAt(i))) {
	    		q.put(s.charAt(i), i); 
	    		if (q.size() == set.size()) {
	    			if (q.size < bestSize) {
	    				bestSize = q.size; 
	    				bestIndex = q.lastIndex; 
	    			}
	    			q.removeFirst(); 
	    		}
	     	}
	    }
	   String answer = s.substring(bestIndex - bestSize, bestIndex+1); 
	   System.out.println(answer); 
	   return answer; 
	  }

	  static HashSet <Character> buildSet(String t) {
	    HashSet <Character> s = new HashSet <Character> ();
	    for (int i = 0; i < t.length(); i++) {
	      s.add(t.charAt(i));
	    }
	    return s;
	  }
}
