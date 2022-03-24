package a0324;

public class P_네트워크 {
	public static void main(String[] args) {
		int c[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(3, c));
	}
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0;i<n;i++) {
        	if(computers[i][i]==1 && dfs(i, computers))
        		answer++;
        }
        return answer;
    }
	public static boolean dfs(int i, int [][]computers) {
		if(computers[i][i]==0) return false;
		computers[i][i]=0;
		for(int j=0;j<computers.length;j++) {
			if(computers[i][j]==1) dfs(j, computers);
		}
		return true;
	}
	
	
}
