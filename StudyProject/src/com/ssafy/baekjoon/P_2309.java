package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[9];
		int sum=0;
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+= arr[i];
		}
		Arrays.sort(arr);
		boolean check=false;
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-arr[i]-arr[j] == 100) {
					arr[i]=0;
					arr[j]=0;
					check=true;
					break;
				}
			}
			if(check)break;
		}
		for(int i=0;i<9;i++) {
			if(arr[i]!=0)
				sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

}
