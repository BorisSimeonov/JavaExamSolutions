package judge;

import java.util.Scanner;

public class _02_PossibleTriangles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inLine;
		String[] sides = new String[3];
		double[] sideDbl = new double[3];
		boolean hasResult = false;
		while(true)
		{
			inLine = input.nextLine();
			if(inLine.equals("End"))
			{
				break;	
			}
			
			sides = inLine.split(" ");
			for(int cnt = 0; cnt < 3; cnt++)
			{
				sideDbl[cnt] = Double.parseDouble(sides[cnt]);
				for(int lastIdx = cnt; lastIdx >= 1; lastIdx--)
				{
					if(sideDbl[lastIdx] > sideDbl[lastIdx - 1])
					{
						double buffer = sideDbl[lastIdx - 1];
						sideDbl[lastIdx - 1] = sideDbl[lastIdx];
						sideDbl[lastIdx] = buffer;
					}
				}
			}
			
			if(sideDbl[1] + sideDbl[2] > sideDbl[0])
			{
				System.out.printf("%.02f+%.02f>%.02f\n", sideDbl[2], sideDbl[1], sideDbl[0]);
				hasResult = true;
			}
		}
		if(!hasResult)
		{
			System.out.println("No");
		}
	}

}
