package a0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260_DFS와BFS {
	static int N;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int arr[][] = new int[1001][1001];
		boolean check[] = new boolean[1001];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		dfs(V, arr, check);
		bw.newLine();
		check = new boolean[1001];
		bfs(V, arr, check);
		bw.flush();
		bw.close();
		br.close();

	}
	public static void dfs(int v, int arr[][], boolean check[]) throws IOException {
		check[v] = true;
	    bw.write(v + " ");
	    
	    for(int i = 1; i <= N; i++) {
	      if(arr[v][i] == 1 && !check[i]) {
	          dfs(i, arr, check);
	      }
	    }
	}
	public static void bfs(int v, int arr[][], boolean check[]) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		check[v]=true;
		bw.write(v + " ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i=1;i<=N;i++) {
				if(arr[temp][i] == 1 && !check[i]) {
					q.offer(i);
					check[i]=true;
					bw.write(i + " ");
				}
			}
		}
	
	}


}
