package a0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S_7465_창용마을무리의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st  =new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int parents[] = new int[n+1];
			for(int i=1;i<n+1;i++) {
				parents[i]=i;
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b, parents);
			}
			Set<Integer> set = new HashSet<>();
			
			for(int i=1;i<n+1;i++) {
				set.add(findSet(i, parents));
			}
			int ans=set.size();
			bw.write("#" + tc + " " + ans);
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
