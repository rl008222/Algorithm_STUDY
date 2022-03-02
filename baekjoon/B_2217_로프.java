package a0302;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B_2217_로프 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); 
		int max=0;
		for(int i=N-1;i>=0;i--) {
			int w = arr[i]*(N-i);
			if(max<w) max=w;
		}
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
