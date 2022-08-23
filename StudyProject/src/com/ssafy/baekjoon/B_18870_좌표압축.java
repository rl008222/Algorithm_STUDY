package a0323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B_18870_좌표압축 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		
		int sub[] = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]=i;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int cntArr[] = new int[N];
		int cnt=0;
		cntArr[arr[0][1]]=cnt++;
		
		for(int i=1;i<N;i++) {
			if(arr[i-1][0]==arr[i][0])cnt--;
			cntArr[arr[i][1]]=cnt++;
		}
		for(int n : cntArr)
			bw.write(n+ " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
