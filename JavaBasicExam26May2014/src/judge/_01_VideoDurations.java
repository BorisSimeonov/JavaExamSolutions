package judge;

import java.util.Scanner;

public class _01_VideoDurations {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String values = "";
		int minutes = 0;
		int hours = 0;
		String[] durations = new String[2];
		while(true)
		{
			values = input.nextLine();
			if(values.equals("End"))
			{
				break;
			}
			else
			{
				durations = values.replaceAll("[^0-9]", " ").split(" ");
				minutes += Integer.parseInt(durations[1]);
				hours += Integer.parseInt(durations[0]);
			}
		}
		
		hours += minutes / 60;
		minutes = minutes % 60;
		String result = String.format("%d:%02d", hours, minutes);
		System.out.println(result);
	}
}