package com.remoteTiger;

//import CoffeeService.CoffeeServiceLayer;
//import CoffeeModel.Model;
//import CoffeeService.CoffeeServiceLayer;

import java.util.Scanner;

//import org.springframework.context.ApplicationContext;
//import CoffeeServiceInterface.CoffeeServiceInt;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import CoffeeFactroy.coffeeFactoryA;

public class RunSpring {
	
	
	private static Scanner input2;

	public static void main(String[] args) {
		
        System.out.println("enter the table No:");
		input2 = new Scanner(System.in);
		int number=input2.nextInt();
		
		//coffeeFactoryA d=new coffeeFactoryA();
		coffeeFactoryA.getCofe(number);
		
	}

}
