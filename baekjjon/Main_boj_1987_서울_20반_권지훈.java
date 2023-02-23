package baekjjon;

import java.io.*;
import java.util.*;
public class Main_boj_1987_서울_20반_권지훈 {
    static int[][] map;
    static int maxcnt = 0;
    static int R,C;
    static boolean[] visit = new boolean[26];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i = 0 ; i <R;i++){
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(maxcnt);
    }

    static void dfs(int x,int y, int cnt){
        if(visit[map[x][y]]){
            maxcnt = Math.max(maxcnt,cnt);
            return;
        }
        visit[map[x][y]]=true;
        for(int i = 0 ; i < 4; i++){
            int nx = x +dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx <R && 0<= ny && ny < C){
                dfs(nx,ny,cnt+1);
            }
        }
        visit[map[x][y]] =false;
    }
}
