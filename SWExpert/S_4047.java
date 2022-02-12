package a0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S_4047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			char []c = br.readLine().toCharArray();
			int [][]arr = new int[4][13];
			
			for(int i=0;i<c.length;i+=3) {
				int num;
				if(c[i+1]=='0') {
					num=c[i+2]-'0';
				}else {
					num=(c[i+1]-'0')*10 + c[i+2]-'0';
				}
				switch(c[i]) {
					case 'S':
						arr[0][num-1]++;
						break;
					case 'D':
						arr[1][num-1]++;
						break;
					case 'H':
						arr[2][num-1]++;
						break;
					case 'C':
						arr[3][num-1]++;
						break;
				}
			}
			String s="";
			s += "#" + tc + " ";
			for(int i=0;i<4;i++) {
				int cnt=13;
				for(int j=0;j<13;j++) {
					if(arr[i][j]==2) {
						s="#" + tc + " ERROR";
						break;
					}
					cnt-=arr[i][j];
				}
				if(s.equals("#" + tc + " ERROR")) break;
				s += cnt + " ";
			}
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	
	}

}
