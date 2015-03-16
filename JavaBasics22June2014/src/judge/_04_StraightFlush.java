package judge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _04_StraightFlush {
	
	public static boolean hasFlush = false;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] hand = input.nextLine().split("\\W+");
		HashSet<String> cardSet= new HashSet<String>(Arrays.asList(hand));
		int counter;
		String current = "";
		String next = "";
		
		if(cardSet.size() >= 5)
		{
			for(int index = 0; index < hand.length; index++)
			{
				counter = 1;
				current = hand[index];
				for(int cnt = 0; cnt < 5; cnt++)
				{
					next = getNext(current);
					if(cardSet.contains(next))
					{
						counter++;
						current = next;
					}
					else
					{
						break;
					}
						
					if(counter == 5)
					{
						hasFlush = true;
						printResult(hand[index]);
					}
				}
			}
		}
		
		if(!hasFlush)
		{
			System.out.println("No Straight Flushes");
		}
	}
	
	private static String getNext(String current) {
		String[] cardDeck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		int index = Arrays.asList(cardDeck).indexOf(current.substring(0, current.length() - 1));
		if(index + 1 < cardDeck.length)
		{
			return cardDeck[index+1] + current.charAt(current.length() - 1);
		}
		else
		{
			return "X";
		}
	}
	
	private static void printResult(String startValue) {
		String result = "[" + startValue + ", ";
		String deck = "" + startValue.charAt(startValue.length() - 1);
		String[] cardDeck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		int index = Arrays.asList(cardDeck).indexOf(startValue.substring(0, startValue.length() - 1));
		for(int cnt = 0; cnt < 4; cnt++)
		{
			index++;
			result += cardDeck[index] + deck + ", ";
		}
		result = result.substring(0, result.length() - 2) + "]";
		System.out.println(result);
	}
}
