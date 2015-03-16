package judge;

import java.util.ArrayList;
import java.util.Scanner;

public class _02_Durts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] centerStr = input.nextLine().split(" ");
		int radius = Integer.parseInt(input.nextLine());
		int durtsCount = Integer.parseInt(input.nextLine());
		ArrayList<Double> durts = new ArrayList<>();
		String inLine = input.nextLine().replaceAll("[^0-9- ]", " ").trim();
		String[] coords = inLine.split(" ");
		
		for(String x: coords)
		{
			try
			{
				double buffer = Double.parseDouble(x);
				durts.add(buffer);
			}
			catch(Exception e)
			{
			}
		}
		
		for(int index = 0; index < durts.size() - 1; index+=2)
		{
			double[] durtCoords = {durts.get(index), durts.get(index+1)};
			double[] center = {Double.parseDouble(centerStr[0]), Double.parseDouble(centerStr[1])};
			checkInside(durtCoords, center, radius);
		}
	}

	private static void checkInside(double[] durtCoords, double[] center, int radius) {
		String result = "no";
		if(durtCoords[0] >= center[0] - radius && durtCoords[0] <= center[0] + radius)
		{
			if(durtCoords[1] <= center[1] + (0.5 * radius) && durtCoords[1] >= center[1] - (0.5 * radius))
			{
				result = "yes";
			}
		}
		
		if(durtCoords[0] >= center[0] - (0.5 * radius) && durtCoords[0] <= center[0] + (0.5 * radius) && result.equals("no"))
		{
			if(durtCoords[1] <= center[1] + radius && durtCoords[1] >= center[1] - radius)
			{
				result = "yes";
			}
		}
		System.out.println(result);
	}

}
