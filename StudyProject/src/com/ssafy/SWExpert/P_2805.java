package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int [][]arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=s.charAt(j)-'0';
				}
			}
			int x=(N-1)/2;
			int y=(N-1)/2;
			int size=x;
			int sum=0;
			for(int i=0;i<=x;i++) {
				for(int j=size;j<=y;j++)
					sum += arr[i][j];
				size--;
				y++;
			}
			size=1;
			for(int i=x+1;i<N;i++) {
				for(int j=size;j<N-size;j++)
					sum += arr[i][j];
				size++;
			}
			System.out.println("#" + (tc+1) + " " +sum);

		}
		
		
	}
}
