package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class S_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int total = 0;
			int pole = 0;
			char front='t';
			String s = br.readLine();
			char []c = s.toCharArray();
			for(int i=0;i<s.length();i++) {
				char current = c[i];
				if(current == '(') {
					pole++;
				}else {
					if(front == '(') {
						pole--;
						total +=pole;
					}else {
						pole--;
						total++;
					}
					
				}
				front = current;
			}
			bw.write("#" + tc + " " + total + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
