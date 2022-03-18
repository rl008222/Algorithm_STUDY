package a0318;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2108_통계학 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String s= br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
