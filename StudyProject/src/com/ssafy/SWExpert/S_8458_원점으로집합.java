package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_8458_원점으로집합 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];
			for(int i=0;i<N;i++) {
				StringTokenizer st  = new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			int max=Integer.MIN_VALUE;
			boolean check=false;
			if((Math.abs(arr[0][0]) + Math.abs(arr[0][1]))%2==0) {
				check=true;
			}
			for(int i=0;i<N;i++) {
				int abs = Math.abs(arr[i][0]) + Math.abs(arr[i][1]);
				max = Math.max(max, abs);
				if(check) {
					if(abs%2==0)continue;
				}
				else {
					if(abs%2!=0)continue;
				}
				ans=-1;
			}
			
			if(ans!=-1) {
				for(int dist=0;;dist+=ans) {
					if((dist-max)%2==0 && dist>=max) break;
					ans++;
				}
			}
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
