package com.ssafy.hw04;

import java.util.Scanner;

public class ArrayProcessBmi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double [][]stu= {{21, 53.2, 1.673}, 
				{35, 90.3, 1.781}, 
				{28, 70.7, 1.653}, 
				{25, 75.1, 1.811}, 
				{31, 62.0, 1.532}};
		double []sum = new double[3];
		System.out.println("idx     만 나이            몸무게(kg)   키(m)");
		for(int i=0;i<5;i++) {
			System.out.printf("학원생%d   %.1f      %.1f       %.3f\n", i+1, stu[i][0], stu[i][1], stu[i][2]);
			sum[0]+=stu[i][0];
			sum[1]+=stu[i][1];
			sum[2]+=stu[i][2];
		}
		System.out.printf("평균            %.3f    %.3f     %.3f\n", sum[0]/5, sum[1]/5, sum[2]/5);
	}
}
