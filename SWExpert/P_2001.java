package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int [][]arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max=0;
			
			for(int tx=0;tx<=N-M;tx++) {
				for(int ty=0;ty<=N-M;ty++) {
					int sum=0;
					for(int i=tx;i<M+tx;i++) {
						for(int j=ty;j<M+ty;j++) {
							sum+=arr[i][j];
						}
					}
					if(max<sum) max=sum;
				}
			}
			//sb.append("#" + (tc+1) + " " + max + "\n");
		}
		System.out.println(sb);
	}
}
