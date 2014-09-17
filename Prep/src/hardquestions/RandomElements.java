package hardquestions;

public class RandomElements {


public static int[] pickMElements(int[] n, int m) {
	if (m > n.length) return null; 
	int[] subset = new int[m]; 
	int[] orig = n.clone(); 
	int j = 0; 
	while (j < m) { 
		int maxIndex = n.length - 1; 
		int newIndex = (int) (Math.random() * (maxIndex-j) + j) ; 
		subset[newIndex] = orig[j]; 
		orig[j] = orig[newIndex]; 
		j++;
	} 
	return subset; 
}


}
