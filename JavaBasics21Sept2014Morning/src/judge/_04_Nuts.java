package judge;


//TreeMap stores the items sorted, while the LinkedHashMap holds the keys in the import order.
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Nuts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int inCount = Integer.parseInt(input.nextLine());
		TreeMap<String, LinkedHashMap<String, Integer>> companyMap = new TreeMap<>();
		String[] inLine = new String[3];
		
		for(int iter = 0; iter < inCount; iter++)
		{
			inLine = input.nextLine().split(" ");
			inLine[2] = inLine[2].substring(0, inLine[2].length() - 2);
			//check if the map contains that company name
			if(!companyMap.containsKey(inLine[0]))
			{
				LinkedHashMap<String, Integer> nutMap = new LinkedHashMap<>();
				nutMap.put(inLine[1], Integer.parseInt(inLine[2]));
				companyMap.put(inLine[0], nutMap);
			}
			else
			{
				LinkedHashMap<String, Integer>nutMap = companyMap.get(inLine[0]);
				if(!nutMap.containsKey(inLine[1]))
				{
					nutMap.put(inLine[1], Integer.parseInt(inLine[2]));
				}
				else
				{
					int value = nutMap.get(inLine[1]) + Integer.parseInt(inLine[2]);
					nutMap.put(inLine[1], value);
				}
				companyMap.put(inLine[0], nutMap);
			}
		}
		
		for(Iterator iterLogs = companyMap.entrySet().iterator(); iterLogs.hasNext();)
		{
			Map.Entry companyValue = (Map.Entry) iterLogs.next();
			String result = companyValue.getKey() + ": ";	
			
			LinkedHashMap<String, Integer> nutMap = (LinkedHashMap<String, Integer>) companyValue.getValue();
			
			for(Iterator nutIterator = nutMap.entrySet().iterator(); nutIterator.hasNext();)
			{
				Map.Entry nutValue = (Map.Entry) nutIterator.next();
				result += nutValue.getKey() + "-" + nutValue.getValue() + "kg, ";
			}
			result = result.substring(0, result.length() - 2);
			
			System.out.println(result);
		}
	}

}
