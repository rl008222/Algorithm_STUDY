package a0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		String s="";
		String ans="";
		for(int i=1;i<=N;i++) {
			int cnt=2;
			s="";
			s +=N + " " + i + " ";
			int tempN=N;
			int tempi=i;
			int temp = tempN-tempi;
			while(temp>=0) {
				s +=temp + " ";
				tempN=tempi;
				tempi=temp;
				temp=tempN-tempi;
				cnt++;
			}
			
			if(max<cnt) {
				max = cnt;
				ans = s;
			}
			max = Math.max(max, cnt);
		}
		bw.write(max + "\n" + ans);
		bw.flush();
		bw.close();
		br.close();
	}

}
