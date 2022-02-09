package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int arr[][]= new int[6][2];
		int W=0, H=0;
		int subW = 0, subH=0;
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(arr[i][0]==1 || arr[i][0]==2) {
				if(W<arr[i][1]) {
					W = arr[i][1];
				}
			}
			else if(arr[i][0]==3 || arr[i][0]==4) {
				if(H<arr[i][1]) {
					H= arr[i][1];
				}
			}
		}
		for(int i=0;i<6;i++) {
			if(arr[i][0]==1 || arr[i][0] == 2) {
				if(i==0) {
					if(arr[5][1] + arr[i+1][1]==H) subW = arr[i][1];
				}
				else if(i==5) {
					if(arr[i-1][1] + arr[0][1]==H) subW = arr[i][1];
				}
				else {
					if(arr[i-1][1] + arr[i+1][1]==H) subW = arr[i][1];
				}
			}
			else if(arr[i][0]==3 || arr[i][0] == 4) {
				if(i==0) {
					if(arr[5][1] + arr[i+1][1]==W) subH = arr[i][1];
				}
				else if(i==5) {
					if(arr[i-1][1] + arr[0][1]==W) subH = arr[i][1];
				}
				else {
					if(arr[i-1][1] + arr[i+1][1]==W) subH = arr[i][1];
				}
			}
		}
		System.out.println(((W*H) - (subH*subW)) * K);

	}

}
