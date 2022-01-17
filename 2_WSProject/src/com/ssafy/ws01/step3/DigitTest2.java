package com.ssafy.ws01.step3;

public class DigitTest2 {
	public static void main(String[] args) {
		int num=1;
		int blank=0;
		boolean isIncrease = true;
		while(true) {
			if(num==18)
				break;
			for(int j=0; j<blank; ++j) {
				System.out.printf("%3s"," ");	
			}
			for(int j=0; j<5-2*blank; ++j) {
				System.out.printf("%3d",num++);	
			}	
			System.out.println();
			if(isIncrease) {
				++blank;
			}else {
				--blank;
			}
			
			if(blank == 5/2) {
				isIncrease = false;
			}
		}
		
	}
}
