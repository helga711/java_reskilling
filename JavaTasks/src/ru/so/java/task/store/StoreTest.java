package ru.so.java.task.store;

import java.io.IOException;

import ru.so.java.task.tools.Answers;
import ru.so.java.task.tools.IOExt;

public class StoreTest {	
	public static void main(String[] args) throws IOException {		
		IOExt io = new IOExt();
		io.println("Выберите роль: 1. Администратор. 2. Покупатель.");
		
		switch(Answers.getIntAnswerInRange(1, 2)) {
		  case "1":
			  do {
				io.println("Выберите действие: 1. Добавить товар. 2. Посмотреть цену. 3. Удалить товар.");
				io.println("Напечатайте 'Стоп', чтобы закончить.");
				switch(Answers.getIntAnswerInRange(1, 3)) {
				  case "1":
					  Store.addItem();
				    break;
				  case "2":
					  Store.viewPrice();
				    break;
				  case "3":
					  Store.deleteItem();
				    break;
				  default:	
					  return;
				}
			  }
			  while(true);
		  case "2":
			  Store.viewPrice();
		    break;
		  default:
			  return;
		}
	}
}
