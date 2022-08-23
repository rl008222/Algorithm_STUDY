package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[][]= new int[100][100];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++)
					arr[j][k]=1;
			}

		}
		int ans=0;
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++)
				if(arr[i][j]==1) ans++;
		bw.write(ans + "");
bw.flush();
bw.close();
br.close();
	}
}
