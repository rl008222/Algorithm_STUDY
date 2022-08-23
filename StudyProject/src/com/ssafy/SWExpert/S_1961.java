package a0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1961 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int [][]arr = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int [][]ans90 = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ans90[j][N-i-1] = arr[i][j];
				}
			}
			int [][]ans180 = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ans180[j][N-i-1] = ans90[i][j];
				}
			}
			int [][]ans270 = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ans270[j][N-i-1] = ans180[i][j];
				}
			}
			bw.write("#" + tc);
			bw.newLine();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					bw.write(ans90[i][j] + "");
				}
				bw.write(" ");
				for(int j=0;j<N;j++) {
					bw.write(ans180[i][j] + "");
				}
				bw.write(" ");
				for(int j=0;j<N;j++) {
					bw.write(ans270[i][j] + "");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
