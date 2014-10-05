

public class SimpleQueue <T> {
	public class Node <Q> {
		public Q data = null; 
		public Node <Q> next = null;  
		public Node () {}
	}
	Node <T> first = null;  
	Node <T> last = null; 
	int size = 0; 
	
	public SimpleQueue () {
		last = new Node <T> (); 
		first = last; 
		// TODO Auto-generated constructor stub
	}
	public int size() {
		return size; 
	}
	public Node <T> getLast() {
		return last; 
	}
	
	public Node <T> getFirst() {
		return first; 
	}
	
	public T pop() {
		T returnData = null; 
		if (first != null) {
			returnData = first.data; 
			first = first.next; 
		}
		size--; 
		return returnData; 
	}
	
	public T peek() {
		if (first == null) return null; 
		return first.data; 
	}
	
	public boolean remove(T value){
		Node <T> interest = first; 
		Node <T> before = null; 
		if (interest == null) return false; 
		while (interest.next != null) {
			if (interest.data.equals(value)) {
				if (before != null) before.next = interest.next; 
				interest.next = null; 
				interest.data = null; 
				return true; 
			}
			before = interest; 
			interest = interest.next; 
		}
		size--; 
		return false;
	}
	
	public boolean isEmpty() {
		if (first == null) return true; 
		if (first.data == null) return true; 
		return false; 
	}
	
	public void push(T d) {
		last.data = d; 
		last.next = new Node <T> (); 
		last = last.next; 
		size++; 
	}
	
	public String toString() {
		String str = "["; 
		Node <T> node = first; 
		while(node != null) {
			if (node.data != null) str += String.valueOf(node.data); 
			if (node.next != null) 
				if (node.next.data != null) str += ","; 
			node = node.next; 
		}
		str += "]"; 
		return str; 
	}
}
