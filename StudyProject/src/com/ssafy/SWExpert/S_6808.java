package a0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_6808 {
	static int gyu[];
	static int in[];
	
	static int ans[];
	static int arr[];
	
	static int cnt;
	
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[19];
			for(int i=0;i<9;i++) arr[Integer.parseInt(st.nextToken())]++;
			
			gyu=new int[9];
			in=new int[9];
			
			int gi=0, ii=0;
			for(int i=1;i<=18;i++) {
				if(arr[i]==1) gyu[gi++]=i;
				else in[ii++]=i;
			}
			
			check = new boolean[9];
			ans=new int[9];
			cnt=0;
			
			recursive(0);
			
			int max=1;
			for(int i=2;i<=9;i++) {
				max*=i;
			}
			
			bw.write("#" + tc + " " + cnt +" " +(max-cnt));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void recursive(int idx) {
		if(idx==9) {
			int score1=0;
			int score2=0;
			for(int i=0;i<9;i++) {
				int scoreSum= gyu[i]+ans[i];
				score1 = (gyu[i]>ans[i]?scoreSum+score1:score1);
				score2 = (gyu[i]<ans[i]?scoreSum+score2:score2);
			}
			if(score1>score2) cnt++;
			return;
		}
		for(int i=0;i<9;i++) {
			if(!check[i]) {
				check[i]=true;
				ans[idx]=in[i];
				recursive(idx+1);
				check[i]=false;
			}
		}
	}

}
