package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = br.read();

		String []s = new String[N];
		for(int i=0;i<N;i++) {
			s[i] = br.readLine();
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
