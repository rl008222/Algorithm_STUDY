package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_1987 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int check[] = new int[26];
	static int R, C;
	static int arr[][];
	static int ans=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int i=0;i<R;i++) {
			String s =br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = s.charAt(j)-65;
			}
		}
		check[arr[0][0]]++;
		dfs(0, 0, 1);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y, int cnt) {
		ans = Math.max(cnt, ans);
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=R || ny >=C) continue;
			if(check[arr[nx][ny]]==0) {
				check[arr[nx][ny]]++;
				dfs(nx, ny, cnt+1);
				check[arr[nx][ny]]--;
			}
		}
	}

}
