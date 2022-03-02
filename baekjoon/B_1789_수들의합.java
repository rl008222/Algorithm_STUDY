package a0302;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long S = Long.parseLong(br.readLine());
		long sum=0;
		int cnt=-1;
		int idx=1;
		while(sum<=S) {
			
			sum+=idx;
			idx++;
			
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
