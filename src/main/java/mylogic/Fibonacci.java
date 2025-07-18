package mylogic;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner src = new Scanner (System.in);
  int n = src.nextInt();
  
  int a = 0;
  int b = 1;  
  for(int i =0; i<=n; i++) {
	  System.out.println(a);
	 int c =a+b; 
	  a=b;
	  b=c;
	  
  }
	  
	}

}
