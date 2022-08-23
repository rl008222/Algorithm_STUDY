package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		Stack<Integer> num = new Stack<>();
		Stack<Integer> length = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int []ans = new int[N];
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			if(num.isEmpty()) {
				num.push(i);
				length.push(temp);
			}
			else {
				while(true) {
					if(num.isEmpty()) {
						num.push(i);
						length.push(temp);
						break;
					}
					if(length.peek()>temp) {
						ans[i]=num.peek()+1;
						num.push(i);
						length.push(temp);
						break;
					}
					else {
						num.pop();
						length.pop();
					}
				}
			}	
		}
		for(int j=0;j<N;j++) {
			System.out.print(ans[j] + " ");
		}
		
	}
}
