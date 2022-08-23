package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_5644 {
	static int dx[] = {0, -1, 0, 1, 0};
	static int dy[] = {0, 0, 1, 0, -1};
	static int A;
	static int Sub_ans;
	static int Main_ans;
	static int user1[];
	static int user2[];
	static int user1_loc[] = new int[2];
	static int user2_loc[] = new int[2];
	static int AP[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Main_ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			user1 = new int[M];
			user2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				user1[j]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				user2[j]=Integer.parseInt(st.nextToken());
			}
			AP = new int[A][4];
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<4;j++) {
					AP[i][j]=Integer.parseInt(st.nextToken());
				}		
			}
			user1_loc[0]= 1;  user1_loc[1]= 1;
			user2_loc[0]= 10; user2_loc[1]= 10;
			for(int i=-1;i<M;i++) {
				calc(i);
			}
			bw.write("#" + tc + " " + Main_ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void calc(int idx) {
		Sub_ans=0;
		if(idx!=-1) {
			user1_loc[0]+=dx[user1[idx]];
			user2_loc[0]+=dx[user2[idx]];
			user1_loc[1]+=dy[user1[idx]];
			user2_loc[1]+=dy[user2[idx]];
		}
		boolean []check1 = new boolean[A];
		boolean []check2 = new boolean[A];
		
		for(int j=0;j<A;j++) {
			int temp1_loc = Math.abs(user1_loc[0] - AP[j][1]) + Math.abs(user1_loc[1]-AP[j][0]);
			int temp2_loc = Math.abs(user2_loc[0] - AP[j][1]) + Math.abs(user2_loc[1]-AP[j][0]);
			if(temp1_loc<=AP[j][2]) check1[j]=true;
			if(temp2_loc<=AP[j][2]) check2[j]=true;
		}
		for(int j=0;j<A;j++) {
			for(int k=0;k<A;k++) {
				int sum=0;
				if(j!=k) {
					if(check1[j]) sum += AP[j][3];
					if(check2[k]) sum += AP[k][3];
				}else if(check1[j] || check2[k]) {
					sum = AP[j][3];
				}
				Sub_ans = Sub_ans>sum?Sub_ans:sum;
			}
		}
		Main_ans+=Sub_ans;
	}

}
