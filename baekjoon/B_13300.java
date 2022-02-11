package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_13300 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[6][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			arr[Integer.parseInt(st.nextToken())-1][gender]++;
		}
		int sum=0;
		for(int i=0;i<6;i++) {
			sum += arr[i][0]/K + (arr[i][0]%K !=0?1:0)
			     + arr[i][1]/K + (arr[i][1]%K !=0?1:0);
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
