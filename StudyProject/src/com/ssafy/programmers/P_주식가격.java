package com.ssafy.programmers;

import java.io.IOException;

public class P_주식가격 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int a[] = solution(new int[] {1, 2, 3, 2, 3});
		System.out.println(a[0] + "");
		System.out.println(a[1] + "");
		System.out.println(a[2] + "");
		System.out.println(a[3] + "");
		System.out.println(a[4] + "");
	}
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i =0;i<prices.length;i++) {
        	int cnt=0;
        	for(int j=i+1;j<prices.length;j++) {
        		if(prices[i]<=prices[j]) cnt++;
        		else {
        			cnt++;
        			break;
        		}
        	}
        	answer[i]=cnt;
        }
        return answer;
    }
}
