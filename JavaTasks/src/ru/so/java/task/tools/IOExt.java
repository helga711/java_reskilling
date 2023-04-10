package ru.so.java.task.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOExt {
	public void print(String s) {
		System.out.print(s);
	}
	
	public void println(String s) {
		System.out.println(s);
	}
	
	public void println() {
		System.out.println();
	}
	
	public String readln() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
}
