package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2527 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int arr[][];
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr=new int[2][4];
			for(int j=0;j<8;j++) {
				if(j<4)
					arr[0][j]=Integer.parseInt(st.nextToken());
				else {
					arr[1][j-4]=Integer.parseInt(st.nextToken());
				}
			}
			
			if((arr[0][0] > arr[1][2]) || (arr[1][0] > arr[0][2])||
				(arr[0][1] > arr[1][3]) || (arr[1][1]>arr[0][3]))
					sb.append("d\n");	//사각형 겹치는 부분 없을 때
			else if((arr[0][0] == arr[1][2] || arr[1][0] == arr[0][2])&&
				(arr[0][1] == arr[1][3] || arr[1][1]==arr[0][3]))
					sb.append("c\n");	//한 꼭짓점만 겹침
			else if(arr[0][0] == arr[1][2] || arr[1][0] == arr[0][2]||
					arr[0][1] == arr[1][3] || arr[1][1]==arr[0][3])
				sb.append("b\n");		//한 점만 일치
			else 
				sb.append("a\n");		//나머지 경우
		}
		System.out.println(sb);
	}

}
