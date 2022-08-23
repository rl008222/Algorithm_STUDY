package a0404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j && arr[i][j]==0) arr[i][j]=987654321;
				}
			}
			for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] > arr[i][k] + arr[k][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 987654321)
                        sum += arr[i][j];
                }
                if(ans > sum) ans = sum;
            }
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
