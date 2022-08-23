package com.ssafy.jungol;

import java.util.Scanner;

// 제출할 때는 class명 Main으로
public class P_1071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int []arr = new int[n];
		
		for(int i=0;i<n;i++) arr[i]=sc.nextInt();
		
		int m = sc.nextInt();
		
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<n;i++) {
			if(m%arr[i]==0)
				sum1+=arr[i];
			else if(arr[i]%m==0)
				sum2+=arr[i];
		}
		System.out.print(sum1 + "\n" + sum2);
		
		sc.close();

	}

}
