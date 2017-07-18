package com.company;

/**
 * Created by Michael on 7/17/17.
 */
class ParseFile_Object extends ParseFile {
	
	ParseFile_Object() {
		super();
		commitWorkingString();
	}
	
	
	void shrinkScope() {
		selfData.add(startMethod());
	}
	
	@Override
	void actOnMarker() {
		if(c == '{') {
			if(bracketCount > 0) {
				selfData.add(startMethod());
			} else {
				workingString += c;
				++bracketCount;
			}
		} else if(c == '}') {
			--bracketCount;
			workingString += c;
			if(bracketCount < 1) {
				commitWorkingString();
				exitCurrentScope = true;
			}
		} else if(c == ';') {
			workingString += c;
			selfData.add(startField());
		} else {
			workingString += c;
		}
	}
}
