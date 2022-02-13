package a0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int garo[] = new int[N+1];
			int sero[] = new int[N+1];
			for(int i=0;i<N;i++) {
				int cnt1=0;
				int cnt2=0;
				for(int j=0;j<N;j++) {
					if(arr[i][j]==1) {
						if(j==N-1) garo[++cnt1]++;
						else cnt1++;
					}
					else {
						garo[cnt1]++; 
						cnt1=0;
					}
					
					if(arr[j][i]==1) {
						if(j==N-1) sero[++cnt2]++;
						else cnt2++;
					}
					else {
						sero[cnt2]++; 
						cnt2=0;
					}
					
				}
			}
			bw.write("#" + tc + " " + (garo[K]+sero[K]) + "\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
