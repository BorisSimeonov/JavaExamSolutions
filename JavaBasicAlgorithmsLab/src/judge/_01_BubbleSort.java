package judge;

import java.util.Arrays;
import java.util.Scanner;

public class _01_BubbleSort {
 
 
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
 
    public static void sortArray(int[] unsorted){
        for(int iterations=0; iterations<unsorted.length -1; iterations++){
            for(int j = 1; j<unsorted.length - iterations; j++){
                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
        } 
        System.out.printf("%s\n", Arrays.toString(unsorted));
        
    }
}
