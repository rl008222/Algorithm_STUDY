package a0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S_2007 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String s = br.readLine();
			
			for(int i=1;i<s.length();i++) {
				if(s.substring(0, i).equals(s.substring(i, i+i))) {
					ans=i;
					break;
				}
			}
			
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
