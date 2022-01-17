package com.ssafy.hw02;

import java.io.FileInputStream;
import java.util.Scanner;

public class BmiCalculator {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			if(!sc.hasNext())
				break;
			String input = sc.nextLine();
			String[]arr = input.split(",");
			
			int age = Integer.parseInt(arr[0]);
			int weight = Integer.parseInt(arr[1]);
			int height = Integer.parseInt(arr[2]);
			
			if(age<2)
				continue;
			double bmi = weight/Math.pow((double)height/100, 2);

			System.out.print("BMI 지수는 " + bmi + "로 ");
			if(bmi>30) System.out.println("<고도비만>입니다.");
			else if(bmi>25) System.out.println("<비만>입니다.");
			else if(bmi>23) System.out.println("<과체중>입니다.");
			else if(bmi>18.5) System.out.println("<정상>입니다.");
			else System.out.println("<저체중>입니다.");
		}
		
	}
}
