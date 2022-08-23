package a0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[100][100];
		for(int sq=0;sq<4;sq++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			
			for(int i=99-y;i>99-q;i--) {
				for(int j=x;j<p;j++) {
					arr[i][j]=1;
				}
			}
			
		}
		
		int cnt=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
