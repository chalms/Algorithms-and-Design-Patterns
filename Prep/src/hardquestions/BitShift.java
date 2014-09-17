package hardquestions;

public class BitShift {
	
	public static int addWithoutPlus(int a, int b) {
		if (b == 0) return a; // we have no more carry (or numbers to add) 
		int addWithoutCarry = (a ^ b); // XOR them and add the non carry bits 
		int onlyDoCarry = (a & b) << 1; // ‘and’ the two numbers and shift the result bits left
		return addWithoutPlus(addWithoutCarry, onlyDoCarry); // recurse with the result
	} 

}
