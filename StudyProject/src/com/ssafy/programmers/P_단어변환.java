package a0324;

import java.util.LinkedList;
import java.util.Queue;

public class P_단어변환 {
	public static void main(String[] args) {
		
		String s[] = {"hot", "dot", "dog",
				"lot", "log", "cog"};
		System.out.println(solution("hit", "cog", s)+ "");
		
	}
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean check=false;
        for(String word : words) {
        	if(word.equals(target)) check=true;
        }
        if(!check) return answer;
        answer =bfs(begin, target, words);
        return answer;
    }
	public static class info{
		String s;
		int p;
		
		public info(String s, int p) {
			super();
			this.s = s;
			this.p = p;
		}
		public String getS() {
			return s;
		}
		public int getP() {
			return p;
		}
		
	}
	public static int bfs(String begin, String target, String[] words) {

		Queue<info> q = new LinkedList<>();
		q.offer(new info(begin, 0));
		while(!q.isEmpty()) {
			info in = q.poll();
			String s =in.getS();
			int p = in.getP();
			if(s.equals(target)) return p;
			for(int i=0;i<words.length;i++) {
				if(check(s, words[i])==1)
					q.offer(new info(words[i], p+1));
				
			}
		}
		return 0;
	}
	public static int check(String s, String word) {
		int cnt=0;
		for(int i=0;i<word.length();i++) {
			if(s.charAt(i) != word.charAt(i))
				cnt++;
		}
		return cnt;
	}
}
