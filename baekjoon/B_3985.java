package a0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int max=0;
		int ans=0;
		int ans2=0;
		int arr[] = new int[L];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(max<K-P+1) {
				max = K-P+1;
				ans=i+1;
			}
			for(int j=P-1;j<K;j++) {
				if(arr[j]==0)
					arr[j]=i+1;
			}
		}
		int temp[]=new int[N+1];
		for(int i=0;i<L;i++)  temp[arr[i]]++;
		max=0;
		for(int i=1;i<=N;i++) {
			if(max<temp[i]) {
				max=temp[i];
				ans2=i;
			}
		
		}
		bw.write(ans + "\n" + ans2);
		bw.flush();
		bw.close();
		br.close();
	

		
	}

}
