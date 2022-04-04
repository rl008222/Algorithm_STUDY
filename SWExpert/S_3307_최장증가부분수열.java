package a0404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int max=0;
			
			int N = Integer.parseInt(br.readLine());
			int arr[]= new int[N];
			int length[] =new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				length[i]=1;
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i]) {
						if(length[i]<length[j]+1) {
							length[i]=length[j]+1;
						}
					}
				}
				if(max<length[i])max=length[i];
			}
			bw.write("#" + tc + " " + max);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
