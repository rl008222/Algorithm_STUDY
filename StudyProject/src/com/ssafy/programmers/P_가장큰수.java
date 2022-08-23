package com.ssafy.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P_가장큰수 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] s = new String[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			s[i] = numbers[i] + "";
		}

		Arrays.sort(s, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

		if (s[0].equals("0"))
			return "0";
		
		for (String a : s) 
			answer += a;
		return answer;
	}
}

/*
 * import java.util.Arrays; import java.util.Comparator; class Solution { public
 * String solution(int[] a) { String[] s = new String[a.length]; for(int
 * i=0;i<a.length;i++) { s[i]=a[i]+""; } String answer = ""; Arrays.sort(s, new
 * Comparator<String>(){
 * @Override public int compare(String o1, String o2) { return
 * ((o2+o1).compareTo(o1+o2)); } }); if(s[0].equals("0")) return "0"; for(String
 * b : s) { answer+=b; } return answer; } }
 */