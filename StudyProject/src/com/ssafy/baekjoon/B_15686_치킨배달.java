package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_15686_치킨배달 {
	static int N,M;
	static int map[][];
	static int ans=Integer.MAX_VALUE;
	static Stack<Loc> home = new Stack<>();
	static Stack<Loc> chicken = new Stack<>();
	static Stack<Loc> selected = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) home.push(new Loc(i, j));
				else if(map[i][j]==2) chicken.push(new Loc(i, j));
			}
		}
		dfs(0, 0);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
	static void dfs(int idx, int cnt) {
		if(cnt==M) {
			int dist=0;
			for(int i=0;i<home.size();i++) {
				int minDist=N*N;
				int hx=home.get(i).x;
				int hy=home.get(i).y;
				for(int j=0;j<M;j++) {
					int cx = selected.get(j).x;
					int cy = selected.get(j).y;
					
					minDist=Math.min(minDist, Math.abs(hx-cx) + Math.abs(hy-cy));
				}
				dist+=minDist;
			}
			ans = Math.min(ans, dist);
		}
		for(int i=idx;i<chicken.size();i++) {
			selected.push(chicken.get(i));
			dfs(i+1, cnt+1);
			selected.pop();
		}
	}
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
