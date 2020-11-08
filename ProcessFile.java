package MainPackage;

//** File:        ProcessFile.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: File processor Main: This acts as an abstract parent class to ProcessFileSub.java

abstract class ProcessFile<T> {
	private String fileContents = null;
	protected T filename = null;
	
	//constructor
	public ProcessFile(T filename) {
		this.filename = filename;
	}
	
	//Will return the fileContnets string
	public String getFileContents() {
		return fileContents;
	}
}
