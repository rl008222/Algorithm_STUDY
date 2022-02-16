package a0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr1[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int arr2[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int month=arr2[0]-arr1[0];
			int ans=-arr1[1]+1;
			arr1[1]=1;
			for(int i=0;i<=month;i++) {
				if(arr1[0]==arr2[0])
					ans+=arr2[1]-arr1[1]+1;
				else if(arr1[0]==1 || arr1[0]==3 || arr1[0]==5 || arr1[0]==7 || arr1[0]==8 || arr1[0]==10 || arr1[0]==12)
					ans+=31-arr1[1]+1;
				else if(arr1[0]==2){
					ans+=28-arr1[1]+1;
				}else {
					ans+=30-arr1[1]+1;
				}
				arr1[1]=1;
				arr1[0]++;
			}
			
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
