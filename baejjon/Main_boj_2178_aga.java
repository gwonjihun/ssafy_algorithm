package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_boj_2178_aga {
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int[][] cnt;
    static boolean[][] visited;
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        cnt = new int[N][M];
        for(int i = 0 ; i < N;i++){
            String str = br.readLine();
            for(int j= 0 ; j< M ; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0,0);
        System.out.println(cnt[N-1][M-1]);

    }

    static void bfs(int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        cnt[x][y]=1;
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int sx = cur[0];
            int sy = cur[1];
            for(int d = 0 ; d<4;d++){
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                if(0<=nx && nx <N && 0<= ny && ny<M && !visited[nx][ny] && map[nx][ny]==1){
                    cnt[nx][ny] = cnt[sx][sy]+1;
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }

    }
}
