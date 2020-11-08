package MainPackage;

//** File:        ProcessFileSub.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: File processor: Will take in an input file as a string and hash it. This is a child class of the abstract class ProcessFile.java

public class ProcessFileSub<T> extends ProcessFile<T> {

	//constructor: Will process file into a single string
	public ProcessFileSub(T filename) {
		super(filename);
		System.out.println(super.filename);
		//object = obj;
	}

}
