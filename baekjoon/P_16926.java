package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_16926 {
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int [][]A = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();

		int min = M/2;
		if(N<M) min=N/2; 
		for(int i=0;i<min;i++){
			for(int r=0;r<R;r++) {
				int temp=A[i][i];
				
				int tx=i;
				int ty=i;
				int dir=0;
				
				while(dir!=4) {
					int nx = tx + dx[dir];
					int ny = ty + dy[dir];
					
					if(nx<i || nx>=N-i || ny<i || ny>=M-i) {
						dir++;
						continue;
					}
					A[tx][ty] = A[nx][ny];
					
					tx = nx;
					ty = ny;
				}
				A[i+1][i] = temp;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
