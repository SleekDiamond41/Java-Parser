package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
	// write your code here
		
		String filename = "src/com/company/ParseFile.java";
		ArrayList<String> fileContents = new ArrayList<>(0);
		ParseFile_File parseFile_file;
		
		try {
			fileContents = new ArrayList<> (Files.readAllLines(Paths.get(filename)));
			parseFile_file = new ParseFile_File(fileContents);
			
			parseFile_file.parseData();
			
			
			//print object stuff
			System.out.println(parseFile_file.getChildren());
		} catch (IOException e) {
			System.out.println("Somebody sucks");
		}
		
		
	}
}
