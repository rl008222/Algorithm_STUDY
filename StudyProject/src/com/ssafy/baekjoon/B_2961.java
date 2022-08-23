package a0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2961 {
	static int min=Integer.MAX_VALUE;
	static int arr[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr= new int[N][2];
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			arr[tc][0] = Integer.parseInt(st.nextToken());
			arr[tc][1] = Integer.parseInt(st.nextToken());
		}
		recursive(0, 0, 1, 0);
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static void recursive(int i, int cnt, int a, int b) {
		if(cnt>=1) {
			min=Math.min(Math.abs(a-b), min);
		}
		if(i==N) {
			return;
		}
		recursive(i+1, cnt+1, a*arr[i][0], b + arr[i][1]);
		recursive(i+1, cnt, a, b);
	}

}
