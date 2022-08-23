package a0311;

public class Pro_카펫 {

	public static void main(String[] args) {
		int a=24;
		int b=24;
		int c[]=solution(a, b);
		System.out.println(c[0] + "" + c[1]);
	}
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int halfsum=brown/2;
        for(int i=halfsum-1;i>=halfsum/2;i--) {
        	int j=halfsum-i;
			if((i-1)*(j-1)==yellow) {
    			answer[0] = i+1;
    			answer[1]=j+1;
    			break;
			}
        }
        return answer;
    }
}
