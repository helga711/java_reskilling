package ru.so.java.task.elephant;

import java.io.IOException;

public class Elephant {
	public static void main(String[] args) throws IOException {
		IOExt io = new IOExt();
		io.println("Нажмите 'Enter', чтобы начать. Напечатайте 'Стоп', чтобы закончить.");		
		io.readln();
		io.println("Купи слона.");
		String answer = io.readln();
		while(!io.isStopped(answer))
		{
			if (io.isRepeated(answer))
			{
				io.println("Что, аргументы кончились? Купи слона!");
			}
			else
			{
				io.println(String.format("Все говорят %s, а ты купи слона. ", answer));
			}
			answer = io.readln();
		}
		io.println("До свидания.");
		System.out.println(io.GetLogPath());
	}	
}
