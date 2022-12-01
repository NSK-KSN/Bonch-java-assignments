package lab3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Task1 {
	
	public static void main (String[] args)throws FileNotFoundException {
		
		String fname1 = "f1.txt";
		String fname2 = "f2.txt";
		
		doubledUnevenNumberAmount(fname1, fname2);
	}
  
	public static void doubledUnevenNumberAmount(String fname1, String fname2)throws FileNotFoundException {
		Scanner reader = new Scanner(new File(fname1));
		int count=0;   

		while (reader.hasNextInt())  { 
			int doubledUnevenNumber = reader.nextInt();
	    	int numberMod = (doubledUnevenNumber/2) % 2;
	    	if (numberMod != 0) {
	    		System.out.print(doubledUnevenNumber + " \n");
	    		count++;
	    		}     
	    	}
		System.out.println("The file had " + count + " doubled uneven number(s)");
		
		try (FileWriter fw = new FileWriter(fname2);) {
			fw.write("The file had " + count + " doubled uneven number(s)");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}