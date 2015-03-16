package judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03_ExamSore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int counter = 0;
		ArrayList<String> buffer;
		ArrayList<Integer> scores = new ArrayList<>();
		TreeMap<Integer, TreeMap<String, Double>> studentsMap = new TreeMap<>();
		double score;
		String name;
		int scoreInt;
		int[] scoreArray;
		
		while(input.hasNext())
		{
			counter++;
			String inLine = input.nextLine().replaceAll("[^0-9. a-zA-Z ]", "").replaceAll("   ", " ").trim();
			if(counter <= 3)
			{
				continue;
			}
			
			if(inLine.isEmpty())
			{
				break;
			}
			
			buffer = new ArrayList<>();
			String[] strArray = inLine.split(" ");
			for(int cnt = 0; cnt < strArray.length; cnt++)
			{
				if(!strArray[cnt].isEmpty())
				{
					buffer.add(strArray[cnt]);
				}
			}
			//
			scoreInt = Integer.parseInt(buffer.get(2));
			name = buffer.get(0) + " " + buffer.get(1);
			score = Double.parseDouble(buffer.get(3));
			if(!studentsMap.containsKey(scoreInt))
			{
				TreeMap<String, Double> nameGrade = new TreeMap<>();
				nameGrade.put(name, score);
				studentsMap.put(scoreInt, nameGrade);
				scores.add(scoreInt);
			}
			else
			{
				TreeMap<String, Double> nameGrade = new TreeMap<>();
				nameGrade = studentsMap.get(scoreInt);
				nameGrade.put(name, score);
				studentsMap.put(scoreInt, nameGrade);
			}
		}
		//sort the scores in ascending order
		scoreArray = new int[scores.size()];
		for(int cnt = 0; cnt < scores.size(); cnt++)
		{
			scoreArray[cnt] = scores.get(cnt);
		}
		Arrays.sort(scoreArray);
		//Display the result
		for(int index = 0; index < scoreArray.length; index++)
		{
			TreeMap<String, Double> nameGrade = new TreeMap<>();
			String result = "" + scoreArray[index] + " -> [";
			nameGrade = studentsMap.get(scoreArray[index]);
			double average = 0d;
			int count = 0;
			
			for(Iterator iter = nameGrade.entrySet().iterator(); iter.hasNext();)
			{
				Map.Entry logValue = (Map.Entry) iter.next();
				result += logValue.getKey() + ", ";
				average += (double)logValue.getValue();
				count++;
			}
			result = result.substring(0, result.length() - 2);
			String dblFormat = String.format("%.2f", (average/count));
			result += "]; avg=" + dblFormat;
			System.out.println(result);
			
		}
	}

}
