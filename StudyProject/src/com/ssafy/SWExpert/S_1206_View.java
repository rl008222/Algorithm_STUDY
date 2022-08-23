package a0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S_1206_View {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			int ans = 0;
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[len];
			for(int i=0;i<len;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=2;i<len-2;i++) {
				if(arr[i]<2) continue;
				int a = Math.max(arr[i-2], arr[i-1]);
				int b = Math.max(arr[i+2], arr[i+1]);
				int temp = Math.max(a, b);
				if(temp>arr[i]) continue;
				ans+=arr[i]-temp;
			}
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
