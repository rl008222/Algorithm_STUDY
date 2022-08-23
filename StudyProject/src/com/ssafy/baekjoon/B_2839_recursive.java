package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2839_recursive {
	static int ans;
	static int cnt;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		cnt=N/5;
		recursive(cnt);
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static void recursive(int cnt) {
		if(cnt==-1) {
			ans=-1; return;
		}
		if ((N-cnt*5)%3==0){
			ans=cnt+((N-(cnt*5))/3);
			return;
		}
		recursive(cnt-1);
	}
}
