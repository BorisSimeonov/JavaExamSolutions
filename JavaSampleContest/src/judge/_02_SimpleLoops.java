package judge;

import java.util.Scanner;
import java.math.BigInteger;

public class _02_SimpleLoops {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger first = new BigInteger(input.nextLine());
		BigInteger second = new BigInteger(input.nextLine());
		BigInteger third = new BigInteger(input.nextLine());;
		int getValue = Integer.parseInt(input.nextLine());
		BigInteger next = new BigInteger("0");
		if(getValue <= 3)
		{
			switch(getValue)
			{
				case 1:
				{
					next = first;
					break;
				}
				case 2:
				{
					next = second;
					break;
				}
				default:
				{
					next = third;
					break;
				}
			}
		}
		else{
			for(int cnt = 0; cnt < getValue - 3; cnt++)
			{
				next = first.add(second).add(third);
				first = second;
				second = third;
				third = next;
			}
		}
		System.out.println(next);
	}

}
