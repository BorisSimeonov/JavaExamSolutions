package judge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_SchoolSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TreeMap<String, TreeMap<String, List<Double>>> nameMap = new TreeMap<>();
		int namesCount = Integer.parseInt(input.nextLine());
		String[] inLine;
		String name, subject;
		Double grade;
		
		for(int cnt = 0; cnt < namesCount; cnt++){
			inLine = input.nextLine().trim().split(" ");
			name = inLine[0] + " " + inLine[1];
			subject = inLine[2];
			grade = Double.parseDouble(inLine[3]);
			if(!nameMap.containsKey(name)){
				TreeMap<String, List<Double>> subjectMap = new TreeMap<>();
				ArrayList<Double> gradeList = new ArrayList<>();
				gradeList.add(grade);
				subjectMap.put(subject, gradeList);
				nameMap.put(name, subjectMap);
			}else{
				TreeMap<String, List<Double>> subjectMap = nameMap.get(name);
				if(!subjectMap.containsKey(subject))
				{
					ArrayList<Double> gradeList = new ArrayList<>();
					gradeList.add(grade);
					subjectMap.put(subject, gradeList);
				}else{
					ArrayList<Double> gradeList = (ArrayList<Double>) subjectMap.get(subject);
					gradeList.add(grade);
					subjectMap.put(subject, gradeList);
				}
				nameMap.put(name, subjectMap);
			}
		}
		
		
		for(Iterator nameIterator = nameMap.entrySet().iterator(); nameIterator.hasNext();)
		{
			Map.Entry namesMap = (Map.Entry) nameIterator.next();
			String result = namesMap.getKey() + ": [";
			
			TreeMap prodMap = (TreeMap) namesMap.getValue();
			for(Iterator sujIterator = prodMap.entrySet().iterator(); sujIterator.hasNext();){
				Map.Entry sjtMap = (Map.Entry) sujIterator.next();
				double average = 0;
				ArrayList<Double> gradeList = (ArrayList<Double>) sjtMap.getValue();
				for(int cnt = 0; cnt < gradeList.size(); cnt++)
				{
					average += gradeList.get(cnt);
				}
				average /= gradeList.size();
				result +=  String.format("%s - %.02f, ", sjtMap.getKey(), average);
			}
			result = result.substring(0, result.length() - 2) + "]";
			System.out.println(result);
		}
	}

}
