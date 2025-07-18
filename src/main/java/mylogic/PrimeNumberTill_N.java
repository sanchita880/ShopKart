package mylogic;

import java.util.Scanner;

public class PrimeNumberTill_N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scr = new Scanner(System.in);
		int low = scr.nextInt();
		int high = scr.nextInt();

		for(int n= low ; n <= high; n++) {
			 
			int count =0;
			for(int div = 2; div * div <=n; div++) {
				if (n % div ==0 ){
					count++;
					break;
				}
			}
			
			if(count == 0) {
			System.out.println(n);
			}
		}
	}
}
