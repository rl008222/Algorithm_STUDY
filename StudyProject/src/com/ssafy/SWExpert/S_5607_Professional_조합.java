package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_5607_Professional_조합 {
	static int P=1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			StringTokenizer st  =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			ans = modul(N, R);
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	public static long modul(int n, int r) {
		int P=1234567891;
		if(r==0) return 1L;
		long fac[] = new long[n+1];
		fac[0]=1;
		for(int i=1;i<=n;i++) {
			fac[i]=fac[i-1]*i%P;
		}
		long ans = (fac[n]*pow(fac[r], P-2) %P*pow(fac[n-r], P-2) %P) %P;
		return ans;
	}
	public static long pow(long a, int b) {
		if(b==0) return 1L;
		long m=pow(a, b /2);
		long temp = m*m%P;
		if(b%2 ==0) {
			return temp;
			
		}else {
			return a*temp%P;
		}
	}
}
