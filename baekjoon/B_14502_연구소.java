package a0408;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502_연구소 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int N;
	static int M;
	static int ans=0;
	static List<Point> list = new ArrayList<>();
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int arr[][] =new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) list.add(new Point(i, j));
			}
		}
		solution(0, arr);
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
	public static void solution(int cnt, int arr[][]) {
		if(cnt==3) {
			Queue<Point> q = new LinkedList<>();
			for(int i=0;i<list.size();i++) {
				q.offer(new Point(list.get(i).x, list.get(i).y));
			}
			bfs(arr, q);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					solution(cnt+1, arr);
					arr[i][j]=0;
				}
			}
		}
		
	}
	public static void bfs(int arr[][],  Queue<Point> tq) {
		int cnt=0;
		boolean visited[][] = new boolean[N][M];
		while(!tq.isEmpty()) {
			Point p = tq.poll();
			visited[p.x][p.y]=true;
			for(int i=0;i<4;i++) {
				int nx= p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>= M) continue;
				if(arr[nx][ny]==2 || arr[nx][ny]==1) continue;
				if(visited[nx][ny]) continue;
				visited[nx][ny]=true;
				tq.offer(new Point(nx, ny));
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0 && !visited[i][j]) cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
	
}
