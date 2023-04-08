package ru.so.java.task.elephant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExt {	
	public static void write(File file, String str) {
		try (FileWriter fw = new FileWriter(file, true)) {
			fw.append(str);
		}
		catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}
}
