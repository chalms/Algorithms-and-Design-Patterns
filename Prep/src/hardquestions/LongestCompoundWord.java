package hardquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestCompoundWord {


class MyQueue extends PriorityQueue <String> { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HashMap <Integer, Queue<String>> queueMap = new HashMap <Integer, Queue<String>> ();
	public HashMap <Integer, HashSet<String>> wordsForLength = new HashMap <Integer, HashSet<String>> ();  
	public boolean offer(String offering) { 
		Integer length = offering.length(); 
		if (!queueMap.containsKey(length)) {
			queueMap.put(length, (Queue<String>) new LinkedList <String>()); 
			wordsForLength.put(length,  new HashSet <String> ()); 
		}
		queueMap.get(length).offer(offering); 
		wordsForLength.get(length).add(offering); 
		return super.offer(offering); 
	} 

	public String poll() { 
		String s1 = super.poll(); 
		String s2 = null; 
		if (s1 != null){ s2 = queueMap.get(s1.length()).poll(); 
		wordsForLength.get(s1.length()).remove(s1); 
		} else return null; //s1 must be null
		if (!s1.equals(s2)) return null; // code must have gotten unsynchronized
		else return s1; 
	}
} 

	String longestCompound(String input) { 
		input.replaceAll(",", ""); 
		ArrayList <String> list = (ArrayList<String>) Arrays.asList(input.split("\\s+/")); 
		MyQueue queuer = new MyQueue(); 
		for(String word : list) { 
			queuer.offer(word); 
		} 
		while (!queuer.isEmpty()) {
			String start = queuer.poll(); 
			for (int i = 1; i < start.length(); i++) {
				if (queuer.queueMap.containsKey(i) && queuer.queueMap.containsKey(start.length()-i)) {
					if (queuer.wordsForLength.get(i).contains(start.substring(0, i)) && 
							queuer.wordsForLength.get(start.length()-i).contains(start.substring(i, start.length()))) {
						return start; 
					}
				}
			}
		}
		return null; 
	} 

}
