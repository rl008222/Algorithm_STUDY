package a0224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1753_최단경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			list[u].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int []distance = new int[V+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[K]=0;
		
		dijkstra(K, distance, list);
		for(int i=1;i<V+1; i++) {
			if(distance[i]==INF)
				bw.write("INF");
			else
				bw.write(distance[i] + "");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void dijkstra(int K, int distance[], ArrayList<Node>[] list){
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(K, 0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			int v = node.v;
			int w = node.w;
			if(distance[v] < w) {
				continue;
			}
			for(int i=0;i<list[v].size();i++) {
				int v2 = list[v].get(i).v;
				int w2 = list[v].get(i).w+w;
				if(distance[v2]>w2) {
					distance[v2]=w2;
					q.add(new Node(v2, w2));
				}
			}
		}
	
	}
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
		
	}

}
