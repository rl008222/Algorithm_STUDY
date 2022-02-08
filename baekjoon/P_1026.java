package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1026 {
	static int N;
	static boolean check[];
	static int A[];
	static int B[];
	static int min=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
			B[i]=Integer.parseInt(st2.nextToken());
		}
		check = new boolean[N];
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i=0;i<N;i++) {
			min+=A[i]*B[N-1-i];
		}
		//recursive(0, 0);
		System.out.println(min);
	}
	/*
	static void recursive(int idx, int result) {
		if(idx==N) {
			if(min>result)
				min = result;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				result+=A[i]*B[idx];
				recursive(idx+1, result);
				result-=A[i]*B[idx];
				check[i]=false;
			}
		}
	}
	*/
}
