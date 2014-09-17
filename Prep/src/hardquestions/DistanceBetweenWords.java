package hardquestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DistanceBetweenWords {

	public static void readFile(String name, String wordOne, String wordTwo) { 
		try { 
			BufferedReader input = new BufferedReader(new FileReader(new File(name))); 
			String last = "";  
			Integer index = 0; 
			Integer count = 0; 
			Integer spread = null; 
			Integer spreadCount = null; 
			String line = null;
			while((line = input.readLine()) != null) {
				line.replaceAll(",", ""); 
				String[] words = line.split("\\s+/"); 
				for (int i = 0; i < words.length; i++) { 
					String word = words[i]; 
					count += word.length(); 
					if (word.equals(wordOne) || word.equals(wordTwo)) {
						if (last.equals("") || last.equals(word)) {
							index = count; 
							last = word;
							int newSpread = (count - index); 
							boolean update = false; 
							if (spread == null) update = true; 
							else if (newSpread < spread) update = true; 
							if (update) { 	
								spread = newSpread; 
								spreadCount = count; 
								index = count; 
								last = word; 
							}
						} 
					}
					count += 1; // for space between words
				}
			}
			input.close(); 
			System.out.println(String.valueOf(spreadCount - spread) + " - " + String.valueOf(spreadCount)); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
//		} catch (UnknownFileException e1) {
//			e1.printStackTrace(); 
//		}
	}

}
