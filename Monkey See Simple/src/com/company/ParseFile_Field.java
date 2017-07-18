package com.company;

/**
 * Created by Michael on 7/17/17.
 */
class ParseFile_Field extends ParseFile {
	
	ParseFile_Field() {
		super();
//		workingString += '\n';
		commitWorkingString();
	}
	
	void shrinkScope() {
	
	}
	
	
	@Override
	void actOnMarker() {
//		workingString += '\n';
		exitCurrentScope = true;
	}
}
