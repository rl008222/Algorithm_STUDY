package com.ssafy.programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro_전화번호목록 {

	public static void main(String[] args) {
		String phone_book[] = {"12", "123", "1235", "567", "88"};
		System.out.println(solution(phone_book));
	}
	 public static boolean solution(String[] phone_book) {
	        boolean answer = true;
	        Map<String, Integer> map = new HashMap<>();
	        for(int i=0;i<phone_book.length;i++) {
	        	map.put(phone_book[i], i);
	        }
	        for(int i=0;i<phone_book.length;i++) {
	        	for(int j=0;j<phone_book[i].length();j++) {
	        		if(map.containsKey(phone_book[i].substring(0, j)))
	        			return false;
	        	}
	        }
	       
	        return answer;
	    }
}
