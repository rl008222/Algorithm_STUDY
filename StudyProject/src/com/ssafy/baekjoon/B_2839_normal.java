package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2839_normal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i*3<=N;i++) {
			if((N-i*3)%5 == 0) {
				bw.write(i+ (N-i*3)/5 +"");
				break;
			}
			if(N - i*3 <3) {
				bw.write("-1");
				break;
			}	
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
