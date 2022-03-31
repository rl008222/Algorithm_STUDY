package a0331;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[1000001];
		for(int i=2;i<=N;i++) {
			arr[i]=arr[i-1]+1;
			if(i%2==0) arr[i]=Math.min(arr[i], arr[i/2]+1);
			if(i%3==0) arr[i]=Math.min(arr[i], arr[i/3]+1);
			
		}
		bw.write(arr[N]+"");
		bw.flush();
		bw.close();
		br.close();

	}
}
