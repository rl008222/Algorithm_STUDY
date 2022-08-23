package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		int [][]arr = new int [N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
			arr[i][2]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=100;i<=987;i++) {
			boolean check=true;
			for(int j=0;j<N;j++) {
				
				int s=0, b=0;
				int f=arr[j][0]/100;
				int g = arr[j][0]%100/10;
				int h = arr[j][0]%10;
				
				if(i/100 == f) s++;
				else if(i/100 ==g|| i/100==h) b++;
				if(i%100/10 == g) s++;
				else if(i%100/10==f|| i%100/10==h) b++;
				if(i%10 == h) s++;
				else if(i%10==g|| i%10==f) b++;
				
				if(arr[j][1]!=s || arr[j][2]!=b) {
					check=false;
					break;
				}
				
			}
			if(check)
				cnt++;
		}
		System.out.println(cnt);
	}
}
