package a0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_3109 {
	static int dx[] = {-1, 0, 1};
	static int dy[] = {1, 1, 1};
	static char map[][];
	static boolean check[][];
	static int R;
	static int C;
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for(int i=0;i<R;i++) {
			if(dfs(i, 0)) cnt++;
		}
		
		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
	static boolean dfs(int x, int y) {
		if(y==C-1) return true;
		for(int i=0;i<3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			if(!check[nx][ny] && map[nx][ny]=='.') {
				check[nx][ny]=true;
				if(dfs(nx, ny)) return true;
			}
		}
		return false;
	}

}
