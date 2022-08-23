package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1769 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		int sum=0;
		int cnt=0;
		if(X.length()>1) {
			while(X.length()>1) {
				char []a = X.toCharArray();
				sum=0;
				for(int j=0;j<a.length;j++) {
					sum+=a[j]-'0';
				}
				X = sum + "";
				cnt++;
			}
		}
		else 
			sum = X.charAt(0)-'0';
		
		if(sum!=0 && sum%3==0)
			System.out.println(cnt + "\nYES");
		else
			System.out.println(cnt + "\nNO");

	}

}
