package a0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
	
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(a) {
			case 1:
				for(int j=b;j<N+1;j+=b) {
					arr[j]=(arr[j]==0?1:0);
				}
				break;
			case 2:
				arr[b]=(arr[b]==0?1:0);
				for(int j=1;j<N;j++) {
					if(b-j<1 || b+j>N) break;
					if(arr[b-j] != arr[b+j]) break;
					arr[b-j]=(arr[b-j]==0?1:0);
					arr[b+j]=arr[b-j];
				}
				break;
			}
		}
		for(int i=1;i<=N;i++) {
			if(i!=1 && i%20==1) bw.newLine();
			bw.write(arr[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
