package a0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1220_Magnetic {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 0;
			int len = Integer.parseInt(br.readLine());
			int arr[][] = new int[len][len];
			for(int i=0;i<len;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<len;j++)
					arr[i][j]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<len;i++) {
				boolean check=false;
				for(int j=0;j<len;j++) {
					if(arr[j][i]==1) {
						for(int k=j+1;k<len;k++) {
							if(arr[k][i]==2) {
								ans++;
								j=k;
								break;
							}
						}
					}
					if(check) break;
				}
			}
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
