package judge;

import java.math.BigDecimal;
import java.util.Scanner;

public class _03_SimpleExpression {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine().trim().replaceAll("[^0-9-+.]", "");
		String arithm = "+";
		String num = "";
		BigDecimal sum = new BigDecimal("0");
		
		for(int cnt = 0; cnt < line.length(); cnt++)
		{
			if(cnt == 0)
			{
				num = "" + line.charAt(cnt);
				continue;
			}
			
			if((Character.isDigit(line.charAt(cnt)) ||
				line.charAt(cnt) == '.'))
			{
				num += line.charAt(cnt);
			}
			
			if(line.charAt(cnt) == '+' || line.charAt(cnt) == '-') // edit this
			{
				sum = setValue(sum, arithm, num);
				num = "";
				arithm = "" + line.charAt(cnt);
				continue;
			}
			
			if(cnt == line.length() - 1)
			{
				sum = setValue(sum, arithm, num);
				break;
			}
		}
		System.out.printf("%.7f", sum);
	}

	private static BigDecimal setValue(BigDecimal sum, String arithm, String num) {
		BigDecimal nextValue = new BigDecimal(num);
		
		if(arithm.equals("-"))
		{
			nextValue = sum.subtract(nextValue);
		}
		else
		{
			nextValue = sum.add(nextValue);
		}
		
		return nextValue;
	}

}
