package a0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S_4012 {
	static boolean check[];
	static int arr[][];
	static int N;
	static int diff;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			check = new boolean[N];
			diff = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recursive(0, 0);
			bw.write("#" + tc + " " + diff);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void recursive(int idx, int cnt) {
		if(cnt==N/2) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			int sum1=0;
			int sum2=0;
			for(int i=0;i<N;i++) {
				if(check[i]) list1.add(i);
				else list2.add(i);
			}
			
			for(int i=0;i<list1.size()-1;i++) {
				for(int j=i;j<list1.size();j++) {
					int a = list1.get(i);
					int b = list1.get(j);
					sum1+=arr[a][b]+arr[b][a];
					a=list2.get(i);
					b=list2.get(j);
					sum2+=arr[a][b]+arr[b][a];
				}
			}
			if(diff>Math.abs(sum1 - sum2))
				diff = Math.abs(sum1 - sum2);
			return;
		}
		for(int i=idx;i<N;i++) {
			check[i]=true;
			recursive(i+1, cnt+1);
			check[i]=false;
		}
		
		
	}

}
