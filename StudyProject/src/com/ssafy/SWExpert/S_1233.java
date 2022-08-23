package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1;tc<=10;tc++) {
			boolean check= true;
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int cnt = st.countTokens();
				st.nextToken();
				String c= st.nextToken();
				
				if((c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) && cnt!=4) check = false;
				
				if(st.hasMoreTokens()) {
					c= st.nextToken();
					if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) check = false;
				}
			}
			bw.write("#" +tc + " " + (check?1:0));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
