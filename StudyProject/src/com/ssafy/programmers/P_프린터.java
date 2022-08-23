package com.ssafy.programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_프린터 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 2 }, 2) + "");
	}
	public static class loc{
		int x,y;

		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static int solution(int[] priorities, int location) {
		int answer = 0;

	    Queue<loc> q = new LinkedList<>();
	    List<Integer> list = new LinkedList<>();
	    for(int i=0;i<priorities.length;i++) {
	    	q.add(new loc(i, priorities[i]));
	    	list.add(priorities[i]);
	    }
	    
	    Collections.sort(list, Collections.reverseOrder());
	    int cnt=0;
	    for(int i=0;;) {
	    	if(q.peek().y==list.get(i)) {
	    		cnt++;
	    		i++;
	    		if(q.poll().x==location) {
	    			answer=cnt;
	    			break;
	    		}
	    	}else {
	    		q.add(q.poll());
	    	}
	    }

	    return answer;
	}
}
