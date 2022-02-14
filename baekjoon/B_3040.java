package a0214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_3040 {
	static int []temp = new int[2];
	static int []ans = new int[2];
	static int []arr = new int[9];
	static int anssum=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			anssum+=arr[i];
		}
		recursive(0, 0);
		for(int i=0;i<9;i++) {
			if(arr[i]==ans[0] || arr[i]==ans[1]) continue;
			else bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	static void recursive(int idx, int start) {
		if(idx==2) {
			anssum-=(temp[0]+temp[1]);
			if(anssum==100) {
				ans[0]=temp[0];
				ans[1]=temp[1];
			}
			anssum+=(temp[0]+temp[1]);
			return;
		}
			
		for(int i=start;i<9;i++) {
			temp[idx]=arr[i];
			recursive(idx+1, i+1);
		}
	}

}
