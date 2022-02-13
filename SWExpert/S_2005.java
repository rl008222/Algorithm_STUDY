package a0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S_2005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			arr[0][0]=1;
			bw.write("#" + tc);
			bw.newLine();
			for(int i=1;i<N;i++) {
				for(int j=0;j<=i;j++) {
					if(j-1 <0 || j+1 >=N) arr[i][j]=1;
					else arr[i][j]=arr[i-1][j-1] + arr[i-1][j];
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<=i;j++) {
					bw.write(arr[i][j] + " ");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
