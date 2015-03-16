package judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_LogsAggregator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		TreeMap<String, TreeMap<String, Integer>> namesMap = new TreeMap<>();
		String[] inLine = new String[3];
		ArrayList<String> names = new ArrayList<>();
		
		for(int cnt = 0; cnt < count; cnt++)
		{
			inLine = input.nextLine().split(" ");
			if(!namesMap.containsKey(inLine[1]))
			{
				TreeMap<String, Integer> ipCount = new TreeMap<>();
				ipCount.put(inLine[0], Integer.parseInt(inLine[2]));
				namesMap.put(inLine[1], ipCount);
				names.add(inLine[1]);
			}
			else
			{
				TreeMap<String, Integer> ipCount = new TreeMap<>();
				ipCount = namesMap.get(inLine[1]);
				if(!ipCount.containsKey(inLine[0]))
				{
					ipCount.put(inLine[0], Integer.parseInt(inLine[2]));
				}
				else
				{
					int value = ipCount.get(inLine[0]) + Integer.parseInt(inLine[2]);
					ipCount.replace(inLine[0], value);
				}
				namesMap.put(inLine[1], ipCount);
			}
		}
		
		String[] namesArray = new String[names.size()];
		namesArray = names.toArray(namesArray);
		Arrays.sort(namesArray);
		
		
		for(int cnt = 0; cnt < namesArray.length; cnt++)
		{
			Map<String, Integer> ipCount = new TreeMap<>();
			ipCount = namesMap.get(namesArray[cnt]);
			System.out.printf("%s: ", namesArray[cnt]);
			String result = "";
			int sum = 0;
			
			for(Iterator iterLogs = ipCount.entrySet().iterator(); iterLogs.hasNext();)
			{
				Map.Entry logValue = (Map.Entry) iterLogs.next();
				result += logValue.getKey() + ", ";
				sum += (int) logValue.getValue();
			}
			result = result.substring(0, result.length() - 2);
			System.out.printf("%d [%s]\n", sum, result);
		}
		
		
	}

}
