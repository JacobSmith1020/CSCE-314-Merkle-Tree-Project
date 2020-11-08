package MainPackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


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

public class Driver implements ActionListener{
	public static ArrayList<String> ar = new ArrayList<String>();
	public static ArrayList<String> ar2 = new ArrayList<String>();
	public static String[] argsArray;
    static JTextField textfield;
    static JTextField textfield2;
    static JTextField textfield3;
    static JFrame frame;
    static String args = "";
    static String args2 = "";
    static String args3 = "";
    static JButton button;
    static JButton button2;
    static JLabel label;
    static JLabel label2;
    static JLabel label3;
    static JScrollPane scroll;
    static JTextArea textArea;
    static JTextArea textArea2;
   
    //Create a Java swing based user interface with buttons that signal various actions
    public static void createUserInterface() {
    	Driver te = new Driver();
    	button = new JButton("Create a Merkle Tree");
    	button.addActionListener(te);
    	button2 = new JButton("Compare");
    	button2.addActionListener(te);
    	
    	label = new JLabel("Specify the path of the file you wish to make a Merkle Tree out of (for multiple files, seperate by comma):");
    	label2 = new JLabel("Spcifiy the path of the file you wish to compare against:");
    	label3 = new JLabel("Spcifiy the path of the file you wish to compare:");
    	
        textfield = new JTextField(80);
        textfield.setPreferredSize(new Dimension(0, 27));
        textfield.setVisible(true);
        textfield2 = new JTextField(43);
        textfield2.setPreferredSize(new Dimension(0, 27));
        textfield2.setVisible(true);
        textfield3 = new JTextField(43);
        textfield3.setPreferredSize(new Dimension(0, 27));
        textfield3.setVisible(true);
        
	    textArea = new JTextArea(20, 147);
	    textArea.setLineWrap(true);
	    textArea.setEditable(false);
	    textArea.setVisible(true);
	    textArea2 = new JTextArea(1, 149);
	    textArea2.setLineWrap(true);
	    textArea2.setEditable(false);
	    textArea2.setVisible(true);
        
    	JPanel panel = new JPanel();
    	panel.add(label);
        panel.add(textfield);
        panel.add(button);
        panel.add(textArea);
        
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);
        
        panel.add(label2);
        panel.add(textfield2);
        panel.add(label3);
        panel.add(textfield3);
        panel.add(button2);
        panel.add(textArea2);
        
        frame = new JFrame("MainSwingFrame");
    	frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Merkle Tree User Interface");
        frame.pack();
        frame.setVisible(true);
    }
    
    //Will run when a button is clicked within the user interface; Responsible for providing output to the user
    //C:/Users/Smith/eclipse-workspace/MerkleTreeProject/text.txt
    public void actionPerformed(ActionEvent e){
	      String s = e.getActionCommand();
	      args = textfield.getText();
	      argsArray = args.split(",");
	      args2 = textfield2.getText();
	      args3 = textfield3.getText();
	      if(s == "Create a Merkle Tree") {
	    	  textArea.setText("");
	    	  ArrayList<ProcessFileSub> pf = new ArrayList<ProcessFileSub>();
			  try {
				  for(int i = 0; i < argsArray.length; i++) {
					  pf.add(new ProcessFileSub(argsArray[i]));
				  }
			  } 
			  catch (FileNotFoundException e1) {
				  ar.clear();
				  pf.clear();
				  e1.printStackTrace();
			  }
			  for(int i = 0; i < pf.size(); i++) {
				  ar.add(pf.get(i).getFileContents());
			  }
		      try {
				  MerkleTree mt = new MerkleTree(ar);
				  System.out.println(mt.getMerkleTree().get(0));System.out.println(mt.getMerkleTree().get(1));System.out.println(mt.getMerkleTree().get(2));
				  textArea.setText(mt.getMerkleTree().toString());
				  ar.clear();
				  pf.clear();
			  } 
		      catch (NoSuchAlgorithmException e1) {
		    	  ar.clear();
				  pf.clear();
				  e1.printStackTrace();
			  }
	      }
	      else if(s == "Compare") {
	    	  textArea2.setText("");
	    	  ProcessFileSub pf = null;
	    	  ProcessFileSub pf2 = null;
			  try {
				  pf = new ProcessFileSub(args2);
				  pf2 = new ProcessFileSub(args3);
			  } 
			  catch (FileNotFoundException e1) {
				  e1.printStackTrace();
			  }
		      ar.add(pf.getFileContents());
		      ar2.add(pf2.getFileContents());
		      try {
				  MerkleTree mt = new MerkleTree(ar);
				  MerkleTree mt2 = new MerkleTree(ar2);
				  EvaluateFileEquality feq = new EvaluateFileEquality(mt, mt2);
				  if(feq.getEquality() == true) {
					  textArea2.setText(feq.getMessage());
				  }
				  else {
					  textArea2.setText(feq.getMessage());
				  }
				  ar.clear();
				  ar2.clear();
			  } 
		      catch (NoSuchAlgorithmException e1) {
				  e1.printStackTrace();
			  }
	    	  
	      }
    }

	public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
		createUserInterface();
	}
}