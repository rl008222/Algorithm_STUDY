package a0405;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class J_2577_회전초밥 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+k];
		int eat[] =new int[d+1];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for(int i=N;i<N+k;i++) {
			arr[i]=arr[i-N];
		}
		int ans=-1;
		int cnt=0;
		int coupon=0;
		
		for(int i=0;i<N+k;i++) {
			if(i>=k) {
				if(--eat[arr[i-k]]==0) cnt--;
				if(arr[i-k]==c) coupon--;
			}
			if(++eat[arr[i]]==1) cnt++;
			if(arr[i]==c) coupon++;
			if(i>=k) {
				ans=Math.max(ans, coupon==0 ? cnt+1:cnt);
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
