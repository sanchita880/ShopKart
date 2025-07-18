package mylogic;

import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String[]args) 
	{
		Scanner scr = new Scanner(System.in);
		int A = scr.nextInt();
		
		for ( int i=0; i<=A;i++ ) {
			int n =scr.nextInt();
			
			int count=0;
			for(int div=2; div * div<=n;div++) {
				if(n%div==0) {
					count++;
					break;
					
				}
			}
		
			if(count==0) {
				System.out.println("Prime");
			}
		
	     else 
		{
			System.out.println("Not Prime");
		}
			
			}
	            }

	}