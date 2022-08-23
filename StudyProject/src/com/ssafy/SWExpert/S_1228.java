package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0;i<N;i++) 
				list.add(Integer.parseInt(st.nextToken()));
			
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int N2 = Integer.parseInt(st.nextToken());
				for(int j=0;j<N2;j++) {
					list.add(start+j, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0;i<10;i++) 
				System.out.print(list.get(i) + " ");
			
			System.out.println();
			
		}
	}
}
