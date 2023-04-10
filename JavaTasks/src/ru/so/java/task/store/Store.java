package ru.so.java.task.store;

import java.io.File;
import java.io.IOException;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.FileExt;
import ru.so.java.task.tools.IOExt;

public class Store {
	
	private static File file = new File("Items.csv");

	public static void viewPrice() throws IOException {
		Items items = new Items(FileExt.readln(file));
		IOExt io = new IOExt();
		while(true) {
			io.println(items.namesToString());
			io.println("Чтобы посмотреть цену, напечатайте номер товара.");
			String answer = Answers.getIntAnswerInRange(1, items.getSize());
			
			if (Answers.isStopped(answer)) {
				return;
			}
			
			int index = Integer.parseInt(answer);
			io.println("Цена: " + items.getItemPrice(index - 1));
			io.println("Нажмите любую клавишу или напечатайте 'Стоп', чтобы закончить.");
			
			if (Answers.isStopped(io.readln())) {
				return;
			}
		}
	}

	public static void addItem() throws IOException {
		IOExt io = new IOExt();
		while(true)
		{
			io.println("Введите название товара.");	
			String name = io.readln();
			
			if(Answers.isStopped(name)) {
				return;
			}

			io.println("Введите цену товара.");
			String price = Answers.getDouble();
			
			if (Answers.isStopped(price)) {
				return;
			}
		
			FileExt.writeln(file, new Item(name, Double.parseDouble(price)).toString());
		}
	}
	
	public static void deleteItem() throws IOException {
		Items items = new Items(FileExt.readln(file));
		IOExt io = new IOExt();
		while(true) {
			io.println(items.namesToString());
			io.println("Введите номер товара, который требуется удалить.");
			String answer = Answers.getIntAnswerInRange(1, items.getSize());
			
			if (Answers.isStopped(answer)) {
				break;
			}
			
			int index = Integer.parseInt(answer);
			items.remove(index - 1);
		}		
		
		FileExt.write(file, items.getItemsAsString());
	}
}
