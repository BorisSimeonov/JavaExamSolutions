package judge;

import java.util.Scanner;

public class _03_WeirdStrings {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inLine = input.nextLine().trim().replaceAll("[\\/()|0-9 ]", "");
		String[] words = inLine.split("[^a-zA-Z]");
		int maxWeight = 0;
		int currentWeight;
		String[] maxWords = new String[2];
		
		for(int fst = 0; fst < words.length - 1; fst++)
		{
			if(words[fst].isEmpty())
			{
				continue;
			}
			for(int snd = fst+1; snd < words.length; snd++)
			{
				if(words[snd].isEmpty())
				{
					continue;
				}
				currentWeight = getWeight(words[fst].toLowerCase(), words[snd].toLowerCase());
				if(currentWeight > maxWeight)
				{
					maxWeight = currentWeight;
					maxWords[0] = words[fst];
					maxWords[1] = words[snd];
				}
				break;
			}
		}
		
		for(String x: maxWords)
		{
			System.out.println(x);
		}
	}

	private static int getWeight(String first, String second) {
		
		String[] in = {first, second};
		int weight = 0;
		for(int cnt = 0; cnt < 2; cnt++)
		{
			for(int index = 0; index < in[cnt].length(); index++)
			{
				weight += ((int)in[cnt].charAt(index) - 96);
			}
		}
		return weight;
	}

}
