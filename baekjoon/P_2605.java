package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[]= new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++) {
			list.add(arr[i], i+1);
		}
		Collections.reverse(list);
		for(int i=0;i<N;i++) {
			sb.append(list.get(i) +" ");
		}
		System.out.println(sb);
	}

}
