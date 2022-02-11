package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int [][]map = new int[1001][1001];
		int num=0;
		for(int n=0;n<N;n++) {
			num++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int i=y;i<y+h;i++) {
				for(int j=x;j<w+x;j++) {
					if(i<0 || j <0 || i>1000 || j>1000) 
						break;
					map[i][j]=num;
					
				}
			}
		}
		for(int n=0;n<N;n++) {
			int size=0;
			for(int i=0;i<1001;i++) {
				for(int j=0;j<1001;j++) {
					if(map[i][j]==n+1) size++;
				}
			}
			bw.write(size + "");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
