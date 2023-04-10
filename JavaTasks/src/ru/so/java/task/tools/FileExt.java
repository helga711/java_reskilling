package ru.so.java.task.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileExt {	
	public static void write(File file, String str) {
		try (FileWriter fw = new FileWriter(file, true)) {
			fw.append(str);
		}
		catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}	
	}
	
	public static void write(File file, List<String> lines) {
		try (FileWriter fw = new FileWriter(file)) {
			for (var line : lines) {
				fw.append(line + "\r\n");
			}			
		}
		catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}	
	}
	
	public static void writeln(File file, String str) {
		write(file, str + "\r\n");
	}
	
	public static List<String> readln(File file){
		List<String> list = new ArrayList<String>();
		String str;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((str = br.readLine()) != null) {
				list.add(str);
			}
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		return list;
	}
}
