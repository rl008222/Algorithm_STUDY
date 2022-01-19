package com.ssafy.hw03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursionProcess {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\Users\\leekijong\\eclipse-workspace\\3_HWProject\\src\\com\\ssafy\\hw02\\input.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n= sc.nextInt();
			System.out.println("1부터 " + n + "까지의 합 : " + sum(1, n, 0));
		}
	}
	static int sum(int i, int n, int sum) {
		if(i==n)
			return sum;
		return sum(i++, n, sum+i);
	}
}
