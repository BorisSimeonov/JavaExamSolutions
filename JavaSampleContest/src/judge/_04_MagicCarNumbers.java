package judge;

import java.util.Scanner;

public class _04_MagicCarNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int magicValue = Integer.parseInt(input.nextLine());
		int sumLast = 0;
		//String result = "";
		int counter = 0;
		for(int fst = 0; fst <=9; fst++)
		{
			for(int snd = 0; snd <= 9; snd++)
			{
				for(int trd = 0; trd<=9; trd++)
				{
					for(int frth = 0; frth <=9; frth++)
					{
						if((fst == snd && snd == trd && trd == frth) ||
								(snd == trd && trd == frth && fst != snd) ||
								(fst == snd && snd == trd && frth != fst) ||
								(fst == snd && trd == frth && fst != frth) ||
								(fst == frth && snd == trd && fst != snd) ||
								(fst == trd && snd == frth && fst != snd))
						{
							for(int endOne = 0; endOne < 10; endOne++)
							{
								for(int endTwo = 0; endTwo < 10; endTwo++)
								{
									sumLast = getLast(endOne);
									sumLast += getLast(endTwo);
									if(40 + sumLast + (fst + snd + trd + frth) == magicValue)
									{
										counter++;
										/*result += "CA" + fst + snd + trd + frth + getChar(endOne) +
												getChar(endTwo) + ", ";*/
									}
								}
							}
						}
					}
				}
			}
		}
		//result = result.substring(0, result.length() - 2);
		System.out.println(counter);
	}
	
	/*private static String getChar(int value) {
		switch(value)
		{
		case 0:
			return "A";
		case 1:
			return "B";
		case 2: 
			return "C";
		case 3:
			return "E";
		case 4: 
			return "H";
		case 5:
			return "K";
		case 6:
			return "M";
		case 7:
			return "P";
		case 8: 
			return "T";
		default:
			return "X";
		}
	}*/

	private static int getLast(int value) {
		
		switch(value)
		{
		case 0:
			return 10;
		case 1:
			return 20;
		case 2: 
			return 30;
		case 3:
			return 50;
		case 4: 
			return 80;
		case 5:
			return 110;
		case 6:
			return 130;
		case 7:
			return 160;
		case 8: 
			return 200;
		default:
			return 240;
		}
	}

}
