import java.util.HashMap;

  
class HashQueue extends HashMap <Character, Integer>   {
	  
	 class Node {
		  Node next = null; 
		  Character data = null; 
		  Node() {}
	  }
	Node last = new Node(); 
	Node first = last; 
	public Integer size; 
	public Integer lastIndex; 
	
	private static final long serialVersionUID = 1L;

	public Integer put(Character key, Integer val) {
		if (containsKey(key)){
			remove(key); 
		} 
		if (first.data != null) size = val - get(first.data); 
		last.data = key; 
		last.next = new Node(); 
		last = last.next; 
		lastIndex = val; 
		return super.put(key, val); 
	}
	
	public Integer removeFirst() {
		return remove(first.data); 
	}
	
	public Integer remove(Character key) {
		Integer val = super.remove(key); 
		if (val != null)  {
			Node temp = first; 
			while (temp != null) {
				if (temp.data.equals(key)) {
					first = temp.next; 
					break; 
				} else if (temp.next != null){
					if (temp.next.data.equals(key)) {
						temp.next = temp.next.next; 
						break; 
					}
				}
			}
		}
		return val; 
	}
}