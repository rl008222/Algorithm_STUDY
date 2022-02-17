package a0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_15650 {
	static int arr[];
	static int M, N;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int selected[] = new int[M];
		for(int i=1;i<=N;i++)
			arr[i-1] = i;
		
		combination(0, selected, 0);
		bw.flush();
		bw.close();
		br.close();

	}
	static void combination(int cnt, int selected[], int idx) throws IOException {
		if(cnt==M) {
			for(int i=0;i<cnt;i++) {
				bw.write(selected[i] + " ");
			}
			bw.newLine();
			return;
		}
		for(int i=idx;i<N;i++) {
			selected[cnt]=arr[i];
			combination(cnt+1, selected, i+1);
		}
	}

}
