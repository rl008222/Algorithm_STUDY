package com.ssafy.SWExpert;

import java.util.Scanner;

public class P_1873 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			int x = 0,y=0,dir=0;
			char arr[][]=new char[H][W];
			for(int i=0;i<H;i++) {
				char []c = sc.nextLine().toCharArray();
				for(int j=0;j<W;j++) {
					arr[i][j]=c[j];
					switch(c[j]) {
						case '^':
							x=i;
							y=j;
							dir=0;
							break;
						case 'v':
							x=i;
							y=j;
							dir=1;
							break;
						case '<':
							x=i;
							y=j;
							dir=2;
							break;
						case '>':
							x=i;
							y=j;
							dir=3;
						
					}
				}
			}
			int user = sc.nextInt();
			sc.nextLine();
			char []c = sc.nextLine().toCharArray();
			for(int i=0;i<user;i++) {
				switch(c[i]) {
				case 'U':
					dir=0;
					if(x-1 < 0) {
						arr[x][y]='^';
						break;
					}
					if(arr[x-1][y]=='.') {
						arr[x][y]='.';
						x--;
					}
					arr[x][y]='^';
					break;
				case 'D':
					dir=1;
					if(x+1 ==H) {
						arr[x][y]='v';
						break;
					}
					if(arr[x+1][y]=='.') {
						arr[x][y]='.';
						x++;
					}
					arr[x][y]='v';
					break;
				case 'L':
					dir=2;
					if(y-1 < 0) {
						arr[x][y]='<';
						break;
					}
					if(arr[x][y-1]=='.') {
						arr[x][y]='.';
						y--;
						
					}
					arr[x][y]='<';
					break;
				case 'R':
					dir=3;
					if(y+1 ==W) {
						arr[x][y]='>';
						break;
					}
					if(arr[x][y+1]=='.') {
						arr[x][y]='.';
						y++;
						
					}
					arr[x][y]='>';
					break;
				case 'S':
					switch(dir) {
					case 0:
						if(x-1<0)
							break;
						for(int j=x-1;j>=0;j--) {
							if(arr[j][y]=='*') {
								arr[j][y]='.';
								break;
							}
							if(arr[j][y]=='#') 
								break;
						}
						
						break;
					case 1:
						if(x+1==H)
							break;
						for(int j=x+1;j<H;j++) {
							if(arr[j][y]=='*') {
								arr[j][y]='.';
								break;
							}
							if(arr[j][y]=='#') 
								break;
						}
						break;
					case 2:
						if(y-1<0)
							break;
						for(int j=y-1;j>=0;j--) {
							if(arr[x][j]=='*') {
								arr[x][j]='.';
								break;
							}
							if(arr[x][j]=='#') 
								break;
						}
						
						break;
					case 3:
						if(y+1==W)
							break;
						for(int j=y+1;j<W;j++) {
							if(arr[x][j]=='*') {
								arr[x][j]='.';
								break;
							}
							if(arr[x][j]=='#') 
								break;
						}
						break;
					}
					break;
				}
			}
			System.out.print("#" + (tc+1) + " ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			
		}
	}

}
