package ru.so.java.task.questionnaire.generator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.FileExt;
import ru.so.java.task.tools.IOExt;

public class CSVGenerator {
	public static void main(String[] args) throws IOException {
		IOExt io = new IOExt();
		File file = new File("Questionnaire_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".csv");

		io.println("Введите название теста.");	
		FileExt.writeln(file, io.readln());
		String answer = null;
		do {
			StringBuilder builder = new StringBuilder();
			io.println("Введите вопрос.");		
			builder.append(io.readln() + '|');
			io.println("Введите ответ.");
			io.println("Напечатайте 'Next', чтобы перейти к следующему вопросу.");
			io.println("Напечатайте 'Стоп', чтобы закончить.");
			do {				
				answer = io.readln();
				if (!Answers.isNext(answer) && !Answers.isStopped(answer)) {
					builder.append(answer + '|');
				}
			}
			while(!Answers.isNext(answer) && !Answers.isStopped(answer));
			FileExt.writeln(file, builder.toString().substring(0, builder.toString().length() - 1));
		}
		while(!Answers.isStopped(answer));
		io.println("Ссылка на тест: ");
		FileExt.writeln(file, io.readln());
		io.println(file.getAbsolutePath());
	}	
}
