package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_16496_큰수만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int numbers[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
			
		}
		bw.write(solution(numbers)+"");
		bw.flush();
		bw.close();
		br.close();
				
	}
	
	public static String solution(int[] numbers) {
		
		String answer = "";
		
		String[] s = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			s[i] = numbers[i] + "";
		}

		Arrays.sort(s, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		if (s[0].equals("0"))
			return "0";
		
		for (String a : s) 
			answer += a;
		
		return answer;
	}
}