package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15654 {
	static int arr[];
	static int M, N;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		boolean []check = new boolean[N];
		int selected[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		combination(0, selected, check);
		bw.flush();
		bw.close();
		br.close();

	}
	static void combination(int cnt, int selected[], boolean check[]) throws IOException {
		if(cnt==M) {
			for(int i=0;i<cnt;i++) {
				bw.write(selected[i] + " ");
			}
			bw.newLine();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!check[i]) {
				check[i]=true;
				selected[cnt]=arr[i];
				combination(cnt+1, selected, check);
				check[i]=false;
			}
		}
	}

}
