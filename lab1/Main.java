package lab1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("--------------------ARRAYS---------------------------");
       
        //First Array
        System.out.println("Enter elements for array 1:");
        int[] taskOneFirstArray = new int[6];
        getArrayFromKeyboard(scanner, taskOneFirstArray);
        System.out.println("Initial array 1:");
        printArray(taskOneFirstArray);
        substractElementIndex(taskOneFirstArray);
        System.out.println("Processed array 1:");
        printArray(taskOneFirstArray);
        findMaxElement(taskOneFirstArray);
        
        //Second Array
        System.out.println("Enter elements for array 2:");
        int[] taskOneSecondArray = new int[7]; 
        getArrayFromKeyboard(scanner, taskOneSecondArray);
        System.out.println("Initial array 2:");
        printArray(taskOneSecondArray);
        substractElementIndex(taskOneSecondArray);
        System.out.println("Processed array 2:");
        printArray(taskOneSecondArray);
        findMaxElement(taskOneSecondArray);
        
        System.out.println("--------------------DYNAMIC ARRAYS---------------------------");
        
        //Array List
        System.out.println("Enter elements for array list:");
        ArrayList<Integer> arrayList = new ArrayList<>(); 
        getArrayFromKeyboard(scanner, 6, arrayList);
        System.out.println("Initial array list:");
        printArray(arrayList);
        substractElementIndex(arrayList);
        System.out.println("Processed array list:");
        printArray(arrayList);
        findMaxElement(arrayList);
        
        //Linked List
        System.out.println("Enter elements for linked list:");
        LinkedList<Integer> linkedList = new LinkedList<>(); 
        getArrayFromKeyboard(scanner, 7,linkedList);
        System.out.println("Initial linked list:");
        printArray(linkedList);
        substractElementIndex(linkedList);
        System.out.println("Processed array list:");
        printArray(linkedList);
        findMaxElement(linkedList);
	}
	
	public static void getArrayFromKeyboard(Scanner scan, int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            try {
            	data[i]=scan.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                i--;
                scan.nextLine();
            }
        }
    }
	
	public static void getArrayFromKeyboard(Scanner scan, int length, List<Integer> data)
    {
        for (int i = 0; i < length; i++) {
            try {
                data.add(scan.nextInt());
            } catch (Exception e) {
                System.out.println("Incorrect input");
                i--;
                scan.nextLine();
            }
        }
    }

	public static void printArray(int[] array)
	{
        String s = Arrays.toString(array);
        System.out.println(s);
    }
	
	public static void printArray(List<Integer> data)
	{
		String s = data.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(s);
    }
	
	public static void substractElementIndex(int[] data)
	{
		for (int i = 0; i < data.length; i++)
		{
			data[i]=data[i]-i;
		}
	}
	
	public static void substractElementIndex(List<Integer> data)
	{
		for (int i = 0; i < data.size(); i++)
		{
			data.set(i, data.get(i)-i);
		}
	}

	public static void findMaxElement(int[] data)
	{
		int max = data[0];
		
		for (int i = 0; i < data.length; i++)
            if (data[i] > max)
                max = data[i];
         
		System.out.println("Largest in given array is " + max);
	}
	
	public static void findMaxElement(List<Integer> data)
	{
		int max = data.get(0);
		
		for (int i = 0; i < data.size(); i++)
            if (data.get(i) > max)
                max = data.get(i);
         
		System.out.println("Largest in given array is " + max);
	}

}
