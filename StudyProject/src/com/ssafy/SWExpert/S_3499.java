package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			int tempN;
			if(N%2==0) tempN=N/2; 
			else tempN=N/2+1;
			for(int i=0;i<tempN;i++) q1.add(st.nextToken());
			for(int i=tempN;i<N;i++) q2.add(st.nextToken());
			
			bw.write("#" + tc + " ");
			while(!q1.isEmpty()) {
				bw.write(q1.poll() + " ");
				if(q2.isEmpty()) break;
				bw.write(q2.poll() + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
