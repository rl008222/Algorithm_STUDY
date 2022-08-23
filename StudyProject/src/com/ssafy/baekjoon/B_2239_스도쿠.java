package a0406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class B_2239_스도쿠 {
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static List<Point> list;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[9][9];
		list  = new ArrayList<>();
		for(int i=0;i<9;i++) {
			String s=br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j]=s.charAt(j)-'0';
				if(map[i][j]==0) list.add(new Point(i, j));
			}
		}
		solution(0);
		
		bw.flush();
		bw.close();
		br.close();

	}
	static void solution(int cnt) {
		if(list.size()==cnt) {
			//ans=map;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]+"");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int x=list.get(cnt).x;
		int y=list.get(cnt).y;
		for(int i=1;i<=9;i++) {
			if(check(x, y, i)) {
				map[x][y]=i;
				solution(cnt+1);
				map[x][y]=0;
			}
		}
	}
	static boolean check(int x, int y, int val) {
		for(int i=0;i<9;i++) {
			if(map[x][i]==val) return false;
		}
		for(int i=0;i<9;i++) {
			if(map[i][y]==val) return false;
		}
		int r = (x/3) * 3;
        int c = (y/3) * 3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(map[i][j] == val){
                    return false;
                }
            }
        }
		return true;
		
	}
}
