package a0216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_1992 {
	static String s="";
	static char arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				arr[i]=str.toCharArray();
			}
		}
		
		recursive(N, 0, 0, N, N);
		bw.write(s);
		
		bw.flush();
		bw.close();
		br.close();

	}
	static void recursive(int n, int x, int y, int p, int q) {
		n/=2;
		boolean check= false;
		int num= arr[x][y];
		for(int i=x;i<p;i++) {
			for(int j=y;j<q;j++) {
				check = num!=arr[i][j]?true:false;
				if(check) break;
			}
			if(check) break;
		}
		if(check) s+="(";
		else {
			s = arr[x][y]=='0'?s+"0":s+"1";
			return;
		}
		
		recursive(n, x, y, x+n, y+n);			//왼쪽 위
		recursive(n, x, y+n, x+n, y+2*n);		//오른쪽 위	
		recursive(n, x+n, y, x+2*n, y+n);		//왼쪽 아래
		recursive(n, x+n, y+n, x+2*n, y+2*n);	//오른쪽 아래
		
		s+=")";
		
	}

}
