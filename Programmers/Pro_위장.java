package a0310;

import java.util.HashMap;
import java.util.Iterator;

public class Pro_위장 {

	public static void main(String[] args) {
		String s[][] = {{"yellowhat", "headgear"}, 
				{"bluesunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
		System.out.println(solution(s));
	}
	 public static int solution(String[][] clothes) {
	        int answer = 1;
	        HashMap<String, Integer> hash = new HashMap<>();
	        for(int i=0;i<clothes.length;i++) {
	        	String type = clothes[i][1];
	        	hash.put(type, hash.getOrDefault(type, 0)+1);
	        }
	        Iterator<Integer> it = hash.values().iterator();
	        while(it.hasNext()) {
	        	answer*=it.next().intValue()+1;
	        }
	        
	        return answer-1;
	    }
}
