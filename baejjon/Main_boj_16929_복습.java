package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_16929_aga {
    static int[] dx = {1,0,-1,0}, dy  = {0,1,0,-1};
    static int N,M;
    static char[][] board;
    static int sx, sy;// 순환의 루트 정보
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                board[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j ++) {
                sx = i;
                sy = j;
//                visited[i][j]= true;
                dfs(i,j,1);
//                visited[i][j]= false;
            }
        }
        System.out.println("No");
    }
    static void dfs(int x,int y, int depth){
        if(depth>=4&&x==sx&& y==sy){
            System.out.println("Yes");
            System.exit(0);
            //중단점 설정
        }

        for(int d= 0 ; d<4;d++){
            int nx = x + dx[d];
            int ny = y +dy[d];
            if(0<=nx&&0<=ny&&nx<N&&ny<M&&!visited[nx][ny]&&board[nx][ny]==board[sx][sy]){
                //격자를 벗어난 경우
                visited[nx][ny]=true;
                dfs(nx,ny,depth+1);
                visited[nx][ny]=false;

            }
        }
    }
}
