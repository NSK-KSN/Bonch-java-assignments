package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void new_laptop(List<Computer> array){
    	Computer laptop = new Laptop();
        array.add(laptop);
    }
    public static void new_desktop(List<Computer> array){
    	Computer desktop = new Desktop();
        array.add(desktop);
    }

    public static void new_obj(List<Computer> array){
        System.out.println("Choose class: 0-desktop, 1-laptop");
        while(true) {
            Scanner input = new Scanner(System.in);
            int k = 2;
            try {
                k = input.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input. Choose class: 0-desktop, 1-laptop");
                continue;
            }
            switch (k) {
                case 0 -> new_desktop(array);
                case 1 -> new_laptop(array);
                default -> {
                    System.out.println("Wrong input. Choose class: 0-desktop, 1-laptop");
                    continue;
                }
            }
            break;
        }
        //for(Computer i:array){out_obj(i);}//Вывод всех obj для проверки
    }

    public static boolean out_array(List<Computer> array){
        if (array.size()!=0){
            System.out.println("Available computers");
            for (int i=0; i<array.size(); i++){
                System.out.println(i + ": " + array.get(i));
            }
            return true;
        }else{
            System.out.println("No computers available");
            return false;
        }
    }
    public static void choose_obj(List<Computer> array){
        boolean m = out_array(array);
        if(!m){
            System.out.println("You need to create object first");
            new_obj(array);
            out_array(array);
        }
        int k = -1;
        System.out.println("Input object number");
        while(true) {
            Scanner input = new Scanner(System.in);
            k = -1;
            try {
                k = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                continue;
            }
            if(0<=k & k<=array.size()){
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
        change_obj(array.get(k));
    }

    private static void change_obj(Computer obj) {
        out_obj(obj);

        System.out.println("Choose the property you want to change, inut their number from 0 to 2. To not change anything input 3");
        while(true) {
            Scanner input = new Scanner(System.in);
            int k = 2;
            try {
                k = input.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input. Choose the property you want to change, inut their number from 0 to 2. To not change anything input 3");
                continue;
            }
            switch (k) {
                case 0:
                    obj.power_on_action();
                    break;
                case 1:
                    System.out.println("What's the price of the computer?");
                    Scanner input2 = new Scanner(System.in);
                    try {
                        obj.price = input2.nextInt();
                    } catch (Exception e) {
                        System.out.println("Wrong input");
                        continue;
                    }
                    break;
                case 2:
                    if(obj.getClass().getSimpleName().equals("Desktop")){
                        while (true){
                            System.out.println("How many years of warrany does it have?");
                            Scanner input3 = new Scanner(System.in);
                            k = -1;
                            try {
                                k = input3.nextInt();
                            } catch (Exception e) {
                                System.out.println("Wrong input");
                                continue;
                            }
                            obj.set(k, "");
                            break;
                        }
                    }else{
                        System.out.println("What is the Operating System of the computer?");
                        obj.set(0, input.next());
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input");
                    continue;
            }
            out_obj(obj);
            System.out.println("To change something else, input 1. Otherwise input any symbol.");
            Scanner input1 = new Scanner(System.in);
            if (input1.next().equals("1")){
                System.out.println("Choose the property you want to change, inut their number. To not change anything input 3");
                out_obj(obj);
            }else{
                break;
            }
        }

    }
    static void out_obj(Computer obj){
        System.out.println(obj.getClass().getSimpleName());
        obj.get_OnOff();
        obj.get_price();
        obj.get_unique();
    }
    
    static void find_cheapest_price(List<Computer> array) {
    	int min = 999999999;
    	Computer cheapest = null;
    	for (Computer i: array) {
    		//System.out.println(i.price);
    			if (i.price < min) {
    			min = i.price;
    			cheapest = i;
    		}
    	}
        System.out.println("Cheapest computer: "+ cheapest + ", with a " + min + " price");
    }

    public static void main(String[] args) {
        List array = new ArrayList<>();
        System.out.println("Welcome to the menu. Here you are able to interact with different objects of the class.");
        while(true) {
            System.out.println("Input the correct option to start.");
            System.out.println("0-Look up existing computers");
            System.out.println("1-Add a computer");
            System.out.println("2-Change the parameters of a computer");
            System.out.println("3-Find the cheapest computer");
            System.out.println("q-Exit the program");
            Scanner input = new Scanner(System.in);
            switch (input.next()) {
                case "0":
                    out_array(array);
                    break;
                case "1":
                    new_obj(array);
                    break;
                case "2":
                    choose_obj(array);
                    break;
                case "3":
                	find_cheapest_price(array);
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Option doesn't exist");
            }
        }
    }
}
