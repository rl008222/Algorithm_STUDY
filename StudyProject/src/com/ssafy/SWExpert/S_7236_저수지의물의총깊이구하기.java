package a0224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_7236_저수지의물의총깊이구하기 {
	static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			char arr[][] = new char[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=st.nextToken().charAt(0);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='W') {
						int cnt=0;
						for(int k=0;k<8;k++) {
							int nx=i+dx[k];
							int ny=j+dy[k];
							if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
							if(arr[nx][ny]=='W') cnt++;
						}
						if(cnt==0) cnt=1;
						ans = Math.max(cnt, ans);
					}
				}
			}
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
