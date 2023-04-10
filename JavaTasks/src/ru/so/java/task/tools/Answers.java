package ru.so.java.task.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Condition <s, min, max>{
    Boolean apply(String s, int min, int max);
}

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
	
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
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
	
	public static String getIntAnswerInRange(int min, int max) throws IOException {
		IOExt io = new IOExt();
		String answer = null;
		do {
			answer = io.readln();	
			
			if (!isStopped(answer) && !isInIntRange(answer, min, max)) {
				io.println("Неверный формат ответа!");
				io.println(String.format("Напечатайте целое число от %s до %s включительно.", min, max));
				io.println("Напечатайте 'Стоп', чтобы закончить.");
			}					
		}
		while (!isStopped(answer) && !isInIntRange(answer, min, max));
		return answer;	
	}
	
	public static String getDouble() throws IOException {
		IOExt io = new IOExt();
		String answer = null;
		do {
			answer = io.readln();	
			
			if (!isStopped(answer) && !isDouble(answer)) {
				io.println("Неверный формат ответа!");
				io.println("Напечатайте число в формате." + 1234.5);
				io.println("Напечатайте 'Стоп', чтобы закончить.");
			}					
		}
		while (!isStopped(answer) && !isDouble(answer));
		return answer;	
	}
}