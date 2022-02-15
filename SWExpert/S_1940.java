package a0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S_1940 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int speed=0;
			int N = sc.nextInt();
			
			for(int i=0;i<N;i++) {
				int s = sc.nextInt();
				int p=0;
				if(s!=0) { 
					p = sc.nextInt();
					speed = (s==1?speed+p:(speed<=p?0:speed-p));
				}
				ans+=speed;
			}
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
