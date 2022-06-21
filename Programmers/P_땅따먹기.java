package a0620;

public class P_땅따먹기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}})+"");
	}
	static int solution(int[][] land) {
		int length = land.length;
		for(int i=1;i<length;i++) {
			land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
		}
		
		int max = 0;
		for(int i=0;i<4;i++) {
			max=Math.max(max, land[length-1][i]);
		}
		
		
		
        int answer = max;
        
        return answer;
    }
	
}