package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int length=1;
		int ans=0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1]) 
				length++;
			else 
				length=1;
			
			ans = Math.max(length, ans);
		}
		length=1;
		for(int i=0;i<N-1;i++) {
			if(arr[i]>=arr[i+1]) 
				length++;
			else 
				length=1;
			
			ans = Math.max(length, ans);
		}
		
		System.out.println(ans);

	}

}
