package hardquestions;

import java.util.PriorityQueue;

public class MaintainMedian {
	PriorityQueue <Integer> minHeap = new PriorityQueue<Integer> (); 
	PriorityQueue <Integer> maxHeap = new PriorityQueue<Integer> (); 

	Integer passNumber(Integer newNumber) {
		if (maxHeap.isEmpty()) { 
			maxHeap.offer(newNumber); 
		} else if (minHeap.isEmpty() && (newNumber < maxHeap.peek())) { 
			minHeap.offer(maxHeap.poll()); 
			maxHeap.offer(newNumber); 
		} else if (maxHeap.peek() > newNumber) { 
			if (maxHeap.size() > minHeap.size()) {
				minHeap.offer(maxHeap.poll()); 
				maxHeap.offer(newNumber); 
			} else maxHeap.offer(newNumber); 
		} else {
			if (minHeap.size() <= maxHeap.size()) {
				maxHeap.offer(minHeap.poll()); 
				minHeap.offer(newNumber); 
			} else minHeap.offer(newNumber); 
		} 
		return maxHeap.peek(); 
	} 
}


