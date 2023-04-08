package ru.so.java.task.elephant;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class IOExt {	
	private List<String> answers;	
	private File file;
	
	public IOExt() {
		answers = new ArrayList<String>();
		file = new File(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".txt");
	}
	
	public void print(String str) {
		System.out.print(str + " ");
		FileExt.write(file, str + " ");		
	}
	
	public void println(String str) {
		System.out.println(str);
		FileExt.write(file, str + "\r\n");
	}
	
	public void println() {
		System.out.println();
		FileExt.write(file, "\r\n");
	}
	
	public String readln() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = br.readLine();
		FileExt.write(file, answer + "\r\n");		
		return answer;
	}
	
	public boolean isRepeated(String answer){
		boolean res = answers.stream().anyMatch(x -> x.toLowerCase().equals(answer.toLowerCase()));
		answers.add(answer);
		return res;
	}
	
	public boolean isStopped(String answer){
		return answer.toLowerCase().equals("стоп") || answer.toLowerCase().equals("stop");
	}
	
	public String GetLogPath()
	{
		return file.getAbsolutePath();
	}
}
