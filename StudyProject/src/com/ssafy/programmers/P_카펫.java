package a0530;

public class P_카펫 {

	public static void main(String[] args) {
		int []a = solution(10, 2);
		System.out.println(a[0] + ", " + a[1]);
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int half = brown/2;
        for(int i=half-1;i>=half/2;i--) {
        	int j = half-i;
        	if((i-1)*(j-1) == yellow) {
        		answer= new int[]{i+1, j+1};
        		break;
        	}
        }
        return answer;
    }
}
















//class Solution {
//    public int[] solution(int brown, int yellow) {
//        int[] answer = new int[2];
//        int halfsum=brown/2;
//        for(int i=halfsum-1;i>=halfsum/2;i--) {
//        	int j=halfsum-i;
//			if((i-1)*(j-1)==yellow) {
//    			answer[0] = i+1;
//    			answer[1]=j+1;
//    			break;
//			}
//    		
//        	
//        	if(answer[0]!=0) break;
//        }
//        return answer;
//    }
//}