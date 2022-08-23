package com.ssafy.baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P_1181 {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int N = br.read();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String []s = new String[N];
		for(int i=0;i<N;i++) {
			s[i] = sc.next();
		}
		
		Arrays.sort(s);
		Arrays.sort(s, Comparator.comparing(String::length));


		String temp="";
		
		for(int i=0;i<N;i++) {
			if(temp.equals(s[i])) {
				continue;
			}
			else {
				System.out.println(s[i]);
				temp = s[i];
			}
		}
		
	}
}
