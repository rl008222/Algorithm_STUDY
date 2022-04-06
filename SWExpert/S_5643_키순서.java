package a0406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5643_키순서 {
	static boolean check[];
	static int N,M;
	static List<Integer>[] arr;
	static int cnt[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new ArrayList[N];
			cnt = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
			}
			for(int i=0;i<N;i++) {
				solution(i);
			}
			int ans=0;
			for(int i=0;i<N;i++) {
				if(cnt[i]==N) ans++;
			}
			
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void solution(int start) {
		boolean[] visit = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visit[start]=true;
		while(!q.isEmpty()) {
			int q2 = q.poll();
			cnt[start]++;
			for(int j=0;j<arr[q2].size();j++) {
				int a = arr[q2].get(j);
				if(!visit[a]) {
					visit[a]=true;
					cnt[a]++;
					q.offer(a);
				}
			}
		}
	}
}
