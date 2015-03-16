package judge;

import java.util.Scanner;

public class _01_Timespan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] time = {input.nextLine(), input.nextLine()};
		long[] timeToSec = new long[2];
		String[] buffer = new String[3];
		
		for(int cnt = 0; cnt < 2; cnt++)
		{
			buffer = time[cnt].split(":");
			timeToSec[cnt] = (Long.parseLong(buffer[0]) * 3600) + 
					(Long.parseLong(buffer[1]) * 60) + 
					(Long.parseLong(buffer[2]));
		}
		
		long interval = Math.abs(timeToSec[0] - timeToSec[1]);
		
		System.out.printf("%d:%02d:%02d", (int)(interval / 3600), (int)((interval % 3600) / 60), (int)(interval % 60));
	}

}
