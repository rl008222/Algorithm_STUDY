package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_1592 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int idx=0;
		arr[idx]=1;
		int cnt=0;
		while(true) {
			if(arr[idx]==M) break;
			if(arr[idx]%2==1) {
				idx+=L;
				if(idx>=N) idx-=N;
			}
			else {
				idx-=L;
				if(idx<0) idx+=N;
			}
			arr[idx]++;
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
