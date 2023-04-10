package ru.so.java.task.tools;

import java.util.ArrayList;
import java.util.List;

public class Answers {	
	private List<String> answers;
	
	public Answers() {
		answers = new ArrayList<String>();		
	}
	
	public void add(String answer) {
		answers.add(answer);
	}
	
	public boolean contains(String answer){
		return answers.stream().anyMatch(x -> x.toLowerCase().equals(answer.toLowerCase()));
	}
	
	public static boolean isStopped(String answer){
		return answer == null || answer.toLowerCase().equals("стоп") || answer.toLowerCase().equals("stop");
	}
	
	public static boolean isNext(String answer){
		return answer.toLowerCase().equals("next");
	}
	
	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isInIntRange(String s, int min, int max) {
		if (isInt(s)) {
			int number = Integer.parseInt(s);
			return number >= min && number <= max;
		}
		else {
			return false;
		}
	}
}
