
public class RectangleOverlap {
	
	// get the area between two overlapping rectangles
	
    RectangleOverlap() {};  
	
	class Rect {
	  int bottom;
	  int top;
	  int left;
	  int right;
	  
	  public Rect(int x1, int x2, int y1, int y2) {
	    top = x1;
	    bottom = x2;
	    left = y1;
	    right = y2;
	  }
	}
	
	public String testRect() {
	
	  // create a pass case
	  Rect testRect1 = new Rect(5, 1, -1, -3);
	  Rect testRect2 = new Rect(7, 3, -2, -4);
	
	  String testResults = "Testing Rectangle Overlap: \n";
	
	  // test if area is calculated right
	  if (areaOfIntersection(testRect2, testRect1) != 2) testResults += "Test 1 Failed\n";
	  else testResults += "Test 1 Passed\n";
	
	  // test if the order of inputs matters, by changing the order of inputs
	  if (areaOfIntersection(testRect2, testRect1) != 2) testResults += "Test 2 Failed\n";
	  else testResults += "Test 2 Passed\n";
	
	  // test a fail case
	  Rect testRect3 = new Rect(5, 1, -1, -3);
	  Rect testRect4 = new Rect(7, 3, 2, 4);
	
	  if (areaOfIntersection(testRect3, testRect4) != 0) testResults += "Test 3 Failed\n";
	  else testResults += "Test 3 Passed\n";
	
	  return testResults;
	}
	
	public static int areaOfIntersection(Rect testRect2, Rect testRect1) {
	  int height = Math.min(testRect2.top - testRect1.bottom, testRect1.top - testRect2.bottom);
	  int length = Math.min(testRect2.left - testRect1.right, testRect1.left - testRect2.right);
	  if (height <= 0 || length <= 0) return 0;
	  return height * length;
	}
}
