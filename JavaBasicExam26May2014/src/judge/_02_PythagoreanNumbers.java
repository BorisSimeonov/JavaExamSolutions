package judge;

import java.util.Scanner;
public class _02_PythagoreanNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int numCount = Integer.parseInt(input.nextLine());
		int[] nums = new int[numCount];
		boolean hasResult = false;
		for(int cnt = 0; cnt < numCount; cnt++)
		{
			nums[cnt] = Integer.parseInt(input.nextLine());
		}
		//iterations over the array
		for(int fst = 0; fst<numCount; fst++)
		{
			for(int snd = 0; snd<numCount; snd++)
			{
				for(int trd = 0; trd<numCount; trd++)
				{
					if(nums[fst] <= nums[snd] && ((nums[fst]*nums[fst]) + 
							(nums[snd]*nums[snd])) == (nums[trd]*nums[trd]))
					{
						System.out.printf("%d*%d + %d*%d = %d*%d\n", nums[fst], nums[fst],
								nums[snd], nums[snd], nums[trd], nums[trd]);
						hasResult = true;
					}
				}
			}
		}
		if(!hasResult)
		{
			System.out.println("No");
		}
	}

}
