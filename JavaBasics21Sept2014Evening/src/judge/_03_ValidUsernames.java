package judge;

import java.util.Scanner;

public class _03_ValidUsernames {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inLine = input.nextLine().trim().replaceAll("[^a-zA-Z0-9_]", " ");
		String[] namesArray = inLine.split(" ");
		int currentLength = 0;
		int maxLength = 0;
		String[] maxNames = new String[2];
		
		for(int fst = 0; fst < namesArray.length - 1; fst++)
		{
			if(namesArray[fst].isEmpty() || Character.isDigit(namesArray[fst].charAt(0)) ||
					namesArray[fst].length() < 3 || namesArray[fst].length() > 25)
			{
				continue;
			}
			for(int snd = fst+1; snd < namesArray.length; snd++)
			{
				if(namesArray[snd].isEmpty() || Character.isDigit(namesArray[snd].charAt(0)) ||
						namesArray[snd].length() < 3 || namesArray[snd].length() > 25)
				{
					continue;
				}
				else
				{
				//else
					currentLength = namesArray[fst].length() + namesArray[snd].length(); 
					if(currentLength > maxLength)
					{
						maxNames[0] = namesArray[fst];
						maxNames[1] = namesArray[snd];
						maxLength = currentLength;
					}
					fst = snd - 1;
					break;
				}
			}
		}
		System.out.printf("%s\n%s", maxNames[0], maxNames[1]);
	}

}
