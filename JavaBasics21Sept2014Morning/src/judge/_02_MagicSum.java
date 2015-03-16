package judge;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_MagicSum {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String inLine = "";
		int checker = Integer.parseInt(input.nextLine());
		boolean hasResult = false;
		int maxSum = Integer.MIN_VALUE;
		String maxResult = "";
		
		while(true)
		{
			inLine = input.nextLine();
			if(inLine.equals("End"))
			{
				break;
			}
			
			numbers.add(Integer.parseInt(inLine));
		}
		
		for(int fst = 0; fst < numbers.size() - 2; fst++)
		{
			for(int snd = fst+1; snd < numbers.size() - 1; snd++)
			{
				for(int trd = snd + 1; trd < numbers.size(); trd++)
				{
					if((numbers.get(fst) + numbers.get(snd) + numbers.get(trd)) % checker == 0
							&& (numbers.get(fst) + numbers.get(snd) + numbers.get(trd)) > maxSum )
					{
						maxResult = String.format("(%d + %d + %d) %% %d = 0\n", numbers.get(fst), numbers.get(snd),
								numbers.get(trd), checker);
						maxSum = numbers.get(fst) + numbers.get(snd) + numbers.get(trd);
						hasResult = true;
					}
				}
			}
		}
		
		if(!hasResult)
		{
			System.out.println("No");
		}
		else
		{
			System.out.println(maxResult);
		}
		
	}

}
