package a0401;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_4485_녹색옷입은애가젤다지 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int tc=1;;tc++) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int arr[][] = new int[N][N];
			int dist[][] = new int[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st  = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int ans=bfs(arr, dist, N);
			System.out.println("Problem " + tc + ": " + ans);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int bfs(int arr[][], int dist[][], int N) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		dist[0][0]=arr[0][0];
		while(!q.isEmpty()) {
			Point point = q.poll();
			for(int i=0;i<4;i++) {
				int nx = point.x+dx[i];
				int ny = point.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(dist[nx][ny]> dist[point.x][point.y]+arr[nx][ny]) {
					dist[nx][ny] = dist[point.x][point.y]+arr[nx][ny];
					q.offer(new Point(nx, ny, dist[nx][ny]));
				}
				
			}
		}
		return dist[N-1][N-1];
	}
	public static class Point{
		int x;
		int y;
		int value;
		public Point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
	}
	
}
