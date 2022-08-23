package com.ssafy.programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P_최소스패닝트리 {
	public static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			List<Node> list = new ArrayList<>();
			parents = new int[E+1];
			
			for(int i=1;i<=E;i++) {
				parents[i] = i;
			}
			
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				list.add(new Node(a,b,c));
				
			}
			Collections.sort(list, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o2.w-o1.w;
				}
			});

			int sum=0;
			for(int i=0;i<list.size();i++) {
				if(union(list.get(i).x, list.get(i).y)) {
					sum+=list.get(i).w;
				}
			}
			bw.write("#"+tc + " " + sum);
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	private static boolean union(int x, int y) {
		int rootx=find(x);
		int rooty=find(y);
		if(rootx==rooty)return false;
		parents[rooty]=rootx;
		return true;
	}

	private static int find(int x) {
		if(x==parents[x]) return parents[x];
		return parents[x]=find(parents[x]);	
	}

	public static class Node{
		int x;
		int y;
		int w;
		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}	
	}
}
