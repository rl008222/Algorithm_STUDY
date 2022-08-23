package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans=1;
		int arr[] = new int[T];
		for (int tc = 0; tc < T; tc++) {
			arr[tc] = Integer.parseInt(st.nextToken());
		}
		int pcnt=1, mcnt=1;
		for(int i=0;i<T-1;i++) {
			if(arr[i]>=arr[i+1]) {
				mcnt++;
			}else {
				mcnt=1;
			}
			if(arr[i]<=arr[i+1]) {
				pcnt++;
			}else {
				pcnt=1;
			}
			ans=Math.max(ans, Math.max(pcnt, mcnt));
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
