package a0225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_7576_토마토 {
	static int dx[]= {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int N, M;
	static int cnt=0;
	static int day=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		LinkedList<Loc> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.offer(new Loc(i, j, 0));
				}
				if(arr[i][j]==0) cnt++;
			}
		}
		int ans=0;
		ans = bfs(arr, q);
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
	static int bfs(int arr[][], LinkedList<Loc> queue) {
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = loc.x+dx[i];
				int ny = loc.y+dy[i];
				if(nx<0 || ny< 0 || nx>=N || ny>=M || arr[nx][ny]==-1) continue;
				if(arr[nx][ny]==0) {
					cnt--;
					arr[nx][ny]=loc.day+1;
					queue.offer(new Loc(nx, ny, loc.day+1));
				}
			}
			if(cnt==0) {
				return queue.pollLast().day;
			}
		}
		return -1;
	}
	static class Loc{
		int x, y, day;

		public Loc(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day=day;
		}
		
	}
}
