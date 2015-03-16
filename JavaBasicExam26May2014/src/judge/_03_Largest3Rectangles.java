package judge;

import java.util.Scanner;

public class _03_Largest3Rectangles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String dataBuffer = input.nextLine().replaceAll(" ", "");
		dataBuffer = dataBuffer.replaceAll("[^0-9]", " ").trim().replaceAll("  ", " ");
		String[] dataArray = dataBuffer.split(" ");
		int[] intArray = new int[dataArray.length];
		for(int cnt = 0; cnt<dataArray.length; cnt++)
		{
			intArray[cnt] = Integer.parseInt(dataArray[cnt]);
		}
		//check the values
		int bestSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for(int fst = 0; fst <= intArray.length - 6; fst+=2)
		{
			currentSum = (intArray[fst] * intArray[fst+1]) +
						(intArray[fst+2] * intArray[fst+3]) + 
						(intArray[fst+4] * intArray[fst+5]);
			if(currentSum > bestSum)
			{
				bestSum = currentSum;
			}
		}
		System.out.println(bestSum);
	}

}
