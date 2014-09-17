import java.util.ArrayList;

public class MergeSort {
	public MergeSort(ArrayList<Integer> ar1) {
		// given an array of random integers sort them 
		SimpleQueue <Integer> result = sort(ar1); 
		System.out.println(result); 
	}
	public SimpleQueue <Integer> sort(ArrayList <Integer> arr) {
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
