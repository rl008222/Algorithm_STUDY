package com.ssafy.SWExpert;

import java.util.Scanner;

public class P_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			int [][]num=new int[N][N];
			int x=0, y=0;
			int dir=0;
			for(int i=1;i<=N*N;i++) {
				num[x][y]=i;
				switch(dir) {
					case 0:
						y++;
						if(y==N || num[x][y]!=0) {
							y--;
							x++;
							dir++;
						}
						break;
					case 1:
						x++;
						if(x==N || num[x][y]!=0) {
							x--;
							y--;
							dir++;
						}
						break;
					case 2:
						y--;
						if(y<0 || num[x][y]!=0) {
							y++;
							x--;
							dir++;
						}
						break;
					case 3:
						x--;
						if(num[x][y]!=0) {
							x++;
							y++;
							dir=0;
						}
				}
			}
			System.out.println("#" + (tc+1));
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(num[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
}
