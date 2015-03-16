package exam;

import java.util.Scanner;

public class _02_AddingAngles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int degreeCnt = Integer.parseInt(input.nextLine());
		String[] degreeInput = input.nextLine().split(" ");
		int[] degrees = new int[degreeCnt];
		int angle = 0;
		boolean hasFullCircle = false;
		for(int cnt = 0; cnt < degreeCnt; cnt++)
		{
			degrees[cnt] = Integer.parseInt(degreeInput[cnt]);
		}
		int sum = 0;
		
		for(int fst = 0; fst < degreeCnt - 2; fst++)
		{
			for(int snd = fst + 1; snd < degreeCnt - 1; snd++)
			{
				for(int trd = snd + 1; trd < degreeCnt; trd++)
				{
					sum = degrees[fst] + degrees[snd] + degrees[trd];
					if(sum % 360 == 0)
					{
						System.out.printf("%d + %d + %d = %d degrees\n",
								degrees[fst], degrees[snd], degrees[trd], sum);
						hasFullCircle = true;
					}
				}
			}
		}
		
		if(!hasFullCircle)
		{
			System.out.printf("No\n");
		}
				
	}

}
