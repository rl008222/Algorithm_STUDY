package a0310;

import java.util.HashSet;
import java.util.Iterator;

class Pro_소수찾기 {
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) {

		String s = "011";
		System.out.println(solution(s));
	}
	public static int solution(String numbers) {
        int answer = 0;
        recursive("", numbers);
        boolean check=false;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
        	check=false;
        	int num = it.next().intValue();
        	if(num==0 || num==1) continue;
        	int lim = (int)Math.sqrt(num);
        	
        	for(int i=2;i<=lim;i++)
        		if(num%i==0) check=true;
        	
        	if(!check) answer++;
        }
        
        
        return answer;
    }
	public static void recursive(String s, String numbers) {
		if(!s.equals(""))
			set.add(Integer.valueOf(s));
		for(int i=0;i<numbers.length();i++) {
			recursive(s+numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1, numbers.length()));
		}
			
	}
}
