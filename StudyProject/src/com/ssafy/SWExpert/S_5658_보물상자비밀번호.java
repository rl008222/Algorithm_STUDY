package a0315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S_5658_보물상자비밀번호 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Queue<Character> q = new LinkedList<>();
			HashSet<String> set = new HashSet<>();
			String s = br.readLine();
			
			for(int i=0;i<N;i++) q.offer(s.charAt(i));
			
			for(int j=0;j<N;j++) {
				String str="";
				for(int i=0;i<N-1;i++) {
					if(i%(N/4)==0 && i!=0) {
						set.add(str);
						str="";
					}
					q.offer(q.peek());
					str+=q.poll();
				}
				str+=q.peek();
				set.add(str);
				/*
				String str="";
				int start=j;
				for(int i=0;i<N;i++) {
					if(start==N) start=0;
					str+=s.charAt(start);
					start++;
					if(str.length()==N/4) {
						set.add(str);
						str="";
					}
				}
				*/
			}
			ArrayList<Integer> list = new ArrayList<>();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				int sum=0;
				int temp=1;
				String str = it.next();
				for(int i=(N/4)-1;i>=0;i--) {
					int num = str.charAt(i)-'0';
					if(num>=10) num-=7;
					sum+=num*temp;
					temp*=16;
				}
				list.add(sum);
		    }
		    
			Collections.sort(list, Collections.reverseOrder());
			bw.write("#" + tc + " " + list.get(K-1));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
