package a0404;

import java.io.IOException;

public class P_점프와순간이동 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println(solution(5000) + "");
	}
	public static int solution(int n) {
        int ans = 0;

        for(int i=n;i>0;i/=2) {
        	if(i%2==1) ans++;
        }
        return ans;
    }
}
