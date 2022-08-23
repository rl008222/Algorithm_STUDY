package a0222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S_4047_영준이의카드카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int arr[][] = new int[4][13];
			char []c = br.readLine().toCharArray();
			for(int i=0;i<c.length;i+=3) {
				int num=0;
				if(c[i+1]=='0') {
					num=c[i+2]-'0';
				}
				else {
					num=(c[i+1]-'0') * 10 + (c[i+2]-'0'); 
				}
				switch(c[i]){
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
			bw.write("#" + tc + " ");
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<4;i++) {
				int ans=0;
				for(int j=0;j<13;j++) {
					if(arr[i][j]>1) {
						sb.delete(0, sb.length());
						sb.append("ERROR");
						break;
					}
					if(arr[i][j]==0) ans++;
				}
				if(sb.toString().equals("ERROR")) break;
				else sb.append(ans + " ");
			}
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
