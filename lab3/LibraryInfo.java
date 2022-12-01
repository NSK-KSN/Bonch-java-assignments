package lab3;

import java.io.*;
import java.time.LocalDate;

public class LibraryInfo {

	private static int receiveMonth;
	private static int receiveDay;
	private static int daysForReturn;
	private String surname;
	public String getSurname() {return surname;}
	private String bookTitle;
	public String getBookTitle() {return bookTitle;}
	private LocalDate receiveDate;
	public LocalDate getReceiveDate() {return receiveDate;}
	public int daysToKeep;
	public int getDaysToKeep() {return daysToKeep;}
	private LocalDate returnDate;
	public LocalDate getReturnDate() {return returnDate;}
	
	public LibraryInfo()
	{
		receiveMonth = (int) ((Math.random() * (12 - 1)) + 1);
		receiveDay = (int) ((Math.random() * (28 - 1)) + 1);
		daysForReturn = (int) ((Math.random() * (40 - 5)) + 5);
		surname = ("Surname");
		bookTitle = ("Book title");
		receiveDate = LocalDate.of(2022, receiveMonth, receiveDay);
		int[] daysToKeep = {7, 14, 31};
		this.daysToKeep = daysToKeep[(int)(Math.random() * 3)];
		returnDate = receiveDate.plusDays(daysForReturn);
	}
	
	public LibraryInfo(String _surname, String _bookTitle, LocalDate _receiveDate, int _daysToKeep, LocalDate _returnDate)
	{
		surname = _surname;
		bookTitle = _bookTitle;
		receiveDate = _receiveDate;
		daysToKeep = _daysToKeep;
		returnDate = _returnDate;
	}
	
	public void printInfo()
	{
		System.out.printf("Surname: %s\nBook Title: %s\nReceive date:" + receiveDate + "\nDays to keep: %d\nReturn date: " + returnDate +"\n\n",  surname, bookTitle, daysToKeep);
	}
	
	public static LibraryInfo enterLibraryInfo() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter surname:");
		String surname = reader.readLine();
		System.out.print("Enter book title:");
		String bookTitle = reader.readLine();
		System.out.print("Enter receiveDate:");
		LocalDate receiveDate = enterDate(reader.readLine());
		//System.out.print(receiveDate);
		System.out.print("Enter days to keep:");
		int daysToKeep = enterInteger(reader.readLine());
		System.out.print("Enter return date:");
		LocalDate returnDate = enterDate(reader.readLine());
		return new LibraryInfo(surname, bookTitle, receiveDate, daysToKeep, returnDate);
	}
	
	private static int enterInteger(String value)
	{
		if(!(value.replaceAll("[A-Za-z:\\s,-]", "").equals("")))
			return Integer.parseInt(value.replaceAll("[A-Za-z:\\s,]", ""));
		else 
			return 0;
	}
	
	private static LocalDate enterDate(String value)
	{
		if(!(value.replaceAll("[A-Za-z:\\s,-]", "").equals("")))
			try {
					return LocalDate.parse(value.replaceAll("[A-Za-z:\\s,]", ""));
				}
				catch(Exception e) {
					return LocalDate.now();
				}
		else 
			return LocalDate.now();
	}
}
