package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4963 {
	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int arr[][];
	static boolean check[][];
	static int w, h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			if(h==0 && w==0) break;
			
			arr = new int[w][h];
			check = new boolean[w][h];
			
			for(int i=0;i<w;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<h;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					if(!check[i][j] && arr[i][j]==1) {
						dfs(i, j); cnt++;
					}
				}
			}
			
			bw.write("dfs : " + cnt + "");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int i, int j) {
		check[i][j]=true;
		
		for(int dir=0;dir<8;dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			
			if(nx<0 || ny<0 || nx>=w || ny>=h) continue;
			if(!check[nx][ny] && arr[nx][ny]==1) dfs(nx, ny);
			
		}
		
	}
}
