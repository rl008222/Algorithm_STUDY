package com.ssafy.programmers;

public class P_멀쩡한사각형 {
	public static void main(String[] args) {
		System.out.println(solution(8, 12) + "");
	}
	public static long solution(int w, int h) {
		long answer = (long)w*h - (w+h - gcd(w, h));
        return answer;
    }
	public static int gcd(int w, int h) {
		int a=w;
		int b=h;
		if(a<b) {
			b=w;
			a=h;
		}
		while(b>0) {
			int r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
}
