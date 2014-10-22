

public class FirstPrimes {

	// Write a method to return the first N prime integers    
    // Methods to test algorithm ----------------->
	
	public static String testArraysEqual(int[] primes, int[] result, String testName) {
		  boolean passed = true; 
		  for (int i = 0; i < result.length; i++) { 
			  if (result[i] != primes[i]) { 
				  passed = false; 
				  break; 
			  }
		  }
		  if (passed) return testName + " passed\n"; 
		  else return testName + " failed\n";
	}
    
    public static void findFirstMillionPrimes() {
        long startTime = System.nanoTime();
        int[] primeList = getPrimes(1000000);
        System.out.println(String.valueOf(primeList[primeList.length-1]));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(String.valueOf(duration) + " nanoseconds, " + String.valueOf(duration/1000) + " milliseconds");
    }
	
	public static String testPrimes() {
	  String testResults = "First Primes: \n";

	  // test first 3 primes
	  int[] primes = {2,3,5};
	  int[] result = getPrimes(3);
	  testResults += testArraysEqual(primes, result, "test 1"); 

	    // test first 7 primes
	  int[] primes2 = {2,3,5,7,11,13,17};
	  result = getPrimes(7);
	  testResults += testArraysEqual(primes2, result, "test 2"); 

	  // test safe failure for 0 input
	  result = getPrimes(0);
	  if (result != null) testResults += "test 3 failed \n";
	  else testResults += "test 3 passed \n";

	  // test safe failure for negative input
	  result = getPrimes(-1);
	  if (result != null) testResults += "test 4 failed \n";
	  else testResults += "test 4 passed \n";
	  
        
	  return testResults;
	}
    
    // <--------------- end of test methods
    
    
    
    // Method to return first N primes -------->

	public static int[] getPrimes(int n) {
	  if (n <= 0) return null;
	  int[] primes = new int[n];
	  int insertions = 0;
	  int j = 2;
	  while (insertions < n) {
	    int i = 0;
	    boolean isPrime = true;
		int sqrtFloor = ((int) Math.sqrt(j));
	    while (i < insertions) {
	      if (primes[i] > sqrtFloor) break;
	      if ((j % primes[i]) == 0) {
	        isPrime = false;
	        break;
	      }
	      i++; 
	    }
	    if (isPrime) {
	      primes[insertions] = j;
	      insertions++;
	    }
	    j++;
	  }
	  return primes ;
	}
}
