package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1861 {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0 ,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int [][]arr = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());					
				}
			}
			int max=0;
			int min = Integer.MAX_VALUE;
			int ans=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int x=i;
					int y=j;
					int cnt=1;
					boolean check=true;
					while(check) {
						check=false;
						for(int k=0;k<4;k++) {
							int nx=x+dx[k];
							int ny=y+dy[k];
							if(nx<0 || ny < 0 || nx>=N || ny>=N)
								continue;
							if(arr[nx][ny]==(arr[x][y]+1)) {
								x=nx;
								y=ny;
								check=true;
								cnt++;
							}
						}
					}
					if(max<=cnt && cnt>1) {
						if(max==cnt) ans = Math.min(arr[i][j], ans);
						else ans = arr[i][j];
						max=cnt;
					}
					
					min = Math.min(arr[i][j], min);
				}
			}
			if(max==0) {
				ans=1;
				max=min;
			}
			bw.write("#" + tc + " " + ans + " " + max);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
