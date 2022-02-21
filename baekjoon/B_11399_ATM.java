package a0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		arr[1]=arr[0]+arr[1];
		int sum=arr[1];
		for(int i=2;i<N;i++) {
			arr[i]=arr[i]+arr[i-1];
			sum+=arr[i];
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
