package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B_17413_단어뒤집기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String s = br.readLine() + "\n";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='<') {
				while(!stack.empty()) {
					bw.write(stack.pop());
				}
				int idx = s.indexOf('>', i);
				bw.write(s.substring(i, idx+1));
				i=idx;
			}
			else if(s.charAt(i)==' ' || s.charAt(i)=='\n') {
				while(!stack.empty()) {
					bw.write(stack.pop());
				}
				bw.write(" ");
			}else {
				stack.push(s.charAt(i));
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
