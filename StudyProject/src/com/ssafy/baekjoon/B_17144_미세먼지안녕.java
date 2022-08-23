package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17144_미세먼지안녕 {
	static Queue<Info> q = new LinkedList<>();
	static Queue<Info> q2 = new LinkedList<>();
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int R, C;
	static int flag=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int map[][] = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>4) q.add(new Info(i, j));
				if(map[i][j]==-1) q2.add(new Info(i, j));
			}
		}
		for(int i=0;i<T;i++) {
			spread(map);
			clean(map);
		}
		int ans=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0)ans+=map[i][j];
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static void clean(int map[][]) {
		Queue<Info> tempq = new LinkedList<>();
		int x1 = q2.poll().x;
		int x2 = q2.poll().x;
		for(int i=x1-1;i>=0;i--) tempq.offer(new Info(i, 0));
		for(int i=1;i<C;i++)tempq.offer(new Info(0, i));
		for(int i=1;i<x1+1;i++)tempq.offer(new Info(i, C-1));
		for(int i=C-1;i>0;i--)tempq.offer(new Info(x1, i));
		tempq.poll();
		for(int i=x1-1;i>=0;i--) map[i][0]=map[tempq.peek().x][tempq.poll().y];
		for(int i=1;i<C;i++)map[0][i]=map[tempq.peek().x][tempq.poll().y];
		for(int i=1;i<x1+1;i++)map[i][C-1]=map[tempq.peek().x][tempq.poll().y];
		for(int i=C-1;i>1;i--)map[x1][i]=map[tempq.peek().x][tempq.poll().y];
		map[x1][1]=0;
		
		for(int i=x2+1;i<R;i++) tempq.offer(new Info(i, 0));
		for(int i=1;i<C;i++)tempq.offer(new Info(R-1, i));
		for(int i=R-1;i>x2-1;i--)tempq.offer(new Info(i, C-1));
		for(int i=C-1;i>0;i--)tempq.offer(new Info(x2, i));
		tempq.poll();
		for(int i=x2+1;i<R;i++) map[i][0]=map[tempq.peek().x][tempq.poll().y];
		for(int i=1;i<C;i++)map[R-1][i]=map[tempq.peek().x][tempq.poll().y];
		for(int i=R-1;i>x2-1;i--)map[i][C-1]=map[tempq.peek().x][tempq.poll().y];
		for(int i=C-1;i>1;i--)map[x2][i]=map[tempq.peek().x][tempq.poll().y]; 
		map[x2][1]=0;
		q2.offer(new Info(x1, 0));
		q2.offer(new Info(x2, 0));
	}
	static void spread(int map[][]) {
		Queue<Info> tempq = new LinkedList<>();
		int arr[][] = new int[R][C];
		while(!q.isEmpty()) tempq.add(q.poll());
		while(!tempq.isEmpty()) {
			Info info = tempq.poll();
			int temp = map[info.x][info.y]/5;
			int cnt=0;
			for(int i=0;i<4;i++) {
				int nx = info.x+dx[i];
				int ny = info.y+dy[i];
				if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
				if(map[nx][ny]!=-1) {
					arr[nx][ny]+=temp;
					q.offer(new Info(nx, ny));
					cnt++;
				}
			}
			map[info.x][info.y]-=(temp*cnt);
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=arr[i][j];
			}
		}
	}
	static class Info{
		int x, y;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		
	}
}
