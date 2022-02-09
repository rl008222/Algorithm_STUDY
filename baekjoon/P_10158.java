package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());
		
		int Tw = (p+t);
		int Th = (q+t);
		
		if(Tw%2 == 0 ) 	//이 값이 짝수라면 x=0에서 출발해 (p+t)%w인 곳에 개미 위치
			p = (p+t)%w;
		
		else
			
		System.out.println(p + " " + q);
		
	}

}
