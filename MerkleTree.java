package MainPackage;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Traversal through an array based binary tree
//left child of tree[i] is at index 2*i + 1
//right child of tree[i] is at index 2*i + 2
//perfect binary tree of height h has 2^(h+1)-1 nodes
//perfect binary tree has height h of ceil(log_2(leaf nodes + 1) -1)
//nodes in each level is equal to 2^h


//** File:        MerkleTree.java
//** Project:     CSCE 314 Project 1, Fall 2020
//** Author:      Jacob Smith and Paanery Shah
//** Date:        11/5/20
//** Section:     501
//** E-mail:      burgerman1020@tamu.edu
//** Description: Merkle tree class: This class will make a perfect binary tree of hashed values from the input list

public class MerkleTree<type> {//GENERICS REQUIREMENT
	private ArrayList<String> hashList = new ArrayList<String>();//This list will store the hashed results of the data in an array based binary tree format
	private ArrayList<String> hashListTemp = new ArrayList<String>();
	private int heightTree;
	private int sizeofTree;
	
	@SuppressWarnings("unchecked")//This is used to suppress warnings that arise when cloning ArrayLists
	//constructor: Will take in a data set and construct the corresponding merkle tree
	public MerkleTree(ArrayList<type> dataList) throws NoSuchAlgorithmException {
		heightTree = (int)Math.ceil(Math.log10(dataList.size() + 1) / Math.log10(2) - 1);//get height of tree
		sizeofTree = (int)Math.pow(2, heightTree + 1) - 1;//get size of tree

		//iterate through leaf nodes first
		String hash = null;
		for(int i = 0; i < dataList.size(); i++) {
			hash = hashFunction(dataList.get(i).toString());
			//hash = dataList.get(i); //TEST VALUES
			hashList.add(hash);
		}
		
		//handle case where initial height is 1
		if(heightTree == 1) {
			hash = hashFunction(hashList.get(0) + hashList.get(1));
			hashList.add(0, hash);
		}
		
		//iterate through inner nodes
		heightTree -= 1;
		int heightTreeCONST = heightTree;
		hashListTemp = (ArrayList<String>)hashList.clone();
		for(int i = 0; i < heightTreeCONST; i++) {
			for(int j = 2 * (int)Math.pow(2, heightTree) - 1; j >= 0; j -= 2) {
				hash = hashFunction(hashListTemp.get(j - 1) + hashListTemp.get(j));
				//hash = hashListTemp.get(j - 1) + hashListTemp.get(j);//TEST VALUES
				hashList.add(0, hash);
			}
			hashListTemp = (ArrayList<String>)hashList.clone();
			heightTree -= 1;
			if(Math.pow(2, heightTree) == 1) {//at the root, end the loop
				hash = hashFunction(hashListTemp.get(0) + hashListTemp.get(1));
				//hash = hashListTemp.get(0) + hashListTemp.get(1);//TEST VALUES
				hashList.add(0, hash);
				break;
			}
		}
	}
	
	//This function uses MessageDigest in the Java security library to hash input strings
	public String hashFunction(String data) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(data.getBytes());
		String stringHash = new String(messageDigest.digest());
		return stringHash;
	}
	
	public ArrayList<String> getMerkleTree() {
		return hashList;
	}
	
	public int getSize() {
		return sizeofTree;
	}
}
