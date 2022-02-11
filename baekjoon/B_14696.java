package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			char win='D';
			int A[] = new int[5];
			int B[] = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int An = Integer.parseInt(st.nextToken());
			for(int j=0;j<An;j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int Bn = Integer.parseInt(st.nextToken());
			for(int j=0;j<Bn;j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			for(int j=4;j>0;j--) {
				if(A[j]>B[j]) {
					win='A'; break;
				}
				else if(A[j]<B[j]) {
					win = 'B'; break;
				}
			}	
			bw.write(win + "");
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
