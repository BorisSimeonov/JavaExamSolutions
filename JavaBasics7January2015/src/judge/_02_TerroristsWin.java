package judge;
import java.util.Arrays;
import java.util.Scanner;


public class _02_TerroristsWin {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inLine = input.nextLine();
		String result = "";
		int bombLength = 1;
		int blastRadius = 0;
		String bombInside = "";
		int startIndex = 0;
		
		for(int cnt = 0; cnt < inLine.length(); cnt++)
		{
			if(inLine.charAt(cnt) == '|')
			{
				bombLength = 1;
				bombInside = "";
				for(int bomb = cnt + 1; bomb < inLine.length(); bomb++)
				{
					if(inLine.charAt(bomb) == '|')
					{
						bombLength++;
						break;
					}
					else
					{
						bombInside += inLine.charAt(bomb);
						bombLength++;
					}
				}
				blastRadius = getRadius(bombInside);
				if(cnt - blastRadius >= 0 && cnt + blastRadius + bombLength<= inLine.length() - 1)
				{
					result += inLine.substring(startIndex, cnt - blastRadius);
					result += getString('.', (blastRadius * 2) + bombLength);
				}
				else
				{
					if(cnt + blastRadius + bombLength > inLine.length() - 1)
					{
						result += inLine.substring(startIndex, cnt - blastRadius);
					}
					result += getString('.', blastRadius + bombLength);			
				}
				cnt += bombLength + blastRadius;
				startIndex = cnt;
			}
			
			if(cnt == inLine.length() - 1)
			{
				result += inLine.substring(startIndex);
			}
			
		}
		System.out.println(result);
	}

	private static int getRadius(String bombInside) {
		// TODO Auto-generated method stub
		int value = 0;
		for(int cnt = 0; cnt < bombInside.length(); cnt++)
		{
			value += (int)bombInside.charAt(cnt);
		}
		value %= 10;
		return value;
	}
	public static String getString(char ch, int size)
	{
		char[] chArray = new char[size];
		Arrays.fill(chArray, ch);
		String result = new String(chArray);
		return result;
	}
}