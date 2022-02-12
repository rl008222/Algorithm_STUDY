package a0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int [][]map = new int[9][9];
			for(int i=0;i<9;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			
			}
			int ans=1;
			for(int i=0;i<9;i++) {
				int arr1[] = new int[9];
				int arr2[] = new int[9];
				for(int j=0;j<9;j++) {
					arr1[map[i][j]-1]++;
					arr2[map[j][i]-1]++;
				}
				for(int j=0;j<9;j++) {
					if(arr1[j]>1 || arr2[j]>1) {
						ans=0;
						break;
					}
				}
				if(ans==0) break;
			}
			if(ans==1) {
				for(int i=0;i<9;i++) {
					for(int j=0;j<9;j++) {
						int []arr3 = new int[9];
						if(i%3==0 && j%3==0) {
							for(int l=i;l<i+3;l++) {
								for(int k=i;k<i+3;k++) {
									arr3[map[l][k]-1]++;
								}
							}
							for(int l=0;l<9;l++) {
								if(arr3[l]>1) {
									ans=0;
									break;
								}
							}
						}
						if(ans==0) break;
					}
					if(ans==0) break;
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
