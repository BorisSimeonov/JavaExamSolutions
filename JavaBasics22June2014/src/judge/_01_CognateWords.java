package judge;

import java.util.ArrayList;
import java.util.Scanner;


public class _01_CognateWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inBuffer = input.nextLine().replaceAll("[^a-zA-Z]", " ").replaceAll("  ", " ").trim();
		String[] strArray = inBuffer.split(" ");
		boolean hasValue = false;
		ArrayList<String> array = new ArrayList<>();
				
		for(int fst = 0; fst<strArray.length; fst++)
		{
			if(strArray[fst].isEmpty())
			{
				continue;
			}
			for(int snd = 0; snd<strArray.length; snd++)
			{
				if(snd == fst || strArray[snd].isEmpty())
				{
					continue;
				}
				for(int trd = 0; trd<strArray.length; trd++)
				{
					if(trd == fst || trd == snd || strArray[trd].isEmpty())
					{
						continue;
					}
					if((strArray[fst] + strArray[snd]).equals(strArray[trd]))
					{
						String buffer = strArray[fst] + "|" + strArray[snd] + "=" + strArray[trd];
						if(!array.contains(buffer))
						{
							array.add(buffer);
							hasValue = true;
						}
					}
				}
			}
		}
		
		if(!hasValue)
		{
			System.out.println("No");
		}
		else
		{
			for(String x: array)
			{
				System.out.printf("%s\n", x);
			}
		}
	}

}
