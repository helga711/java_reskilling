package ru.so.java.task.questionnaire;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.FileExt;
import ru.so.java.task.tools.IOExt;

public class QuestionnaireTest {
	public static void main(String[] args) throws Exception {
		Questionnaire questionnaire = new Questionnaire(FileExt.readln(new File(args[0])));
		IOExt io = new IOExt();		
		io.println(questionnaire.getName());
		io.print("Введите ваше имя: ");
		String name = io.readln();
		File log = new File(name + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".txt");
		io.println("Напечатайте номер варианта ответа.");
		for (var qst : questionnaire.getQuestions()) {
			io.println(qst.getQuestion());
			io.print(qst.answersToString());			
			String answer = Answers.getIntAnswerInRange(1, qst.getAnswersCount());
			
			if (Answers.isStopped(answer)) {
				return;
			}
			
			int index = Integer.parseInt(answer);
			FileExt.writeln(log, qst.getQuestion());
			FileExt.writeln(log, qst.getAnswers(index - 1));			
		}		
		
		io.println("Результат см. здесь:" + questionnaire.getLink());
		io.println("Лог: " + log.getAbsolutePath());
	}	
}
