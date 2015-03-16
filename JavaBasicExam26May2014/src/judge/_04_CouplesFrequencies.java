package judge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04_CouplesFrequencies {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String[] rawData = input.nextLine().trim().split(" ");
		int cplCount = rawData.length - 1;
		List<String> checkTracker = new ArrayList<>();
		int counter = 0;
		double percent = 0d;
		String buffer = "";
		
		for(int cnt = 0; cnt < rawData.length - 1; cnt++)
		{
			counter = 1;
			if(!checkTracker.contains((rawData[cnt]) + rawData[cnt+1]))
			{
				checkTracker.add(rawData[cnt] + rawData[cnt+1]);
				for(int index = cnt+1; index < rawData.length - 1; index ++)
				{
					buffer = (rawData[index] + rawData[index+1]);
					if((rawData[cnt] + rawData[cnt+1]).equals(buffer))
					{
						counter++;
					}
				}
				percent = (100/(double)cplCount)*counter;
				System.out.printf("%s %s -> %.2f%%\n", (rawData[cnt]), (rawData[cnt+1]), percent);
			}
		}
	}
}
