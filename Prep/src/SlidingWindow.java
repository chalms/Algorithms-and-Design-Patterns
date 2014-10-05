import java.util.HashSet;

public class SlidingWindow {

	// This is an O(n) solution to the problem of finding the 
	// smallest sub-sequence in a sequence 
	// that contains all elements in a set 
	
	// This is analogous to finding the minimum-length sub-string 's' inside string 'str' 
	// that contains all characters of another string, 'charArrString'. 
	
	// This can be solved most simply by using custom data structure called a HashQueue
	// HashQueue is a HashMap that allows you to remove, or access, the key-value pair of the 
	// first element stored in the hashmap. 
	
	// Specifically, it is a hashmap data structure, with a queue that holds references to each key 
	// to maintain order of insertion
	
	// We then set this problem up by performing the following steps:
	// we start by iterating over characters in the string (starting from 0)
	// until all characters in 'charArrString' have been found. 
	
	// Each time we find a character in 'str' that is a member of 'charArrString', 
	// we add it to the hashqueue in the form of a key-value pair. 
	// the key is the character, the value is its index within 'str'. 
	
	// ---- Finding the last item --> The Window Size Evaluation ----------
	// Once we find the last value from charArrString, we get the value of the current index
	// and the index value of the first key-value pair added to the HashQueue . 
	// We subtract the first index value from the current to get the size of the first subsequence 
	// We store the value of the start of this sequence before iterating forward
	
	// We now iterate forward replacing characters key-value pairs in our hash-table, 
	// If the key we are replacing in the hashtable (with a newly found value) 
	// is equal to the key at the head of the Queue, then we have found a new 
	// window. We then calculate the window size using The Window Size Evaluation. 
	// If the new window is smaller than the current window, we store the new window 
	// size as the size and the starting position of the window as the position value
	// of the next head of the Queue (once we remove the current head) 
	
	// We continue to sweep through the array and return the sub-sequence within the range
	// of [start_position, start_position + window_size]. 
	
	
	public static HashSet<Character> set = null;
	
	  
	 public static String runSlidingWindowTest() {
		  String testResult = "Sliding Window: \n"; 
		  String answer = SlidingWindow.solve("SUDO00V0UEESVOS","SUV"); 
		  String expecting = "UEESV"; 
		  if (answer.equals(expecting)) testResult += "test passed\n";  
		  else testResult += ("failed! Expected: " + expecting + ", Result: " + answer + "\n"); 
		  return testResult; 
	  }

	public static String solve(String str, String charArrString) {
		Integer bestIndex = str.length() - 1;
		Integer bestSize = str.length();
		set = buildSet(charArrString);
		HashQueue q = new HashQueue();
		
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i))) {
				q.put(str.charAt(i), i);
				if (q.size() == set.size()) {
					if (q.size < bestSize) {
						bestSize = q.size;
						bestIndex = q.lastIndex;
					}
					q.removeFirst();
				}
			}
		}
		String answer = str.substring(bestIndex - bestSize, bestIndex + 1);
		return answer;
	}

	static HashSet<Character> buildSet(String charArrString) {
		HashSet<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < charArrString.length(); i++) {
			charSet.add(charArrString.charAt(i));
		}
		return charSet;
	}
}
