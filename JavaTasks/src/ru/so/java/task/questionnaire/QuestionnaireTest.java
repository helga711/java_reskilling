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
		io.println(questionnaire.name);
		io.print("Введите ваше имя: ");
		String name = io.readln();
		File log = new File(name + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".txt");
		io.println("Напечатайте цифру, соответствующую варианту ответа.");
		for (var qst : questionnaire.questions) {
			io.println(qst.question);
			io.print(qst.answersToString());
			
			String answer = null;
			do {
				answer = io.readln();
				
				if (Answers.isStopped(answer)) {
					return;
				}		
				
				if (!Answers.isInIntRange(answer, 0, qst.answers.size())) {
					io.println("Неверный формат ответа!");
					io.println("Напечатайте цифру, соответствующую варианту ответа.");
					io.println("Напечатайте 'Стоп', чтобы закончить.");
				}					
			}
			while (!Answers.isInIntRange(answer, 0, qst.answers.size()));
			int index = Integer.parseInt(answer);
			FileExt.writeln(log, qst.question);
			FileExt.writeln(log, qst.answers.get(index - 1));			
		}		
		
		io.println("Результат см. здесь:" + questionnaire.link);
		io.println("Лог: " + log.getAbsolutePath());
	}	
}
