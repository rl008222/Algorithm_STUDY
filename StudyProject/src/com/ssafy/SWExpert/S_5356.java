package com.ssafy.SWExpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S_5356 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			String []s = new String[5];
			for(int i=0;i<5;i++) {
				s[i] = br.readLine();
				max=Math.max(s[i].length(), max);
			}
			
			bw.write("#" + tc + " ");
			for(int i=0;i<max;i++) {
				for(int j=0;j<5;j++) {
					if(s[j].length() >i && s[j].charAt(i)!=0)
						bw.write(s[j].charAt(i) + "");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
