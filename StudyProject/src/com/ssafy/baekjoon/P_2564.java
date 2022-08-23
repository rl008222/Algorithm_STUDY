package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int shop = Integer.parseInt(br.readLine());
		int arr[][] = new int[shop][2];
		int dong[] = new int[2];
		for(int i=0;i<shop;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0]= Integer.parseInt(st.nextToken());;
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		dong[0]= Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());
		int sum=0;
		for(int i=0;i<shop;i++) {
			switch(arr[i][0]) {
				case 1:
					if(dong[0]==1)
						sum+=Math.abs(arr[i][1]-dong[1]);
					else if(dong[0]==2) 
						sum = sum + Math.min(dong[1]+arr[i][1] + Y, X - dong[1]+X-arr[i][1] + Y);
					else if(dong[0]==3)
						sum = sum + dong[1]+arr[i][1];
					else 
						sum = sum + dong[1] + X-arr[i][1];
					break;
				case 2:
					if(dong[0]==1)
						sum = sum + Math.min(dong[1]+arr[i][1] + Y, X - dong[1]+X-arr[i][1] + Y);
					else if(dong[0]==2) 
						sum+=Math.abs(arr[i][1]-dong[1]);
					else if(dong[0]==3)
						sum = sum + Y - dong[1]+arr[i][1];
					else 
						sum = sum + Y - dong[1] + X-arr[i][1];
					break;
				case 3:
					if(dong[0]==1)
						sum = sum + dong[1] + arr[i][1];
					else if(dong[0]==2) 
						sum = sum + dong[1] + Y-arr[i][1];
					else if(dong[0]==3)
						sum+=Math.abs(arr[i][1]-dong[1]);
					else 
						sum = sum + Math.min(dong[1]+arr[i][1] + X, Y - dong[1]+Y-arr[i][1] + X);
					break;
				case 4:
					if(dong[0]==1)
						sum = sum + X - dong[1] + arr[i][1];
					else if(dong[0]==2) 
						sum = sum + X - dong[1] + Y-arr[i][1];
					else if(dong[0]==3)
						sum = sum + Math.min(dong[1]+arr[i][1] + X, Y - dong[1]+Y-arr[i][1] + X);
					else 
						sum+=Math.abs(arr[i][1]-dong[1]);
					break;
			}
		}
		System.out.println(sum);
		
	}

}
