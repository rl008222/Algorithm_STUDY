package a0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_1074 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		recursive(N, r, c);
		bw.write(cnt+ "");
		bw.flush();
		bw.close();
		br.close();
	}
	static void recursive(int n, int r, int c) {
		if(n==0) return;

		int length = (int)Math.pow(2, n)/2;
		int skip = (int)Math.pow(4, n-1);
		
		if(r<length && c<length) {
			recursive(n-1, r, c);
		}else if(r<length && c>=length) {
			cnt+=skip;
			recursive(n-1, r, c-length);
		}else if(r>=length && c<length) {
			cnt+=skip*2;
			recursive(n-1, r-length, c);
		}else if(r>=length && c>=length) {
			cnt+=skip*3;
			recursive(n-1, r-length, c-length);
		}
		
	}

}
