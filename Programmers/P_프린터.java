package a0322;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P_프린터 {
	public static void main(String[] args) {
		int[] a = { 1, 1, 9, 1, 1, 1};

		System.out.println(solution(a, 0));
	}
	static class loc{
		int x; int y;

		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<loc> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<priorities.length;i++) {
			q.add(new loc(priorities[i], i));
			list.add(priorities[i]);
		}
		Collections.sort(list, Collections.reverseOrder());
		int cnt=0;
		for(int i=0;;) {
			if(q.peek().getX()==list.get(i)) {
				cnt++;
				i++;
				if(q.poll().getY()==location) {
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
