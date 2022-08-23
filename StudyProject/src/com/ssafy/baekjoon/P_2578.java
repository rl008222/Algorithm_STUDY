package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2578 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [][]bingo = new int[5][5];
		int ans[] = new int[25];
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<5;j++) {
				bingo[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<5;j++) {
				ans[i*5+j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int a=0;a<25;a++) {
			int check=0;
			int bingocheck;
			for(int i=0;i<5;i++) 
				for(int j=0;j<5;j++) 
					if(bingo[i][j]==ans[a]) 
						bingo[i][j]=0;
					

			for(int i=0;i<5;i++) {
				bingocheck=0;
				for(int j=0;j<5;j++) {
					if(bingo[i][j]==0) bingocheck++;
				}
				if(bingocheck==5) check++;
			}
			
			for(int i=0;i<5;i++) {
				bingocheck=0;
				for(int j=0;j<5;j++) {
					if(bingo[j][i]==0) bingocheck++;
				}
				if(bingocheck==5) check++;
			}
			bingocheck=0;
			for(int i=0;i<5;i++) {
				if(bingo[i][i]==0) bingocheck++;
				if(bingocheck==5) check++;
			}
			bingocheck=0;
			for(int i=0;i<5;i++) {
				
				if(bingo[i][4-i]==0) bingocheck++;
				if(bingocheck==5) check++;
			}
			
			if(check>=3) {
				System.out.println(a+1);
				break;
			}
			
		}
		
	}

}
