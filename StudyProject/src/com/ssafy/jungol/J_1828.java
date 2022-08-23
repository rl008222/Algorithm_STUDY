package a0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J_1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		
		int cnt=0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++) {
			if(max<arr[i][0]) {
				max =arr[i][1];
				cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();

	}

}
