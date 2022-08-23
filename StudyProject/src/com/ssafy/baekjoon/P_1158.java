package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		
		bw.write("<");
		for(int i=1;i<=N;i++)
			queue.add(i);
		while(!queue.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				queue.add(queue.peek());
				queue.poll();
			}
			if(queue.size()==1) {
				bw.write(queue.peek() + ">");
				break;
			}
			bw.write(queue.peek() + ", ");
			queue.poll();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
