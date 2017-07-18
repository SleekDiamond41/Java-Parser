package com.company;

/**
 * Created by Michael on 7/17/17.
 */
class ParseFile_Method extends ParseFile {
	
	ParseFile_Method() {
		super();
		commitWorkingString();
//		workingString += c;
//		++charCount;
	}
	
	void shrinkScope() {
	
	}
	
	@Override
	void actOnMarker() {
		if(c == '{') {
			++bracketCount;
			workingString += c;
		} else if(c == '}') {
			--bracketCount;
			workingString += c;
			
			if(bracketCount < 2) {
				commitWorkingString();
				exitCurrentScope = true;
			}
		} else {
			workingString += c;
		}
	
	}
}
