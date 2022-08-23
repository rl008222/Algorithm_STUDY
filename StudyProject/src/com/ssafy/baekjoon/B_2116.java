package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_2116 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<=N/2;i++) {
			
		}
		for(int i=N-1;i>=N/2;i++) {
			
		}
		
		
;
	}

}
