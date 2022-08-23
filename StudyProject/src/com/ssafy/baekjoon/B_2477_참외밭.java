package a0227;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2477_참외밭 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int w=0, h=0;
		int arr[][] = new int[6][2];
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0]=a;
			arr[i][1]=b;
			switch(a) {
				case 1:
				case 2:
					if(h<b) h=b;
					break;
				case 3:
				case 4:
					if(w<b) w=b;
					break;
			}
		}
		int pi, ni;
		int subw=0, subh=0;
		for(int i=0;i<6;i++) {
			if(i==5) {
				pi=i-1;
				ni=0;
			}else if(i==0) {
				pi=5;
				ni=i+1;
			}else {
				pi=i-1;
				ni=i+1;
			}
			switch(arr[i][0]) {
				case 1:
				case 2:
					if(arr[pi][1]+arr[ni][1]==w) subh= arr[i][1];
					break;
				case 3:
				case 4:
					if(arr[pi][1]+arr[ni][1]==h) subw= arr[i][1];
					break;
			}
		}
		bw.write((h*w - subh*subw)*T + "");
		bw.flush();
		bw.close();
		br.close();

	}
}
