package MainPackage;

//** File:        EvaluateFileEquality.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: Evaluator: Will compare the hash values of two merkle trees and determine if there are any differences

public class EvaluateFileEquality<type> {//GENERICS REQUIREMENT
	private boolean isEqual;
	private String message = "";
	
	//constructor: Sets variables mt1 and mt2 and runs the determineEquality function
	public EvaluateFileEquality(MerkleTree<type> mt1, MerkleTree<type> mt2) {
		isEqual = determineEquality(mt1, mt2);
	}
	
	
	//determine whether two merkle trees are equal or not be comparing hashes
	private boolean determineEquality(MerkleTree<type> mt1, MerkleTree<type> mt2) {
		if(mt1.getSize() == mt2.getSize()) {
			if(mt1.getMerkleTree().get(0).equals(mt2.getMerkleTree().get(0))) {
				message = "Both files are the same";
				return true;
			}
			else {
				message = "Files are different";
				return false;
			}
		}
		else {
			if(mt1.getSize() > mt2.getSize()) {
				message = "The first file has more elements than the second; Files are not the same";
			}
			else {
				message = "The second file has more elements than the first; Files are not the same";
			}
			return false;	
		}
	}
	
	//return the result of the isEqual function
	public boolean getEquality() {
		return isEqual;
	}
	
	public String getMessage() {
		return message;
	}
}
