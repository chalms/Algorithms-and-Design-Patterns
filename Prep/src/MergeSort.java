import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	
	public static ArrayList <Integer> arrayToArrayList(int[] arr) {
		ArrayList <Integer> list = new ArrayList <Integer> (); 
		for (int i = 0; i < arr.length; i++) {
			list.add(new Integer(arr[i])); 
		}
		return list; 
	}
	
	
	public static String testArraysEqual(int[] primes, int[] result, String testName) {
		  boolean passed = true; 
		  if (result.length != primes.length) { 
			  String printThis = ""; 
			  printThis += "result length: " + String.valueOf(result.length) + ", input length: " + String.valueOf(primes.length); 
			  System.out.println(printThis); 
			  return testName + " failed\n"; 
		  }
		  for (int i = 0; i < result.length; i++) { 
			  if (result[i] != primes[i]) { 
				  String printThis = ""; 
				  for (int j = 0; j <= i; j++) {
					  printThis += ("[" + String.valueOf(result[i]) + "," + String.valueOf(primes[i]) + "]"); 
				  }
				  System.out.println(printThis); 
				  passed = false; 
				  break; 
			  }
		  }
		  if (passed) return testName + " passed\n"; 
		  else return testName + " failed\n";
	}
	
	
	public static String testMergeSort() {
		String testResults = "Merge sort: \n"; 
		int[] test1Arr = {4000, -200, 37, 0, -50}; 
		int[] test1Outputs = {-200, -50, 0, 37, 4000}; 
		testResults += testArraysEqual(runMergeSort(arrayToArrayList(test1Arr)), test1Outputs, "test 1"); 
		
		int[] test2Arr = new int[10000]; 
		int[] test3Arr = new int[10000]; 
		int lowerBound = -50000; 
		int upperBound = 50000; 
		
		for (int i = 0; i < test2Arr.length; i++) {
			// I dont think I need to do this to ensure both arrays arent referencing the same 
			// values, but I am too lazy to look it up
			int num1 = 0; 
			int num2 = 0; 
			num1 = ((int) Math.random() * (upperBound - lowerBound)) + lowerBound; 
			num2 = num1; 
			test2Arr[i] = num1;  
			test3Arr[i] = num2; 
		}
		// use the java auto-sort to sort one of the arrays
		Arrays.sort(test3Arr, 0, test3Arr.length-1); 
		
		// compare both results
		testResults += testArraysEqual(runMergeSort(arrayToArrayList(test2Arr)), test3Arr, "test 2"); 
		
		return testResults; 
	}
	public static int[] runMergeSort(ArrayList<Integer> ar1) {
		// given an array of random integers sort them 
		SimpleQueue <Integer> resultQueue = sort(ar1); 
		int[] result = new int[resultQueue.size()]; 
		int index = 0; 
		while (!resultQueue.isEmpty()) {
			result[index] = resultQueue.pop(); 
			index++; 
		}
		return result; 
	}
	
	// recursively sort using custom 'SimpleQueue' data structure
	public static SimpleQueue <Integer> sort(ArrayList <Integer> arr) {
		SimpleQueue <Integer> q1; 
		SimpleQueue <Integer> q2; 
		if (arr.size() > 2) {
			Integer newSize = arr.size() / 2; 
			ArrayList <Integer> newList = new ArrayList <Integer> (); 
			for (int i = 0; i < newSize; i++) {
				newList.add(arr.remove(i)); 
			}
			q1 = sort(newList); 
			q2 = sort(arr); 
		} else {
			q1 = new SimpleQueue <Integer> (); 
			q2 = new SimpleQueue <Integer> (); 
			while (arr.size() > 0) {
				if (q1.isEmpty()) {
					q1.push(arr.remove(0));
				} else {
					q2.push(arr.remove(0));
				}
			}
		}
		SimpleQueue <Integer> returnQueue = new SimpleQueue <Integer> (); 
		while ((!q1.isEmpty()) || (!q2.isEmpty())) {
			if (q1.isEmpty()) {
				returnQueue.push(q2.pop()); 
			} else if (q2.isEmpty()) {
				returnQueue.push(q1.pop()); 
			} else if (q1.peek() < q2.peek()) {
				returnQueue.push(q1.pop()); 
			} else {
				returnQueue.push(q2.pop()); 
			}
		}
		return returnQueue; 
	}
}
