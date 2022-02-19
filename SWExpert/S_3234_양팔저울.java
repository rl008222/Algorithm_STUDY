package a0218;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_3234_양팔저울 {
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans=0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			boolean check[] = new boolean[N];
			dfs(0, check, 0, 0, N, arr);
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void dfs(int cnt, boolean check[], int left,int right, int N, int arr[]) {
		if(cnt==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				dfs(cnt+1, check, left+arr[i], right, N, arr);
				if(left>=right+arr[i])
					dfs(cnt+1, check, left, right + arr[i], N, arr);
				check[i]=false;
			}
		}
	}

}
