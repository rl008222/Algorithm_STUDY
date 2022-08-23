package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1953_탈주범검거 {
	static int dx[]= {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = bfs(N, M, R, C, L, arr);
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	public static int bfs(int n, int m, int r, int c, int l, int[][] arr) {
		int cnt=1;
		int step=0;
		if(step==l-1) return 1;
		Queue<Point> q = new LinkedList<>();
		boolean visited[][] = new boolean[n][m];
		visited[r][c]=true;
		q.offer(new Point(r, c));
		while(!q.isEmpty()) {
			int size=q.size();
			for(int k=0;k<size;k++) {
				Point q2 = q.poll();
				int x = q2.x;
				int y=q2.y;
				for(int i=0;i<4;i++) {
					int nx =x+dx[i];
					int ny = y+dy[i];
					if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
					if(visited[nx][ny] || arr[x][y]<=0 || arr[nx][ny]<=0) continue;
					//0 상, 1 하, 2 좌, 3 우
					if(i==0 &&(arr[x][y]==3 || arr[x][y]==5 || arr[x][y]==6)) continue;
					if(i==1 &&(arr[x][y]==3 || arr[x][y]==4 || arr[x][y]==7)) continue;
					if(i==2 &&(arr[x][y]==2 || arr[x][y]==4 || arr[x][y]==5)) continue;
					if(i==3 &&(arr[x][y]==2 || arr[x][y]==6 || arr[x][y]==7)) continue;
	
					if(i==0 &&(arr[nx][ny]==3 || arr[nx][ny]==4 || arr[nx][ny]==7)) continue;
					if(i==1 &&(arr[nx][ny]==3 || arr[nx][ny]==5 || arr[nx][ny]==6)) continue;
					if(i==2 &&(arr[nx][ny]==2 || arr[nx][ny]==6 || arr[nx][ny]==7)) continue;
					if(i==3 &&(arr[nx][ny]==2 || arr[nx][ny]==4 || arr[nx][ny]==5)) continue;
					visited[nx][ny]=true;
					cnt++;
					q.offer(new Point(nx, ny));
				}
			}
			step++;
			if(step>=l-1) break;
		}
		return cnt;
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
