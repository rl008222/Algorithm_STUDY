package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_9095 {
	static int n;
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine());
			cnt=0;
			recursive(0);
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	static void recursive(int sum) {
		if(sum==n) {
			cnt++;
			return;
		}
		if(sum>n)
			return;
		
		recursive(sum+1);
		recursive(sum+2);
		recursive(sum+3);
	}

}
