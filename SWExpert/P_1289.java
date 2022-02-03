package com.ssafy.SWExpert;

import java.util.Scanner;

public class P_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int []cnt = new int[T];
		for(int i=0;i<T;i++) {
			String s = sc.next();
			char []num = s.toCharArray();
			char []temp = new char[num.length];
			
			for(int j=0; j<temp.length; j++) 
				temp[j] = '0';

			for(int j=0;j<temp.length;j++) {
				if(num[j]!=temp[j]) {
					for(int k=0;k<num.length;k++) {
						if(temp[k]=='0')
							temp[k]='1';
						else
							temp[k]='0';
						
					}
					cnt[i]++;
				}
				if(num==temp)
					break;
			}
		}
		for(int i=0;i<T;i++) {
			System.out.println("#" + (i+1) + " " + cnt[i]);
		}
		sc.close();
	}
}
