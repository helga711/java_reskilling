package ru.so.java.task.questionnaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

	private String question;
	private List<String> answers;
	
	public String getQuestion() {
		return question;
	}
	
	public int getAnswersCount() {
		return answers.size();
	}
	
	public String getAnswers(int index) {
		return answers.get(index);
	}
	
	public Question(String question) {		
		String[] values = question.split("[|]");
		this.question = values[0];
		this.answers = new ArrayList<String>(Arrays.asList(values));
		this.answers.remove(0);
	}
	
	public String answersToString() {
		StringBuilder toString = new StringBuilder(answers.size());
		for (int i = 0; i < answers.size(); i++) {
			toString.append((i + 1) + ". " + answers.get(i) + "\r\n");
		}
		return toString.toString();
	}
}
