
public class Palindrome {

	// create a method to test whether a given string is a palindrome
	
	public static String testPalindrome() {
	  String testResults = "Testing Palindrome: \n";
	
	  // test a palindrome with odd number of characters
	  if (isPalindrome("racecar")) testResults += "test 1 passed\n";
	  else testResults += "test 1 failed\n";
	
	  // test a palindrome with even number of characters
	  if (isPalindrome("abba")) testResults += "test 2 passed\n";
	  else testResults += "test 2 failed";
	
	  // test a non palindrome that is close to a palindrome
	  if (!isPalindrome("abbaa")) testResults += "test 3 passed\n";
	  else testResults += "test 3 failed";
	
	  // test for safe failure
	  try {
		  isPalindrome(""); 
	  } catch (Exception e) {
		  testResults += "test 4 failed\n"; 
		  return testResults; 
	  }
	  testResults += "test 4 passed\n";
	  return testResults;
	}
	
	public static boolean isPalindrome(String str) {
	  int top = str.length() - 1;
	  int bottom = 0;
	  while (top > bottom) {
	    if (str.charAt(top) != str.charAt(bottom)) return false;
	    top--;
	    bottom++;
	  }
	  return true;
	}

}
