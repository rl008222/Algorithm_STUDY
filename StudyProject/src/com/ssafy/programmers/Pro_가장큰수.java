package a0311;

import java.util.Arrays;
import java.util.Comparator;

public class Pro_가장큰수 {

	public static void main(String[] args) {
		int []a = {3, 30, 34, 5, 9};
		System.out.println(solution(a));
	}

	private static String solution(int[] a) {
		String[] s = new String[a.length];
		for(int i=0;i<a.length;i++) {
			s[i]=a[i]+"";
		}
		 String answer = "";
		Arrays.sort(s, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return ((o2+o1).compareTo(o1+o2));
			}
		});
		if(s[0].equals("0"))
			return "0";
		for(String b : s) {
			answer+=b;
		}
		 return answer;
	}

}
