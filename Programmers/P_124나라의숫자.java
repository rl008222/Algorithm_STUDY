package a0323;

import java.io.IOException;

public class P_124나라의숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n=10;
		System.out.println(solution(n));

	}
	public static String solution(int n) {
        String answer = "";
        while(n>0) {
        	int num=n%3;
        	n/=3;
        	if(num==0) {
        		n--;
        		answer="4"+answer;
        	}else if(num==1){
        		answer="1" +answer;
        	}else {
        		answer="2" +answer;
        	}
        }
        
        return answer;
    }
}
