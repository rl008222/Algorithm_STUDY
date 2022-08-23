package a0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759_암호만들기 {
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char arr[] = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(arr, 0, 0, L, C, "", 0, 0);
		bw.flush();
		bw.close();
		br.close();

	}
	public static void dfs(char arr[], int toSelect, int idx, int L, int C, String s, int a, int b) throws IOException {
		if(toSelect==L) {
			if(a>=1 && b>=2) {
				bw.write(s);
				bw.newLine();
			}
			return;
		}
		for(int i=idx;i<C;i++) {
			if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u')
				dfs(arr, toSelect+1, i+1, L, C, s+arr[i], a+1, b);
			else 
				dfs(arr, toSelect+1, i+1, L, C, s+arr[i], a, b+1);
		}
	}

}
