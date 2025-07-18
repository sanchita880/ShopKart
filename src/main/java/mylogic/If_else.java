package mylogic;

import java.util.Scanner;

public class If_else {

	public static void main(String[]args) 

	{
		Scanner scn = new Scanner(System.in);
		int marks = scn.nextInt();
		//int a = 90;
		//int b = 60;
		
		if(marks>90){
		System.out.println("Excellent");
	}
		else if(marks>80)
		{
		System.out.println("good");
	}
		else if(marks>70)
		{
		System.out.println("meets expectation");
	}
		else if(marks>60)
		{
		System.out.println("below part");
	}
		else 
		{
			System.out.println("student should have atleast 60 marks");
		}

 }
	
}