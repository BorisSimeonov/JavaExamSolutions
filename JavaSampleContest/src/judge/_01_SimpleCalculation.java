package judge;

import java.util.Scanner;

public class _01_SimpleCalculation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double xAxis = Double.parseDouble(input.nextLine().replaceAll("[^0-9-]", ""));
		double yAxis = Double.parseDouble(input.nextLine().replaceAll("[^0-9-]", ""));
		int result = 0;
		if(xAxis > 0 && yAxis > 0)
		{
			result = 1;
		}
		if(xAxis > 0 && yAxis < 0)
		{
			result = 4;
		}
		if(xAxis == 0 && yAxis != 0)
		{
			result = 5;
		}
		if(yAxis == 0 && xAxis != 0)
		{
			result = 6;
		}
		if(xAxis < 0 && yAxis < 0)
		{
			result = 3;
		}
		if(xAxis < 0 && yAxis > 0)
		{
			result = 2;
		}
		System.out.println(result);
	}

}
