package a0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2839_greedy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if (N == 4 || N == 7) {
			bw.write(-1);
		} else if (N % 5 == 0) {                 // 5 10 15 20 .....
			bw.write(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) {   // 6 8 11 13 16 18....  
			bw.write((N / 5) + 1);
		} else if (N % 5 == 2 || N % 5 == 4) {   // 9 12 14 17 19 ....
			bw.write((N / 5) + 2);
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
