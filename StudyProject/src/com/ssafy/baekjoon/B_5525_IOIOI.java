package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class B_5525_IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String S = br.readLine();
		int ans=0;
		int cnt=0;
		for(int i=0;i<M-2;i++) {
			String temp = S.substring(i, i+3);
			if(temp.equals("IOI")) {
				cnt++;
				if(cnt==N) {
					ans++;
					cnt--;
				}
				i++;
			}
			else cnt=0;
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
