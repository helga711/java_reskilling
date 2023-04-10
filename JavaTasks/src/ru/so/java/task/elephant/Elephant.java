package ru.so.java.task.elephant;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.FileExt;
import ru.so.java.task.tools.IOExt;

public class Elephant {
	public static void main(String[] args) throws IOException {		
		File file = new File(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".txt");
		IOExt io = new IOExt();
		Answers answers = new Answers();		
		io.println("Напечатайте 'Стоп', чтобы закончить.");
		io.println("Купи слона.");
		FileExt.writeln(file, "Купи слона.");
		String answer = io.readln();
		FileExt.writeln(file, answer);
		while(!Answers.isStopped(answer)) {
			if (answers.contains(answer))
			{
				io.println("Что, аргументы кончились? Купи слона!");
				FileExt.writeln(file, "Что, аргументы кончились? Купи слона!");
			}
			else
			{
				io.println(String.format("Все говорят %s, а ты купи слона. ", answer));
				FileExt.writeln(file, String.format("Все говорят %s, а ты купи слона. ", answer));
			}
			
			answers.add(answer);
			answer = io.readln();
			FileExt.writeln(file, answer);
		};
		
		io.println("До свидания.");
		FileExt.writeln(file, "До свидания.");
		io.println(file.getAbsolutePath());
	}	
}
