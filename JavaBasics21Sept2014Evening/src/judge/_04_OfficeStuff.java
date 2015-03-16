package judge;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_OfficeStuff {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int firms = Integer.parseInt(input.nextLine());
		TreeMap<String, LinkedHashMap<String, Integer>> firmMap = new TreeMap<>();
		String[] inLine = new String[3];
		int value = 0;
		
		for(int cnt = 0; cnt < firms; cnt++)
		{
			inLine = input.nextLine().trim().split("\\W+");
			value = Integer.parseInt(inLine[2]);
			if(!firmMap.containsKey(inLine[1]))
			{
				LinkedHashMap<String, Integer> productMap = new LinkedHashMap<>();
				productMap.put(inLine[3], value);
				firmMap.put(inLine[1], productMap);
			}
			else
			{
				LinkedHashMap<String, Integer> productMap = new LinkedHashMap<>();
				productMap = firmMap.get(inLine[1]);
				if(!productMap.containsKey(inLine[3]))
				{
					productMap.put(inLine[3], value);
				}
				else
				{
					int currentVal = value + productMap.get(inLine[3]);
					productMap.put(inLine[3], currentVal);
				}
				firmMap.put(inLine[1]  , productMap);
			}
		}
		
		for(Iterator firmIter = firmMap.entrySet().iterator(); firmIter.hasNext();)
		{
			Map.Entry firmValue = (Map.Entry) firmIter.next();
			String result = firmValue.getKey() + ": ";
			
			LinkedHashMap prodMap = (LinkedHashMap) firmValue.getValue();
				for(Iterator prodIter = prodMap.entrySet().iterator(); prodIter.hasNext();)
				{
					Map.Entry prodValue = (Map.Entry) prodIter.next();
					result += prodValue.getKey() + "-" + prodValue.getValue() + ", ";
				}
				result = result.substring(0, result.length() - 2);
				System.out.println(result);
			}
		}
		
	}