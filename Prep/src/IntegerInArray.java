import java.util.HashSet;


public class IntegerInArray {
	
	// total time complexity is 2*O(n) = O(n)
	// two iterations through array -> one to add into map
	// and one to cross check each integer for with its 'Y' where 
	// integer + 'Y' = k

	public static boolean run(int[] array, int k) {
		HashSet <Integer> values = new HashSet <Integer>();
		for (int i = 0; i < array.length; i++) values.add(i); 
		for (int i = 0; i < array.length; i++) if (values.contains(new Integer(k-array[i]))) return false;
		return true; 
	}

}
