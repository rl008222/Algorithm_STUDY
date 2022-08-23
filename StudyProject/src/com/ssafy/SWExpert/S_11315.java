package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_11315 {
	static int dx[] = {1, 0, 1, -1 };
	static int dy[] = {0, 1, 1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			char [][]arr = new char[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=s.charAt(j);
				}
			}
			boolean check=false;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='o') {
						for(int dir=0;dir<4;dir++) {
							int x=i;
							int y=j;
							for(int k=0;k<4;k++) {
								int nx=x+dx[dir];
								int ny=y+dy[dir];
								x=nx;
								y=ny;
								if(nx<0 || ny<0 || nx>=N || ny>=N) break;
								if(arr[nx][ny]=='.') break;
								if(k==3) check=true;
								
							}
							if(check) break;
						}
					}
					if(check) break;
				}
				if(check) break;
			}
			bw.write("#" + tc + " ");
			if(check) bw.write("YES");
			else bw.write("NO");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
