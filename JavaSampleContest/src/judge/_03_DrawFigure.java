package judge;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DrawFigure {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int height = Integer.parseInt(input.nextLine());
		int sideValue = 0;
		int fillValue = height;
		String side, middle;
		
		for(int cnt = 0; cnt <= height/2; cnt++)
		{
			side = getString('.', sideValue);
			middle = getString('*', fillValue);
			System.out.printf("%s%s%s\n", side, middle, side);
			sideValue += 1;
			fillValue -= 2;
		}
		
		sideValue -= 2;
		fillValue+=4;
		for(int cnt = 0; cnt < height/2; cnt++)
		{
			side = getString('.', sideValue);
			middle = getString('*', fillValue);
			System.out.printf("%s%s%s\n", side, middle, side);
			sideValue -= 1;
			fillValue += 2;
		}
	}
	
	public static String getString(char ch, int size)
	{
		char[] chArray = new char[size];
		Arrays.fill(chArray, ch);
		String result = new String(chArray);
		return result;
	}
}
