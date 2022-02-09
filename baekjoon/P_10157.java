package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		if(K>C*R) {sb.append("0");}
		else {
			int dir=0;
			int ans=0;
			int x=R-1, y=0;
			int arr[][] = new int[R][C];
			arr[x][y] = ++ans;
			while(true) {
					switch(dir) {
					case 0:
						if(x-1<0 || arr[x-1][y]!=0) dir++;
						else {
							arr[x-1][y] = ++ans;
							x--;
						}
						break;
					case 1:
						if(y+1>=C || arr[x][y+1]!=0) dir++;
						else {
							arr[x][y+1] = ++ans;
							y++;
						}
						break;
					case 2:
						if(x+1>=R || arr[x+1][y]!=0) dir++;
						else {
							arr[x+1][y] = ++ans;
							x++;
						}
						break;
					case 3:
						if(arr[x][y-1]!=0) dir=0;
						else {
							arr[x][y-1] = ++ans;
							y--;
						}
						break;
					}
					if(ans==C*R) break;
			}
			boolean check=false;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]==K) {
						sb.append((j+1)+ " " + (R-i));
						check=true;
						break;
					}
						
				}
				if(check) break;
			}
		}
		System.out.println(sb);
	}

}
