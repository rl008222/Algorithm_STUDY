package a0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int swCnt = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int []sw = new int[swCnt];
		for(int i=0;i<swCnt;i++) {
			sw[i]=Integer.parseInt(st.nextToken());
		}
		int stu = Integer.parseInt(br.readLine());
		for(int i=0;i<stu;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			switch(gender) {
				case 1:
					int temp1=num-1;
					while(temp1<swCnt) {
						if(sw[temp1]==0)
							sw[temp1]=1;
						else
							sw[temp1]=0;
						temp1+=num;
					}
					break;
				case 2:
					int temp2=num-1;
					for(int j=0;;j++) {
						if(temp2-j<0 || temp2+j>=swCnt)
							break;
						
						if(sw[temp2-j]==sw[temp2+j]) {
							if(sw[temp2-j]==0) {
								sw[temp2-j]=1;
								sw[temp2+j]=1;
							}
							else {
								sw[temp2-j]=0;
								sw[temp2+j]=0;
							}
						}
						else {
							break;
						}
					}
					break;
			}
		}
		for(int i=0;i<swCnt;i++) {
			if(i>=19 && (i+1) % 20 == 1)
				sb.append("\n");
			sb.append(sw[i] + " ");
		}
		System.out.print(sb);
	}

}
