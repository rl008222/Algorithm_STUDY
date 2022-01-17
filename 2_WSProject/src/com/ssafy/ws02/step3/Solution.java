package com.ssafy.ws02.step3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		int T, N;
		Scanner s = new Scanner(System.in);
		T = s.nextInt();
		int max[] = new int[T];

		for (int i = 0; i < T; i++) {
			N = s.nextInt();
			char[][] bg = new char[N][N];
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++)
					bg[j][k] = s.next().charAt(0);

			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++) {
					int ans = 0;
					boolean isPark = false;
					if (bg[j][k] == 'B') {
						if (j+1 < N && bg[j + 1][k] == 'G')
							isPark = true;
						else if (k+1 < N && bg[j][k + 1] == 'G')
							isPark = true;
						else if (j-1 >=0 && bg[j - 1][k] == 'G')
							isPark = true;
						else if (k-1 >=0 && bg[j][k - 1] == 'G')
							isPark = true;
						else if (j+1 < N && k-1 >=0 && bg[j + 1][k - 1] == 'G')
							isPark = true;
						else if (j-1 >=0 && k+1 < N && bg[j - 1][k + 1] == 'G')
							isPark = true;
						else if (j+1 < N && k+1 < N && bg[j + 1][k + 1] == 'G')
							isPark = true;
						else if (j-1 >=0 && k-1 >=0 && bg[j - 1][k - 1] == 'G')
							isPark = true;

						if (isPark == true)
							ans = 2;
						else {
							for (int l = 0; l < N; l++) {
								if (bg[j][l] == 'B')
									ans++;
								if (bg[l][k] == 'B')
									ans++;
							}
							ans--;
						}
						if (max[i] < ans)
							max[i] = ans;
						ans = 0;
					}
				}
		}
		for (int i = 0; i < T; i++)
			System.out.println(max[i]);
	}
}
