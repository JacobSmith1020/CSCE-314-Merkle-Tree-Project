package MainPackage;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

//** File:        Driver.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: Main driver of project 1


//** Application description: This application will take in two files, convert them both into a merkle tree and then compare the hash values of each file or file set to 
//                            determine if they are equal or if differences occur between them. This should make comparing the equality of files faster, compared to the
//                            process of examining each file individually for differences. Through the use of merkle trees, if data exists in multiple places, merkle trees
//                            are more efficient in detecting inconsistencies between files. 

public class Driver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NoSuchAlgorithmException {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("a");ar.add("b");ar.add("c");ar.add("e");ar.add("a");ar.add("b");ar.add("c");ar.add("e");
		MerkleTree mt = new MerkleTree(ar);
		//System.out.println(mt.getMerkleTree().size());
		System.out.println(mt.getMerkleTree());
		int t = 15;
		@SuppressWarnings("rawtypes")
		ProcessFileSub pf = new ProcessFileSub("this is a filename");
		EvaluateFileEquality feq = new EvaluateFileEquality(mt, mt);
	}

}