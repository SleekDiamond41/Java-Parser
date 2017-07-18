package com.company;

import java.util.ArrayList;

/**
 * Created by Michael on 7/17/17.
 */
abstract class ParseFile {
	static int lineCount;
	static int charCount;
	static int bracketCount;
	static String currentLine;
	static String workingString;
	static char c;
	static boolean exitCurrentScope;
	
	static ArrayList<String> dataLines;
	
	
	/* UNIQUE FIELDS */
	ArrayList<Object> selfData;
	
	
	
	/* METHODS */
	
	ParseFile(ArrayList<String> newLines) {
		exitCurrentScope = false;
		lineCount = 0;
		charCount = 0;
		bracketCount = 0;
		currentLine = "";
		workingString = "";
		dataLines = new ArrayList<>(0);
		selfData = new ArrayList<>(0);
		
		dataLines = newLines;
	}
	
	
	ParseFile() {
		selfData = new ArrayList<>(0);
	}
	
	
	void parseData() {
		while(lineCount < dataLines.size()) {
			currentLine = dataLines.get(lineCount);
			while (charCount < currentLine.length()) {
				
				c = dataLines.get(lineCount).charAt(charCount);
				actOnMarker();
				
				if(exitCurrentScope) {
					exitCurrentScope = false;
					return;
				}
				
				++charCount;
			}
			
			charCount = 0;
			++lineCount;
			
			workingString += '\n';
			commitWorkingString();
		}
	}
	
	abstract void actOnMarker();
	
	abstract void shrinkScope();
	
	void commitWorkingString() {
		if(workingString == null) {
			workingString = "";
			return;
		} else if(workingString.equals("")) {
			return;
		}
		selfData.add(workingString);
		workingString = "";
	}
	
	ParseFile startFile() {
		ParseFile_File pff = new ParseFile_File();
		pff.parseData();
		return pff;
	}
	
	ParseFile startObject() {
		ParseFile_Object pfo = new ParseFile_Object();
		pfo.parseData();
		return pfo;
	}
	
	ParseFile startMethod() {
		ParseFile_Method pfm = new ParseFile_Method();
		pfm.parseData();
		return pfm;
	}
	
	ParseFile startField() {
		ParseFile_Field pff = new ParseFile_Field();
		pff.parseData();
		return pff;
	}
	
	String getChildren() {
		String temp = "";
		
		for (Object selfDatum : selfData) {
			if(selfDatum.getClass() == String.class) {
				temp += selfDatum;
			} else {
				temp += ((ParseFile) selfDatum).getChildren();
			}
		}
		
		return temp;
	}
}

