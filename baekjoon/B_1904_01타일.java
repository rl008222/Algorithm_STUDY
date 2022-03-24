package a0324;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1904_01타일 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int []arr = new int[N+1];
		if(N==1) bw.write("1");
		else if(N==2) bw.write("2");
		else {
			arr[1]=1;
			arr[2]=2;
			
			for(int i=3;i<=N;i++) {
				arr[i]=(arr[i-1]+arr[i-2])%15746;
			}
			bw.write(arr[N] + "");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
