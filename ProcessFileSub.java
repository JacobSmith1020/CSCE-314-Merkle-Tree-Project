package MainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//** File:        ProcessFileSub.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: File processor: Will take in an input file as a string and hash it. This is a child class of the abstract class ProcessFile.java. This class is specifically
//                                designed to process file input for a merkle tree, hence why it is an inherited class

public class ProcessFileSub extends ProcessFile {//INHERITANCE REQUIREMENT

	//constructor: Will process file into a single string
	public ProcessFileSub(String filepath) throws FileNotFoundException {
		super(filepath);
		scanFile(this.filepath);
	}
	
	private void scanFile(String filepath) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filepath));
		while(sc.hasNext()) {
			fileContents += sc.next();
			fileContents += " ";
		}
	}
}
