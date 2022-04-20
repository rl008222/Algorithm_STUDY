package a0420;

import java.util.PriorityQueue;

public class P_프린터 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 2 }, 2) + "");
	}
	public static class loc implements Comparable<loc>{
		int x,y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(loc o) {
			return o.y-y;
		}
		
	}
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		PriorityQueue<loc> q = new PriorityQueue<>();
		for(int i=0;i<priorities.length;i++) {
	    	q.add(new loc(i, priorities[i]));
	    }
		int cnt=0;
		while(!q.isEmpty()) {
			cnt++;
			if(q.poll().x==location) {
				answer=cnt;
				break;
			}
		}
		/*
	    Queue<loc> q = new LinkedList<>();
	    List<Integer> list = new LinkedList<>();
	    for(int i=0;i<priorities.length;i++) {
	    	q.add(new loc(i, priorities[i]));
	    	list.add(priorities[i]);
	    }
	    Collections.sort(list, Collections.reverseOrder());
	    int cnt=0;
	    for(int i=0;;) {
	    	if(q.peek().getY()==list.get(i)) {
	    		cnt++;
	    		i++;
	    		if(q.poll().getX()==location) {
	    			answer=cnt;
	    			break;
	    		}
	    	}else {
	    		q.add(q.poll());
	    	}
	    }
	    */
		
	    return answer;
	}
}
