package lab3;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task2 
{
	public static boolean generateFile(File file, int n) throws IOException
	{
		if(file.exists())
		{
			FileOutputStream writer = new FileOutputStream(file);
			for (int i = 0;i < n;i++)
			{
				LibraryInfo lInf = new LibraryInfo();
				String info = String.format(  "=============================\nSurname: %s\n"
											+ "Book Title: %s\n"
											+ "Receive date: " + lInf.getReceiveDate() + "\n"
											+ "Days to keep: %d\n"
											+ "Return date: " + lInf.getReturnDate() + "\n=============================\n", lInf.getSurname(), lInf.getBookTitle(), lInf.getDaysToKeep());
				byte[] data = info.getBytes();
				writer.write(data);
			}
			writer.close();
			return true;
		}
		else
		{
			System.out.println("There is no file!");
			return false;
		}
	}
	
	public static boolean enterFile(File file, int n) throws IOException
	{
		if(file.exists())
		{
			FileOutputStream writer = new FileOutputStream(file);
			for (int i = 0;i < n;i++)
			{
				LibraryInfo lInf = LibraryInfo.enterLibraryInfo();
				String info = String.format(  "=============================\nSurname: %s\n"
											+ "Book Title: %s\n"
											+ "Receive date: " + lInf.getReceiveDate() + "\n"
											+ "Days to keep: %d\n"
											+ "Return date: " + lInf.getReturnDate() + "\n=============================\n", lInf.getSurname(), lInf.getBookTitle(), lInf.getDaysToKeep());
				byte[] data = info.getBytes();
				writer.write(data);
			}
			writer.close();
			return true;
		}
		else
		{
			System.out.println("There is no file!");
			return false;
		}
	}
	
	public static String[] fileToStrings(File file) throws IOException
	{
		String[] str = null;
		if(file.exists())
		{
			FileInputStream reader = new FileInputStream(file);
			int i;
			String buf = "";
			while((i=reader.read()) != -1)
			{
				buf += (char)i;
			}
			reader.close();
			str = buf.split("\n");
			return str;
		}
		else
		{
			System.out.println("There is no file!");
			return str;
		}
	}
	
	public static void printFile(File file) throws IOException
	{
		System.out.println("File " + file.getName() + ":");
		for(String word : fileToStrings(file))
		{
			System.out.print(word + "\n");
		}
	}
	
	public static void doTask(File file) throws IOException, ParseException
	{
		System.out.println("---------------Task------------");
		String[] str = fileToStrings(file);
		LibraryInfo libraryInfo = null;
		LocalDate receiveDate = null;
		LocalDate returnDate = null;
		LocalDate overDue = null;
		long daydiff = 0;
		long daysToKeep = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		for(String word : str)
		{
			if(word.contains("Receive date"))
			{
				receiveDate = LocalDate.parse(word.replaceAll("[A-Za-z:\\s]", ""), formatter);
			}
			
			if(word.contains("Days"))
			{
				daysToKeep = Long.parseLong(word.replaceAll("[A-Za-z:\\s]", ""));
				System.out.print("=============================\nMust return in " + daysToKeep + " days\n");
			}
			
			if(word.contains("Return date"))
			{
				returnDate = LocalDate.parse(word.replaceAll("[A-Za-z:\\s]", ""), formatter);
				
				daydiff = returnDate.toEpochDay() - receiveDate.toEpochDay();
				System.out.print("Was returned in " + daydiff + " days\n=============================\n");
				
				if (daydiff > daysToKeep) {
					overDue = returnDate;
					for(int i = 0;i < str.length; i++) {
						if(str[i].contains(overDue.format(formatter))) {
							libraryInfo = new LibraryInfo(str[i-4].substring(9), str[i-3].substring(12), receiveDate, Integer.parseInt(str[i-1].substring(14)), returnDate);
						}
					}
				}
				if (libraryInfo != null )
				{
					libraryInfo.printInfo();
					libraryInfo = null;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, ParseException 
	{
		File f = new File("D:\\Users\\Desktop\\предметы\\3 курс\\джава\\lab3\\libraryInfo.bin");
		
		System.out.println("==============Menu==============");
		while(true) {
			System.out.println("Choose an option");
            System.out.println("1-Read file");
            System.out.println("2-Generate data");
            System.out.println("3-Input data");
            System.out.println("4-Find overdue entries");
            System.out.println("q-Exit program");
			Scanner input = new Scanner(System.in);
			switch (input.next()) {
				case "1":
					printFile(f);
                	break;
            	case "2":
            		generateFile(f, 6);
                	break;
            	case "3":
            		enterFile(f,3);
            	case "4":
            		doTask(f);
                	break;
			 	case "q":
                 	return;
				default:
					System.out.println("Invalid input");
			}
		}
	}
}