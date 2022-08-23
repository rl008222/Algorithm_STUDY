package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P_1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=0;tc<1;tc++) {
			int tn=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			LinkedList<Integer> queue = new LinkedList<>();
			for(int i=0;i<8;i++) queue.add(Integer.parseInt(st.nextToken()));
			boolean check=false;
			while(true) {
				for(int i=1;i<=5;i++) {
					if(queue.peek()-i<=0) {
						queue.poll();
						queue.add(0);
						check=true;
						break;
					}
					else {
						queue.add(queue.peek()-i);
						queue.poll();
					}
				}
				if(check) break;
			}
			
			System.out.print("#" + tn + " ");
			for(int i=0;i<8;i++) {
				System.out.print(queue.peek() + " ");
				queue.poll();
			}
			System.out.println();
		}

	}

}
