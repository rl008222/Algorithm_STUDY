package a0511;

import java.util.ArrayList;
import java.util.List;

public class P_영어끝말잇기 {
	public static void main(String[] args) {
		int a[] = solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
		System.out.println(a[0]+", "+a[1]);
	}
	 public static int[] solution(int n, String[] words) {
	        int[] answer = {0, 0};
	        List<String> list = new ArrayList<>();
	        String temp="";
	        for(int i=0;i<words.length;i++) {
	        	System.out.println(words[i]);
	        	
	        	if(list.contains(words[i]) || 
	        			(i!=0 && words[i].charAt(0)!=temp.charAt(temp.length()-1))) {
	        		return new int[]{i%n+1, i/n+1};
	        	}
	        	list.add(words[i]);
	        	temp=words[i];
	        }
	        
	        return answer;
	 }
}
