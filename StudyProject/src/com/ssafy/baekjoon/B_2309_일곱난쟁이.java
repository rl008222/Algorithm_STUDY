package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B_2309_일곱난쟁이 {

	static int arr[];
	static int selected[];
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		arr = new int[9];
		selected = new int[7];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		recursive(0, 0, 0);
		bw.flush();
		bw.close();
		br.close();

	}
	static void recursive(int idx, int cnt, int sum) throws IOException {
		if(cnt==7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					bw.write(selected[i] + "");
					bw.newLine();
				}
			}
			return;
		}
		for(int i=idx;i<9;i++) {
			selected[cnt]=arr[i];
			if(sum+selected[cnt]<=100)
				recursive(i+1, cnt+1, sum+selected[cnt]);
		}
	}
}
