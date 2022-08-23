package com.ssafy.baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2636_치즈 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int map[][]= new int[100][100];
	static int visit[][] = new int[100][100];
	static int cnt=0;
	static int time=0, ansPre=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<w;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<h;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		while(cnt>0) {
			initVisit(w, h);
			ansPre=0;
			time++;
			melt(0, 0,w,h);
		}
		
		bw.write(time + "\n" + ansPre);
		
		bw.flush();
		bw.close();
		br.close();

	}
	private static void initVisit(int w ,int h) {
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++) {
				visit[i][j] = 0;
			}
		
	}
	public static void melt(int x,int y, int w, int h) {
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx>w || ny <0 || ny>h)
				continue;

			if (map[nx][ny] == 1 && visit[nx][ny] == 0)
			{
				visit[nx][ny] = 1;
				map[nx][ny] = 0;
				cnt--;

				ansPre++;
			}
			else if (map[nx][ny] == 0 && visit[nx][ny] == 0)
				melt(nx, ny,w,h);
		}
	}
}
