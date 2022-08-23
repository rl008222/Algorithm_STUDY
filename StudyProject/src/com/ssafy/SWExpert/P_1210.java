package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int [][]arr;
		for(int tc=1;tc<=10;tc++) {
			arr = new int[100][100];
			int y=0;
			br.readLine();
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) y = j;
				}
			}
			for(int i=99;i>0;i--) {
				if(y!=0 && arr[i][y-1]==1) {
					while(true) {
						y--;
						if(arr[i-1][y]==1)
							break;
					}
				}
				else if(y!=99 &&arr[i][y+1]==1) {
					while(true) {
						y++;
						if(arr[i-1][y]==1)
							break;
					}
				}
			}
			sb.append("#" + tc + " " + y + "\n");
		}
		System.out.println(sb);
	}

}
