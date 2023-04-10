package ru.so.java.task.questionnaire.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.FileExt;

public class CSVGenerator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("Questionnaire_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".csv");

		System.out.println("Введите название теста.");	
		FileExt.writeln(file, br.readLine());
		String answer = null;
		do {
			StringBuilder builder = new StringBuilder();
			System.out.println("Введите вопрос.");		
			builder.append(br.readLine() + '|');
			System.out.println("Введите ответ.");
			System.out.println("Напечатайте 'Next', чтобы перейти к следующему вопросу.");
			System.out.println("Напечатайте 'Стоп', чтобы закончить.");
			do {				
				answer = br.readLine();
				if (!Answers.isNext(answer) && !Answers.isStopped(answer)) {
					builder.append(answer + '|');
				}
			}
			while(!Answers.isNext(answer) && !Answers.isStopped(answer));
			FileExt.writeln(file, builder.toString().substring(0, builder.toString().length() - 1));
		}
		while(!Answers.isStopped(answer));
		System.out.println("Ссылка на тест: ");
		FileExt.writeln(file, br.readLine());
		System.out.println(file.getAbsolutePath());
	}	
}
