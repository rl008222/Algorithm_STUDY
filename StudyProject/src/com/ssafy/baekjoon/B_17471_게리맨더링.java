package a0406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471_게리맨더링 {
	static int N;
	static int arr[][];
	static int po[];
	static int ans=987654321;
	static boolean[] visit, select;
	static ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		po=new int[N];
		arr = new int[N][N];
		visit = new boolean[N];
		select = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			po[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][a-1]=1;
				arr[a-1][i]=1;
			}
		}
		solution(0, 0);
		ans = ans == 987654321 ? -1 : ans;
		bw.write(ans+ "");
		bw.flush();
		bw.close();
		br.close();

	}
	static void solution(int depth, int idx) {
		if(depth >=1) {
			int sumA = 0;
			int sumB=0;
			for(int i=0;i<N;i++) {
				if(select[i]) {
					a.add(i);
					sumA += po[i];
				}else {
					b.add(i);
					sumB+=po[i];
				}
			}
			// a 선거구와 b 선거구와 지역 하나 이상씩 포함하고 둘 다 연결돼있을 때
			if (a.size() > 0 && b.size() > 0 && isConnect(a, true) && isConnect(b, false)) {
				ans = Math.min(ans,  Math.abs(sumA - sumB));
			}
			
			a.clear();
			b.clear();
		}
		// a 선거구를 고르는 모든 경우의 수
		for (int i = idx; i < N; i++) {
			select[i] = true;
			solution(depth + 1, i + 1);
			select[i]= false;
		}
		
		
	}
	// 선거구가 연결돼있는지 체크하는 함수
	static boolean isConnect(ArrayList<Integer> list, boolean type) {
		int first = list.get(0);
		int cnt = 1;
		
		q.add(first);
		visit[first] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next = 0; next < N; next++) {
				// 해당 선거구 type으로 연결돼있고 방문하지 않았을 때
				if (arr[cur][next]==1 && select[next] == type && !visit[next]) {
					visit[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++)
			 visit[i] = false;
		
		// 연결 여부는 순회한 횟수가 선거구의 크기와 같으면 됩니다.
		return list.size() == cnt;
	}
}
