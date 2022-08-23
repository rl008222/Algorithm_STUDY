package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=0;tc<10;tc++) {
			int dump = Integer.parseInt(br.readLine());
			int []box = new int[100];
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			for(int i=0;i<100;i++) {
				box[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(box);
			for(int i=0;i<dump;i++) {
				if(box[0]>box[99])
					break;
				box[99]--;
				box[0]++;
				Arrays.sort(box);
			}
			
			System.out.println("#" + (tc+1) + " " + (box[99]-box[0]));
		}
	}
}

