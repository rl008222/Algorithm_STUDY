package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_16935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][]A = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			int type = Integer.parseInt(st.nextToken());
			int min;
			int [][]temp;
			int subN;
			int subM;
			int A1[][];
			int A2[][];
			int A3[][];
			int A4[][];
			switch(type) {
			case 1:
				min = N/2;
				for(int i=0;i<min;i++) {
					for(int j=0;j<M;j++) {
						int t = A[i][j];
						A[i][j]=A[N-i-1][j];
						A[N-i-1][j] = t;
					}
				}
				
				break;
			case 2:
				min = M/2;
				for(int i=0;i<min;i++) {
					for(int j=0;j<N;j++) {
						int t = A[j][i];
						A[j][i]=A[j][M-i-1];
						A[j][M-i-1] = t;
					}
				}
				break;
			case 3:
				temp = new int[M][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						temp[j][N-1-i]=A[i][j];
					}
				}
				A=temp;
				int t=N;
				N=M;
				M=t;
				break;
			case 4:
				temp = new int[M][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						temp[M-1-j][i]=A[i][j];
					}
				}
				A=temp;
				t=N;
				N=M;
				M=t;
				break;
			case 5:
				 subN=N/2;
				 subM=M/2;
				 A1 = new int[subN][subM];
				 A2 = new int[subN][subM];
				 A3 = new int[subN][subM];
				 A4 = new int[subN][subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A1[i][j]=A[i][j];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A2[i][j]=A[i][j+subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A3[i][j]=A[i+subN][j+subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A4[i][j]=A[i+subN][j];
				
				temp = new int[N][M];
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(i<subN && j<subM)
							temp[i][j]=A4[i][j];
						if(i<subN && j>=subM)
							temp[i][j]=A1[i][j-subM];
						if(i>=subN && j<subM)
							temp[i][j]=A3[i-subN][j];
						if(i>=subN && j>=subM)
							temp[i][j]=A2[i-subN][j-subM];
					}
				}
				A=temp;
				break;
			case 6:
				 subN=N/2;
				 subM=M/2;
				 A1 = new int[subN][subM];
				 A2 = new int[subN][subM];
				 A3 = new int[subN][subM];
				 A4= new int[subN][subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A1[i][j]=A[i][j];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A2[i][j]=A[i][j+subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A3[i][j]=A[i+subN][j+subM];
				for(int i=0;i<subN;i++) 
					for(int j=0;j<subM;j++)
						A4[i][j]=A[i+subN][j];
				
				temp = new int[N][M];
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(i<subN && j<subM)
							temp[i][j]=A2[i][j];
						if(i<subN && j>=subM)
							temp[i][j]=A3[i][j-subM];
						if(i>=subN && j<subM)
							temp[i][j]=A1[i-subN][j];
						if(i>=subN && j>=subM)
							temp[i][j]=A4[i-subN][j-subM];
					}
				}
				A=temp;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

		
		
	}

}
