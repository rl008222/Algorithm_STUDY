package a0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B_10026_적록색약 {

	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		char arr1[][] = new char[N][N];
		char arr2[][] = new char[N][N];
		boolean check[][]= new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				arr1[i][j]=s.charAt(j);
				arr2[i][j]=arr1[i][j];
				if(arr2[i][j]=='G') arr2[i][j]='R';
			}
		}
		
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					bfs(i, j, arr1, check); 
					ans++;
				}
			}
		}
		bw.write(ans + " ");
		
		check = new boolean[N][N];
		ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!check[i][j]) {
					bfs(i, j, arr2, check); 
					ans++;
				}
			}
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
	static void bfs(int x, int y, char arr[][], boolean check[][]) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(x, y));
		check[x][y]=true;
		while(!q.isEmpty()) {
			Loc p = q.poll();
			for(int i =0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(arr[nx][ny]==arr[p.x][p.y] && !check[nx][ny])
				{
					q.offer(new Loc(nx, ny));
					check[nx][ny]=true;
				}
			}
		}
	}
	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
