package judge;

import java.util.Scanner;

public class _02_SumCards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] cards = input.nextLine().trim().replaceAll("[^0-9JQKA ]", "").split(" ");
		int count = 0;
		int sum = 0;
		String buffer = "";
		
		for(int cnt = 0; cnt < cards.length; cnt++)
		{
			if(cnt == 0)
			{
				buffer = cards[0];
				count++;
				if(cnt == cards.length - 1)
				{
					sum += getValue(buffer);
					break;
				}
				continue;
			}
			if(buffer.equals(cards[cnt]))
			{
				count++;
			}
			else
			{
				if(count > 1)
				{
					sum += (getValue(buffer) * count) * 2;
				}
				else
				{
					sum += getValue(buffer);
				}
				buffer = cards[cnt];
				count = 1;
			}
			
			if(cnt == cards.length - 1)
			{
				if(count > 1)
				{
					sum += (getValue(buffer) * count) * 2;
				}
				else
				{
					sum += getValue(buffer);
				}
			}
		}
		System.out.println(sum);
	}
	
	private static int getValue(String x)
	{
		int value = 0;
		switch(x)
		{
		case "J":
			value = 12;
			break;
		case "Q":
			value = 13;
			break;
		case "K":
			value = 14;
			break;
		case "A":
			value = 15;
			break;
		default:
			value = Integer.parseInt(x);
		}
		return value;
	}
}
