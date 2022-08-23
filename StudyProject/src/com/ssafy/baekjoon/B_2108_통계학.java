package a0322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class B_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[8001];
		int sum=0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int num =  Integer.parseInt(br.readLine());
			sum+=num;
			arr[num+4000]++;
			if(max<num) max=num;
			if(min>num) min=num;
		}
		int cnt=0;
		int mode_max=0;
		int median=10000;
		int mode=10000;
		boolean flag=false;
		for(int i=min+4000;i<=max+4000;i++) {
			if(arr[i]>0) {
				if(cnt<(N+1)/2) {
					cnt+=arr[i];
					median=i-4000;
				}
				if(mode_max<arr[i]) {
					mode_max=arr[i];
					mode=i-4000;
					flag=true;
				}
				else if(mode_max==arr[i]&&flag==true) {
					mode=i-4000;
					flag=false;
				}
			}
			
		}
		bw.write((int)(Math.round((double)sum/N)) + "\n");
		bw.write(median + "\n");
		bw.write(mode + "\n");
		bw.write(max-min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
