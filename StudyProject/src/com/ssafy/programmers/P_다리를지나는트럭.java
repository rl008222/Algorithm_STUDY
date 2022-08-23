package a0413;

import java.util.LinkedList;
import java.util.Queue;

public class P_다리를지나는트럭 {
	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[] {10}) + "");
	}
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> q = new LinkedList<>();
	        int sum=0;
	        for(int i=0;i<truck_weights.length;) {
	        	answer++;
	        	if(i>=truck_weights.length || sum+truck_weights[i]>weight) {
	        		q.add(0);
	        	}else {
	        		q.add(truck_weights[i]);
	        		sum+=truck_weights[i];
	        		i++;
	        	}
	        	
	        	if(q.size()==bridge_length) {
	        		sum-=q.poll();
	        	}
	        }
	        
	        return answer+bridge_length;
	 }
}
