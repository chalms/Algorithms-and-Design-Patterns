import java.util.ArrayList;
import java.util.HashMap;

public class MapReduce {
	
	// UNFINISHED example of using the map reduce function to aggregate document information 
	
	public class NameValuePair {
		public String name; 
		public String value; 
		public NameValuePair(String n, String v) {
			name = n; 
			value = v; 
		}
	}
	class ExampleDocument {
		ArrayList <NameValuePair> data;  
		public ExampleDocument() {
			data = new ArrayList<NameValuePair>(); 
		}
		public void add(String n, String v) {
			data.add(new NameValuePair(n, v)); 
		}
		public String toString() {
			String out = ""; 
			for (NameValuePair pair : data)
				out += (pair.name + " : " + pair.value + "\n");
			return out; 
		}
	}
	
	public class MapList extends ArrayList <ExampleDocument>{
		private static final long serialVersionUID = 1L;
		public ExampleDocument mapReduce(String key, String value, String reduce) {
			HashMap<String, ArrayList <String>> map = new HashMap<String, ArrayList<String>> (); 
			for (int i = 0; i < size(); i++) {
				String valueSave = null;
				String keySave = null; 
				for (int j = 0; j < get(i).data.size(); j++) {
					if (get(i).data.get(j).name.equals(key)) {
						if (!map.containsKey(get(i).data.get(j).value)) 
							map.put(get(i).data.get(j).value, new ArrayList<String>());
						if (valueSave != null) {
							map.get(get(i).data.get(j).value).add(valueSave); 
							valueSave = null; 
						} else {
							keySave = get(i).data.get(j).value; 
						}
					} else if (get(i).data.get(j).name.equals(value)) {
						if (keySave != null) {
							map.get(keySave).add(get(i).data.get(j).value); 
						} else {
							valueSave = get(i).data.get(j).value; 
						}
					}
				}
			}
			ExampleDocument output = new ExampleDocument(); 
			for (String k : map.keySet()) {
				String newValue = ""; 
				if (reduce.equals("sum")) {
					Integer total = 0; 
					for (int i = 0; i < map.get(key).size(); i++) {
						total += Integer.valueOf(map.get(key).get(i)); 
					}
					newValue = String.valueOf(total); 
				}
				output.add(k, newValue); 
			}
			return output; 
		}
	}

	public MapReduce() {
		MapList docs = new MapList (); 
		ExampleDocument doc1 = new ExampleDocument(); 
		doc1.add("temp", "30"); 
		doc1.add("name", "chalmee"); 
		doc1.add("cool", "yee");
		ExampleDocument doc2 = new ExampleDocument(); 
		doc2.add("temp", "25"); 
		doc2.add("name", "chalmee"); 
		doc2.add("cool", "naw");
		ExampleDocument doc3 = new ExampleDocument(); 
		doc3.add("temp", "25"); 
		doc3.add("name", "ricky"); 
		doc3.add("cool", "naw");
		docs.add(doc1); docs.add(doc2); docs.add(doc3); 
		ExampleDocument result = docs.mapReduce("name", "temp", "sum"); 
		System.out.println(result.toString()); 
		// TODO Auto-generated constructor stub
	}

}
