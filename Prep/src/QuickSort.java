public class QuickSort {
	int[] list = null; 
	public void swap(int a, int b) {
		int temp = list[a]; 
		list[a] = list[b]; 
		list[b] = temp;
	}
	public void swapThree(int a, int b, int c) {
		int temp = list[a]; 
		list[a] = list[c];
		list[c] = list[b]; 
		list[b] = temp; 
	}
	public void sort(int low, int pivot, int max) {
		
//		Needs to be fixed ---> 
//		System.out.println(toString() + "\t" + String.valueOf(pivot) + "\t[" + String.valueOf(list[pivot]) + "]"); 
//		int lowIndex = low; 
//		int maxIndex = pivot + 1;
//		while ((lowIndex < pivot) && (maxIndex <= max)) {
//			while (list[lowIndex] < list[pivot] && (lowIndex < pivot)) lowIndex++; 
//			while ((list[maxIndex] > list[pivot]) && (maxIndex < max)) maxIndex++; 
//			if (lowIndex >= pivot) 
//				if (maxIndex <= max) {
//					swapThree(pivot, pivot+1, maxIndex); 
//					pivot = pivot + 1; 
//				}
//			else if (maxIndex > max) {
//				swapThree(pivot, pivot-1, lowIndex); 
//				pivot = pivot - 1; 
//			}
//			if (!(maxIndex > max) && !(lowIndex >= pivot) ) swap(lowIndex, maxIndex); 
//			lowIndex ++; 
//			maxIndex ++; 
//		}

	}
	public String toString() {
		String str = "["; 
		for (int i = 0; i < list.length; i++) {	
			str += String.valueOf(list[i]); 
				if ((i + 1) < list.length) str += ","; 
		}
		str += "]"; 
		return str; 
	}
 	public QuickSort(int[] l) {
 		list = l; 
 		int max = list.length - 1; 
 		int mid = list.length / 2; 
 		if (list[max] < list[mid]) swap(mid, max); 
 		if (list[mid] < list[0]) swap(mid, 0); 
 		sort(0, mid, max); 
	}
}
