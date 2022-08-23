package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S_1860_진기의최고급붕어빵 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Integer arr[] = new Integer[N];
			st= new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			
			String s = "Possible";
			for(int i=N-1;i>=0;i--) {
				if(((arr[i]/M)*K) - i<=0) {
					s="Impossible";
					break;
				}
			}
			
			/*
			int cnt=0;
			int idx2=0;
			for(int idx=0;idx<arr[N-1]+1;idx++) {
				if(idx!=0 && idx%M==0) {
					cnt+=K;
				}
				if(idx==arr[idx2]) {
					if(cnt==0) {
						s = "Impossible";
						break;
					}
					cnt--;
					idx2++;
				}
			}
			*/
			bw.write("#" + tc + " " + s);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
