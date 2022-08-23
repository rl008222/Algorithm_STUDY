package qqq;


public class P_큰수만들기 {

	public static void main(String[] args) {
		System.out.println(solution("4177252841", 4));

	}
	public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int start=0;
        int end=k;
        for(int i=0;i<number.length()-k;i++) {
        	char max=0;
        	int pos=0;
        	for(int j=start;j<=end;j++) {
        		if(max<number.charAt(j)) {
        			max=number.charAt(j);
        			pos=j;
        		}
        	}
        	sb.append(max);
        	start=pos+1;
        	end++;
        }
        
        return sb.toString();
    }
}
