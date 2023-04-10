package ru.so.java.task.questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Questionnaire {

	String name;
	List<Question> questions;
	String link;
	
	public Questionnaire(List<String> questionnaire) throws Exception {		
		if (questionnaire.size() < 3) {
			throw new Exception("Неверный формат опросника. Ожидаемый формат: "
					+ "Название\r\nВопрос\r\nСсылка на ответы");
		}
		this.name = questionnaire.get(0);
		this.link = questionnaire.get(questionnaire.size() - 1);
		List<String> questions = new ArrayList<String>(questionnaire);
		questions.remove(0);
		questions.remove(questions.size() - 1);
		this.questions = questions.stream().map(x -> new Question(x)).collect(Collectors.toList());
	}
}
