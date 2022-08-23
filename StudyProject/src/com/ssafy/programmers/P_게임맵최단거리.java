package com.ssafy.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_게임맵최단거리 {
	public static void main(String[] args) {

		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})+"");
	}
	public static int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
	public static int bfs(int [][]maps) {
		int N = maps.length;
		int M = maps[0].length;
		Queue<pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new pos(N-1, M-1, 1));
		visited[N-1][M-1]=true;
		
		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(visited[nx][ny]) continue;
				if(maps[nx][ny]==0) continue;
				
				if(nx==0 && ny==0) return p.result+1;
				
				visited[nx][ny]=true;
				q.add(new pos(nx, ny, p.result+1));
			}
			
		}
		return -1;
	}
	static class pos{
		int x,y, result;

		public pos(int x, int y, int result) {
			super();
			this.x = x;
			this.y = y;
			this.result = result;
		}
		
	}
}
