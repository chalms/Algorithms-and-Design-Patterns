

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
        
      // return if n is too small for safe error handling
	  if (n <= 0) return null;
     
      // create an array of size N
	  int[] primes = new int[n];
    
      // count number of inserted primes
	  int insertions = 0;
        
      // j is the number that may be prime (so we start at 2)
	  int j = 2;
        
      // until N primes are found, loop. (each loop increments j)
	  while (insertions < n) {
          
        // create an index to loop through existing primes in array of primes
	    int i = 0;
          
        // set a flag; if this flag isn't changed after the loop the number is prime
	    boolean isPrime = true;
          
        // if a number is not prime or a square it will have two integer factors.
        // check only the previous primes that are less than or equal to the sqrt
        // of the current number K, because if a number is not prime or a square
        // it will have two integer factors (one greater, one less, than K)
		int sqrtFloor = ((int) Math.sqrt(j));
        
        // start looping through all found primes
	    while (i < insertions) {
            
          // break if primes[i] is greater than sqrtFloor
	      if (primes[i] > sqrtFloor) break;
            
          // if integer j mod primes[i] is 0 then primes[i] is a factor of j, so break
	      if ((j % primes[i]) == 0) {
	        isPrime = false;
	        break;
	      }
	      i++; 
	    }
        
        // if the flag is set, add the current integer j to the set of primes
	    if (isPrime) {
	      primes[insertions] = j;
	      insertions++;
	    }
	    j++;
	  }
        
	  return primes ;
	}
}
