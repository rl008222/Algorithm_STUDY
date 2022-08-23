package com.ssafy.programmers;

public class P_타겟넘버 {
	public static void main(String[] args) {
		int n[] = {4, 1,2 , 1};
		int q=4;
		System.out.println(solution(n, q));
	}
	static int count;
	static int ans=0;
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        count=numbers.length;
        dfs(0, numbers, target, 0, 0);
        answer=ans;
        return answer;
    }
	public static void dfs(int idx, int[] numbers, int target, int cnt, int sum) {
		if(cnt==count) {
			if(sum==target)
				ans++;
			return;
		}
		dfs(idx+1, numbers, target, cnt+1, sum+numbers[idx]);
		dfs(idx+1, numbers, target, cnt+1, sum-numbers[idx]);
		
	}
}
