package a0322;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P_기능개발 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int a[]= {93, 30, 55};
		int b[]= {1, 30, 5};
		
		System.out.println(solution(a, b)[0] + " " + solution(a, b)[1]);
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q= new LinkedList<>();
        Queue<Integer> day = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++)
        	q.add(100-progresses[i]);
        
        for(int i=0;i<speeds.length;i++) {
        	if(q.peek()%speeds[i]==0)
        		day.add(q.poll()/speeds[i]);
        	else
        		day.add(q.poll()/speeds[i]+1);
        }
        
        int start = day.poll();
        int cnt=1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<progresses.length;i++) {
        	if(start<day.peek()) {
        		start=day.peek();
        		list.add(cnt);
        		cnt=0;
        	}
        	day.poll();
        	cnt++;
        }
        list.add(cnt);
		int[] answer = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i]=list.get(i);
		}

        return answer;
    }

}
