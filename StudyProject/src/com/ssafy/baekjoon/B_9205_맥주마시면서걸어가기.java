package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_9205_맥주마시면서걸어가기 {
	static int arr[][];
	static int N;
	static boolean ans;
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			check=new boolean[101];
			ans=false;
			N = Integer.parseInt(br.readLine());
			arr = new int[N+2][2];
			
			for(int i=0;i<N+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(arr[0][0], arr[0][1]);
			if(ans) bw.write("happy");
			else bw.write("sad");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	
	}
	public static void dfs(int x, int y) {
		int dist=Math.abs(arr[N+1][0]-x) + Math.abs(arr[N+1][1]-y);
		
		if(dist<1001) {
			ans=true;
			return;
		}
		for(int i=1;i<N+1;i++) {
			dist=Math.abs(arr[i][0]-x) + Math.abs(arr[i][1]-y);
			if(check[i]) continue;
			if(dist<1001) {
				check[i]=true;
				dfs(arr[i][0], arr[i][1]);
			}
		}
	}
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
