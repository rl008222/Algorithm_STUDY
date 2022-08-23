package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_3289_서로소집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#" + tc + " ");
			StringTokenizer st =new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int []parents = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				parents[i] = i;
			}
			for(int i=0;i<m;i++) {
				st =new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(a==0) {
					union(b, c, parents);
				}else {
					if(findSet(b, parents)==findSet(c, parents))
						bw.write(1 + "");
					else 
						bw.write(0 + "");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int findSet(int x, int []parents) {
		if(x== parents[x]) {
			return x;
		}
		return parents[x]=findSet(parents[x], parents);
	}
	public static void union(int a, int b, int []parents) {
		int aRoot = findSet(a, parents);
		int bRoot = findSet(b, parents);
		
		if (aRoot == bRoot) {
			return;
		}
		
		parents[bRoot] = aRoot;
		return;
	}
}
