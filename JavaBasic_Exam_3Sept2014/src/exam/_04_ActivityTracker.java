package exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_ActivityTracker {

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Map<Integer, TreeMap<String, Integer>> monthMap = new TreeMap<>();
		String[] values = new String[3];
		Scanner input = new Scanner(System.in);
		int logCount = Integer.parseInt(input.nextLine());
		int currentMonth = 0;
		//
		for(int cnt = 0; cnt < logCount; cnt++)
		{
			values = input.nextLine().split(" ");
			try {
				cal.setTime(formatter.parse(values[0]));
			} catch (ParseException e) {
			}
			currentMonth = cal.get(Calendar.MONTH) + 1;
			if(!monthMap.containsKey(currentMonth)){
				TreeMap<String, Integer> logs = new TreeMap<>();
				logs.put(values[1], Integer.parseInt(values[2]));
				monthMap.put(currentMonth, logs);
			}
			else{
				TreeMap<String, Integer> logs = monthMap.get(currentMonth);
				if(!logs.containsKey(values[1])){
					logs.put(values[1], Integer.parseInt(values[2]));
				}
				else{
					logs.put(values[1], logs.get(values[1]) + Integer.parseInt(values[2]));
					monthMap.put(currentMonth, logs);
				}
			}
		}
		
		for(Iterator iterations = monthMap.entrySet().iterator(); iterations.hasNext();)
		{
			Map.Entry monthValue = (Map.Entry) iterations.next();
			String result = monthValue.getKey() + ": ";
			
			TreeMap logs = (TreeMap) monthValue.getValue();
				for(Iterator iterLogs = logs.entrySet().iterator(); iterLogs.hasNext();)
				{
					Map.Entry logValue = (Map.Entry) iterLogs.next();
					result += logValue.getKey() + "(" + logValue.getValue() + "), ";
				}
				result = result.substring(0, result.length() - 2);
				System.out.println(result);
			}
		}
	}