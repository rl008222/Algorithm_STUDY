package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_5215 {
	static int max=0;
	static int [][]arr;
	static boolean []check;
	static int N, L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			check = new boolean[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			resursive(0);
			System.out.println("#" + (tc+1) +" " +max);
			max=0;
		}
	}
	static void resursive(int i) {
		if(i==N) {
			int kcal=0;
			int score=0;
			for(int j=0;j<N;j++) {
				if(check[j]) {
					score+=arr[j][0];
				 	kcal+=arr[j][1];
				}
			}
			if(kcal<=L && score>max) {
				max=score;
			}
			return;
		}
		check[i]=true;
		resursive(i+1);
		check[i]=false;
		resursive(i+1);
	}
	/*			시간이 더 짧게 걸린다.
	static void find(int[][] R, int idx, int curPoint, int curCal) {
		if ( curCal > maxCal ) {
			return; 
		}
		if ( curPoint > answer ) {
			answer = curPoint;
		}
		if ( idx == N) {
			return;
		}
		find(R, idx+1, curPoint+R[idx][0], curCal + R[idx][1]);// 현재 재료 사용
		find(R, idx+1, curPoint, curCal);                      // 현재 재료 안쓰기
	} 
	 */

}
