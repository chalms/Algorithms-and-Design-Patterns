package hardquestions;

import java.util.PriorityQueue;

public class MillionInBillion {

	public static Integer[] findOneMillionSmallest(int[] numbers) { 
		PriorityQueue <Integer> minHeap = new PriorityQueue <Integer> (); 
		for (int i = 0; i < numbers.length; i++) { 
			if (minHeap.size() > 1000000) {
				if (numbers[i] > minHeap.peek()) 
					minHeap.poll(); 
					minHeap.offer(numbers[i]); 
			} else minHeap.offer(numbers[i]); 
		} 
		Integer[] output = (Integer[]) minHeap.toArray();
		return output; 	
	} 
		
}
