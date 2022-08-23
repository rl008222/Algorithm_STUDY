package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_2628 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		List<Integer> r = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(a) {
			case 0:
				r.add(b);
				break;
			case 1:
				c.add(b);
				break;
			}
		}
		Collections.sort(r);
		Collections.sort(c);
		int ans=0;
		int max=0;
		int start=0;
		
		for(int i=0;i<r.size();i++) {
			int temp = r.get(i) - start;
			if(max<temp)
				max=temp;
			start=r.get(i);
		}
		max = Math.max(max, H-start);
		ans = max;
		
		max=0;
		start=0;
		for(int i=0;i<c.size();i++) {
			int temp = c.get(i) - start;
			if(max<temp)
				max=temp;
			start=c.get(i);
		}
		max = Math.max(max, W-start);
		
		
		bw.write((ans*max) + "");
		bw.flush();
		bw.close();
		br.close();
		
		

	}

}
