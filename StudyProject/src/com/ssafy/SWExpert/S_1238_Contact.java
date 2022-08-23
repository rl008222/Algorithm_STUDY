package a0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1238_Contact {
	static Queue<Node> q = new LinkedList<>();
	static class Node{
		int n;
		int d;
		public Node(int n, int d) {
			super();
			this.n = n;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[101][101];
			boolean check[] = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<length/2;i++) {
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			}
			
			bw.write("#" + tc + " " + bfs(start, arr, check, Integer.MIN_VALUE, Integer.MIN_VALUE));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static int bfs(int start, int arr[][], boolean check[], int maxN, int maxD) {
		q.offer(new Node(start, 0));
		check[start]=true;
	
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp.d >= maxD) {
				if(temp.d==maxD)
					maxN=Math.max(maxN, temp.n);
				else {
					maxD=temp.d;
					maxN=temp.n;
				}
			}
			for(int i=1;i<101;i++) {
				if(arr[temp.n][i]==1 && !check[i]) {
					q.offer(new Node(i, temp.d+1));
					check[i]=true;
				}
			}
		}
		return maxN;
	}
}
