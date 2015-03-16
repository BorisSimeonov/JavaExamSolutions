package judge;

import java.math.BigInteger;
import java.util.Scanner;

public class _05_BitFlipper {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger value = new BigInteger(input.nextLine(), 10);
		String bitValue = value.toString(2);
		if(bitValue.length() < 64)
		{
			bitValue = getString(Math.abs(64 - bitValue.length())) + bitValue;
		}
		StringBuilder buffer = new StringBuilder(bitValue);
		char chValue = ' ';
		//System.out.println(buffer);
		for(int cnt = 0; cnt < buffer.length() - 2; cnt++)
		{
			if(buffer.charAt(cnt) == buffer.charAt(cnt + 1) &&
					buffer.charAt(cnt) == buffer.charAt(cnt + 2))
			{
				switch(buffer.charAt(cnt))
				{
				case '1':
					chValue = '0';
					break;
				default:
					chValue = '1';
					break;
				}
				buffer.setCharAt(cnt, chValue);
				buffer.setCharAt(cnt + 1, chValue);
				buffer.setCharAt(cnt + 2, chValue);
				cnt += 2;
			}
		}
		//System.out.println(buffer);
		BigInteger result = new BigInteger(buffer.toString(), 2);
		System.out.println(result);
	}
	public static String getString(int size)
	{
		char[] chArray = new char[size];
		java.util.Arrays.fill(chArray, '0');
		String result = new String(chArray);
		return result;
	}
}
