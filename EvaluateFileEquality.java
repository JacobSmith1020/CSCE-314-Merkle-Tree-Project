package MainPackage;

//** File:        EvaluateFileEquality.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: Evaluator: Will compare the hash values of two merkle trees and determine if there are any differences

public class EvaluateFileEquality {
	private boolean isEqual = false;
	private MerkleTree mt1 = null;
	private MerkleTree mt2 = null;
	
	//constructor: Sets variables mt1 and mt2 and runs the determineEquality function
	public EvaluateFileEquality(MerkleTree mt1, MerkleTree mt2) {
		this.mt1 = mt1;
		this.mt2 = mt2;
		isEqual = determineEquality(mt1, mt2);
	}
	
	//determine whether two merkle trees are equal or not be comparing hashes
	private boolean determineEquality(MerkleTree mt1, MerkleTree mt2) {
		return false;
	}
	
	//return the result of the isEqual function
	public boolean getEquality() {
		return isEqual;
	}
}
