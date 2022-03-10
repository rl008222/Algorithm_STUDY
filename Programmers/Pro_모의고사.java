package a0310;

import java.util.ArrayList;
import java.util.List;

public class Pro_모의고사 {

	public static void main(String[] args) {
		int a[] = {1, 3, 2,4 , 2};
		System.out.println(solution(a)[0] + "");
		System.out.println(solution(a)[1] + "");
		System.out.println(solution(a)[2] + "");
	}
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int acnt=0, bcnt=0, ccnt=0;
        for(int i=0;i<answers.length;i++) {
        	if(a[i%5]==answers[i]) acnt++;
        	if(b[i%8]==answers[i]) bcnt++;
        	if(c[i%10]==answers[i]) ccnt++;
        }
        int max = Math.max(acnt, Math.max(bcnt, ccnt));
        List<Integer> list = new ArrayList<>();
        if(acnt==max) list.add(1);
        if(bcnt==max) list.add(2);
        if(ccnt==max) list.add(3);
        answer = new int[list.size()];
        int cnt=0;
        for(int num : list) {
        	answer[cnt++]=num;
        }
        return answer;
    }
}
