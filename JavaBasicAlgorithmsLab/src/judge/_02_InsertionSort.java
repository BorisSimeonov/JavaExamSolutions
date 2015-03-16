package judge;
//very fast method
import java.util.Arrays;
import java.util.Scanner;

public class _02_InsertionSort {

	public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String[] strArray = input.nextLine().replaceAll("[^0-9- ]", "").split(" ");
        int[] unsorted = new int[strArray.length];
        for(int index = 0; index < strArray.length; index++)
        {
        	unsorted[index] = Integer.parseInt(strArray[index]);
        }
        sortArray(unsorted);
    }

	private static void sortArray(int[] unsorted) {
		
		int n = unsorted.length;
		for (int j = 1; j < n; j++) {
			int key = unsorted[j];
			int i = j-1;
				while ( (i > -1) && ( unsorted [i] > key ) ) {
					unsorted [i+1] = unsorted [i];
				    i--;
				}
			unsorted[i+1] = key;
		}
		System.out.printf("%s\n", Arrays.toString(unsorted));
	}  

}