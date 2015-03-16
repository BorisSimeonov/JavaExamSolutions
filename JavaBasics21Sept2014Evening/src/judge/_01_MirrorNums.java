package judge;

import java.util.Scanner;

public class _01_MirrorNums {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		String[] inArray = input.nextLine().split(" ");
		boolean hasResult = false;
		
		for(int fst = 0; fst < count - 1; fst++)
		{
			for(int snd = fst+1; snd < count; snd++)
			{
				if(checkMirror(inArray[fst], inArray[snd]))
				{
					hasResult = true;
					System.out.printf("%s<!>%s\n", inArray[fst], inArray[snd]);
				}
			}
		}
		
		if(!hasResult)
		{
			System.out.println("No");
		}
	}

	private static boolean checkMirror(String first, String second) {
		
		boolean mirror = true;
		for(int index = 0; index < 4; index++)
		{
			if(first.charAt(index) != second.charAt((second.length() - 1) - index))
			{
				mirror = false;
				break;
			}
		}
		return mirror;
	}

}
