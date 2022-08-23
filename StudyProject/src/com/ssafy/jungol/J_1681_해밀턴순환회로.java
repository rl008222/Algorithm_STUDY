package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class J_1681_해밀턴순환회로 {

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int map[][]= new int[N][N];
		boolean check[] = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());		
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1,  0, N, map, check);
		if(ans==Integer.MAX_VALUE) ans=0;
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
	static void dfs(int start, int cnt, int cost, int N, int map[][], boolean check[]) {
		if(cnt==N) {
			if(map[start][0]==0) return;
			cost+=map[start][0];
			if(ans>cost) 
				ans=cost;
			return;
		}
		for(int i=1;i<N;i++) {
			if(!check[i]) {
				if(map[start][i]==0) continue;
				check[i]=true;
				if(ans>=cost+map[start][i])
					dfs(i, cnt+1, cost+map[start][i], N, map, check);
				check[i]=false;
			}
		}
	}
}
