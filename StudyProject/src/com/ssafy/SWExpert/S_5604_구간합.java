package a0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_5604_구간합 {
	static long ans;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			long mul = 1; 
			while(A <= B) { 
				while(A%10 != 0 && A <= B) {
					check(A,mul); 
					A++; 
				}	
				if(A > B || (A == 0 && B == 0)) break; 
				while(B%10 != 9 && A <= B) { 
					check(B,mul); 
					B--; 
				}
				A/=10; 
				B/=10; 
				long m = (B-A+1)*mul; 
				for(int i = 0; i < 10; i++) ans+=m*i; 
				mul*=10; 
			}

			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
 
	}
	static void check(long n, long t) {
		while(n>0) {
			ans+=(n%10)*t;
			n/=10;
		}
	}
}
