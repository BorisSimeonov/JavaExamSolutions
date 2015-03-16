package exam;

import java.util.Scanner;

public class _01_DozensOfEggs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] inputLine = new String[2];
		int eggs = 0;
		int dozens = 0;
		
		for(int cnt = 0; cnt < 7; cnt++)
		{
			inputLine = input.nextLine().split(" ");
			if(inputLine[1].equals("dozens"))
			{
				eggs += (12 * Integer.parseInt(inputLine[0]));
			}
			else
			{
				eggs += Integer.parseInt(inputLine[0]);
			}
		}
		
		dozens = eggs / 12;
		eggs %= 12;
		System.out.printf("%d dozens + %d eggs", dozens, eggs);
	}

}
