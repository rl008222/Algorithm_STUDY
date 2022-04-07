package a0407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class S_1249_보급로 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			int map[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j]=s.charAt(j)-'0';
				}
			}
			ans=Integer.MAX_VALUE;
			bfs(arr, map, N);
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void bfs(int arr[][], int map[][], int N) {
		Queue<Point> q= new LinkedList<>();
		boolean visit[][] =new boolean[N][N];
		q.offer(new Point(0, 0));
		visit[0][0]=true;
		while(!q.isEmpty()) {
			Point q2 = q.poll();
			if(q2.x==N-1 && q2.y==N-1) {
				ans=Math.min(ans, map[q2.x][q2.y]);
				continue;
			}
			if(map[q2.x][q2.y]>ans) continue;
			
			for(int i=0;i<4;i++) {
				int nx = q2.x+dx[i];
				int ny = q2.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(!visit[nx][ny] || map[nx][ny]>map[q2.x][q2.y]+arr[nx][ny])
				{
					map[nx][ny] = map[q2.x][q2.y]+arr[nx][ny];
					visit[nx][ny]=true;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
