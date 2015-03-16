package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class _03_BiggestThreePrime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] inputArray = input.nextLine().trim().replaceAll("[^0-9- ]", " ").split(" ");
		ArrayList<Integer> intArray = new ArrayList<>();
		int checkPrime = 0;
		boolean isPrime = false;
		for(int cnt = 0; cnt < inputArray.length; cnt++)
		{
			if(inputArray[cnt].length() >= 1)
			{
				checkPrime = Integer.parseInt(inputArray[cnt]);
				isPrime = checkTheNumber(checkPrime);
				if(isPrime)
				{
					intArray.add(checkPrime);
				}
			}
		}
		
		int sum = 0;
		int maxSum = 0;
		boolean hasResult = false;
		
		for(int fst = 0; fst < intArray.size() - 2; fst++)
		{
			for(int snd = fst + 1; snd < intArray.size() - 1; snd++)
			{
				for(int trd = snd + 1; trd < intArray.size(); trd++)
				{
					if(intArray.get(fst) != intArray.get(snd) && intArray.get(fst) != intArray.get(trd)
							&& intArray.get(snd) != intArray.get(trd))
					{
						sum = intArray.get(fst) + intArray.get(snd) + intArray.get(trd);
						maxSum = Math.max(sum, maxSum);
						hasResult = true;
					}
				}
			}
		}
		System.out.printf(hasResult ? "%d" : "No", maxSum );
	}

	private static boolean checkTheNumber(int checkPrime) {
		boolean isPrime = true;
		if(checkPrime == 2)
		{
			return isPrime;
		}
		if(checkPrime <= 1)
		{
			isPrime = false;
			return isPrime;
		}
		else if(checkPrime > 2)
		{			
			for(int cnt = 2; cnt <= checkPrime / 2; cnt++)
			{
				if(checkPrime % cnt == 0)
				{
					isPrime = false;
					break;
				}
			}
		}
		return isPrime;
	}

}
