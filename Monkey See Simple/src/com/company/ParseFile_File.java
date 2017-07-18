package com.company;

import java.util.ArrayList;

/**
 * Created by Michael on 7/17/17.
 */
class ParseFile_File extends ParseFile {
	
	ParseFile_File() {
		super();
	}
	
	ParseFile_File(ArrayList<String> fileContents) {
		super(fileContents);
	}
	
	void shrinkScope() {
		selfData.add(startObject());
	}
	
	@Override
	void actOnMarker() {
		if (c == '{') {
			selfData.add(startObject());
		} else if (c == '}') {
			--bracketCount;
			
			//if at end of object definition,
			if (bracketCount < 0) {
				/*workingString += c;
				commitWorkingString();
				++charCount;
				return;*/
				int a = 10;
				++a;
				return;
			}
		} else if (c == ';') {
			workingString += c;
			selfData.add(startField());
		} else {
			workingString += c;
		}
	}
}
