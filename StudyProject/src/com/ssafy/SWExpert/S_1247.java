package a0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;
 
public class S_1247 {
    static int N;
    static int ans=Integer.MAX_VALUE;
    static int cx, cy;
    static int hx, hy;
    static int arr[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            arr=new int[N][2];
            ans=Integer.MAX_VALUE;
            boolean check[] = new boolean[N];
            int selected[][] = new int[N][2];
            for(int i=0;i<N;i++) {
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());
            }
            dfs(0, selected, check);
             
            bw.write("#" + tc + " " + ans);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
 
    }
    static void dfs(int cnt, int selected[][], boolean check[]) {
        if(cnt==N) {
            int dist = 0;
            dist+=Math.abs(cx-selected[0][0]) + Math.abs(cy-selected[0][1]);
            for(int i=1;i<N;i++) {
                dist +=  Math.abs(selected[i][0]-selected[i-1][0]) + Math.abs(selected[i][1]-selected[i-1][1]);
            }
            dist += Math.abs(hx-selected[N-1][0]) + Math.abs(hy-selected[N-1][1]);
            ans = Math.min(dist, ans);
            return;
        }
        for(int i=0;i<N;i++) {
            if(!check[i]) {
                check[i]=true;
                selected[cnt][0]=arr[i][0];
                selected[cnt][1]=arr[i][1];
                dfs(cnt+1,selected, check);
                check[i]=false;
            }
        }
    }
 
}