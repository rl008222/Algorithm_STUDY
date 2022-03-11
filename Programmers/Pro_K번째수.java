package a0311;

import java.util.ArrayList;
import java.util.Collections;

public class Pro_K번째수 {

	public static void main(String[] args) {
		int a[] = {1, 5, 2, 6, 3, 7, 4};
		int c[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int b[] = solution(a, c);
		System.out.println(b[0] + "");
		System.out.println(b[1] + "");
		System.out.println(b[2] + "");
	}
	 public static int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        for(int i=0;i<commands.length;i++) {
	        	int a= commands[i][0];
	        	int b= commands[i][1];
	        	ArrayList<Integer> list = new ArrayList<>();
	        	
	        	for(int j =a-1;j<b;j++) {
	        		list.add(array[j]);
	        	}
	        	Collections.sort(list);
	        	answer[i]=list.get(commands[i][2]-1);
	        }
	        return answer;
	    }
}
