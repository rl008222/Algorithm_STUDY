package a0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_9229 {
	static int N, M, ans, arr[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<TC;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[N];
			check = new boolean[N];
			for(int i=0;i<N;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			ans=-1;
			recursive(0, 0, 0);
			System.out.println("#" + (tc+1) + " " + ans);
		}
	}
	static void recursive(int idx, int cnt, int sum) {
		if(cnt == 2) {
			if(sum>M) return;
			if(ans<=sum) 
				ans = sum;
			return;
			
		}
		if(sum>M) return;
		for(int i=idx;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				recursive(i+1, cnt+1, sum+arr[i]);
				check[i]=false;
			}
		}
	}
}
