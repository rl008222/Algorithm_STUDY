package com.ssafy.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursionProcess {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\leekijong\\eclipse-workspace\\3_HWProject\\src\\com\\ssafy\\hw02\\input.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n= sc.nextInt();
			int sum=0;
			for(int i=1;i<=n;i++)
				sum+=i;
			System.out.println("1부터 " + n + "까지의 합 : " + sum);
		}
	}
}
