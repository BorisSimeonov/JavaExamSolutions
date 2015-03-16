package judge;
import java.util.ArrayList;
import java.util.Scanner;


public class _01_Pyramid {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rowCount = Integer.parseInt(input.nextLine());
		String inLine = "";
		String[] numIn;
		int[] numArray;
		int previousValue = 0;
		int skippedRows = 0;
		int closestNum = Integer.MAX_VALUE;
		boolean hasBigger = false;
		ArrayList<Integer> numbers = new ArrayList<>();
		
		for(int cnt = 0; cnt < rowCount; cnt++)
		{
			if(cnt == 0)
			{
				previousValue = Integer.parseInt(input.nextLine().trim());
				numbers.add(previousValue);
			}
			else
			{
				numIn = input.nextLine().trim().replaceAll("[^0-9-]", " ").split(" ");
				numArray = stringToNum(numIn);
				hasBigger = false;
				for(int numIdx = 0; numIdx < numArray.length; numIdx++)
				{
					if(numArray[numIdx] > previousValue + skippedRows && numArray[numIdx] <= closestNum)
					{
						closestNum = numArray[numIdx];
						hasBigger = true;
						continue;
					}
				}
				if(hasBigger)
				{
					numbers.add(closestNum);
					previousValue = closestNum;
					closestNum = Integer.MAX_VALUE;
					skippedRows = 0;
				}
				else
				{
					skippedRows++;
				}
			}
		}
		
		String result = "";
		for(int x: numbers)
		{
			result += x + ", "; 
		}
		System.out.println(result.substring(0, result.length() - 2));
	}

	private static int[] stringToNum(String[] numIn) {
		int[] numbers;
		ArrayList<Integer> nums = new ArrayList<>();
		for(int cnt = 0; cnt < numIn.length; cnt++)
		{
			if(!numIn[cnt].isEmpty())
			{
				nums.add(Integer.parseInt(numIn[cnt]));
			}
		}
		numbers = new int[nums.size()];
		for(int i = 0; i < nums.size(); i++)
		{
			numbers[i] = nums.get(i);
		}
		return numbers;
	}
}
