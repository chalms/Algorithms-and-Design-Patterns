import java.util.ArrayList;

public class Main {
  public static void main(String args[]) {
	  
	  String test = "Hello, You, Fuck, Face"; 
	  test = test.replaceAll(",",""); 
	  System.out.println(test); //should be 'Hello You Fuck Face' 
	  String[] t = test.split("\\s+"); 
	  String out = ""; 
	  for (int i = 0; i < t.length; i++) {
		  out += t[i]; 
	  }
	  System.out.println(out); //should be 'HelloYouFuckFace'
	  
//	  runStringSubstringSolver(); 
//	//  runQuickSort(); <---- need to fix
//	  runMergeSort(); 
//	  new MapReduce(); 
   // should be: chalmee : 55
	//			  ricky : 25
  }
  
  static void runStringSubstringSolver() {
	  String s = "ADO00C0BEEACOA"; 
	  String t = "ABC"; 
	  System.out.println("\n~~~~~~String-substring~~~~~"); 
	  System.out.println("S = " + s); 
	  System.out.println("T = ["+t+"]"); 
	  String answer = Solver.solve(s,t); 
	  System.out.println("Solution: "+answer+"\n"); 
  }
  
  static void runQuickSort() {
	  System.out.println("\n~~~~Quick sort~~~~~"); 
	  System.out.println("Ten Random Integer Example: "); 
	  QuickSort qS = new QuickSort(buildRandomIntegerArray(10)); 
	  System.out.println(qS.toString()); 
  }
  
  static void runMergeSort() {
	  System.out.println("\n~~~~Merge sort~~~~~"); 
	  System.out.println("Ten Random Integer Example: "); 
	  new MergeSort(buildRandomIntegerArrayList(10)); 
  }
  public static ArrayList <Integer> buildRandomIntegerArrayList(int size) {
	ArrayList <Integer> arr1 = new ArrayList <Integer> (); 
	for (int i = 0; i < size; i++) {
		arr1.add((int) (Math.random() * (size*2))); 
	}
	return arr1; 
  }
  public static int[] buildRandomIntegerArray(int size) {
	int[] arr1 = new int[size]; 
	for (int i = 0; i < size; i++) {
		arr1[i] = (int) (Math.random() * (size*2)); 
	}
	return arr1; 
  }
}
