package a0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1984 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[10];
			for(int i=0;i<10;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double sum=0;
			for(int i=1;i<9;i++) {
				sum+=arr[i];
			}
			System.out.printf("#%d %d\n", tc, (int)Math.round(sum/8));
		}
		br.close();
		

	}

}
