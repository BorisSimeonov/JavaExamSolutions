package judge;

import java.util.Scanner;

public class _01_StuckNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCnt = Integer.parseInt(input.nextLine());
		String[] strNums = input.nextLine().split(" ");
		int[] intArray = new int[numCnt];
		for(int cnt = 0; cnt<numCnt; cnt++)
		{
				intArray[cnt] = Integer.parseInt(strNums[cnt]);
		}
		int counter = 0;
		
		for(int fst = 0; fst<numCnt; fst++)
		{
			for(int snd = 0; snd<numCnt; snd++)
			{
				if(snd == fst)
				{
					continue;
				}
				for(int trd = 0; trd<numCnt; trd++)
				{
					if(trd == snd || trd == fst)
					{
						continue;
					}
					for(int frth = 0; frth<numCnt; frth++)
					{
						if(frth == trd || frth == snd || frth == fst)
						{
							continue;
						}
						else if((strNums[fst] + strNums[snd]).equals(strNums[trd] + strNums[frth]) )
						{
								System.out.printf("%s|%s==%s|%s\n", strNums[fst], strNums[snd], strNums[trd], strNums[frth]);
								counter++;
						}
					}
				}
			}
		}
		if(counter == 0)
		{
			System.out.println("No");
		}
	}

}
