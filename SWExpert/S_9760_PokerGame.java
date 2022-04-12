package a0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_9760_PokerGame {
	static String set[] = {"Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", "Three of a kind", "Two pair", "One pair", "High card"};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int type[]=new int[4];
			int num[] = new int[15];
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int i=0;i<5;i++) {
				String s= st.nextToken();
				if(s.charAt(0)=='S') type[0]++;
				else if(s.charAt(0)=='D')type[1]++;
				else if(s.charAt(0)=='H')type[2]++;
				else if(s.charAt(0)=='C')type[3]++;
				
				if(s.charAt(1)=='A') {
					num[1]++;
					num[14]++;
				}
				else if(s.charAt(1)=='T') num[10]++;
				else if(s.charAt(1)=='J') num[11]++;
				else if(s.charAt(1)=='Q') num[12]++;
				else if(s.charAt(1)=='K') num[13]++;
				else num[s.charAt(1)-'0']++;
			}
			
			
			boolean game[] = new boolean[9];
			game[8]=true;
			
			for(int i=0;i<4;i++) {
				if(type[i]==5) game[3]=true;
			}
			
			for(int i=1;i<=10;i++) {
				int cnt=0;
				for(int j=i;j<i+5;j++) {
					if(num[j]!=1) break;
					cnt++;
				}
				if(cnt==5) game[4]=true;
			}
			
			if(game[3] && game[4]) game[0]=true;
			
			int cnt=0;
			for(int i=1;i<14;i++) {
				if(num[i]==4) game[1]=true;
				else if(num[i]==2) cnt++;
				else if(num[i]==3) game[5]=true;
			}
			if(cnt==1) game[7]=true;
			if(cnt==2) game[6]=true;
			if(game[5] && cnt==1) game[2]=true;
			
			for(int i=0;i<9;i++) {
				if(game[i]) {
					bw.write("#" + tc + " " + set[i]);
					break;
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
