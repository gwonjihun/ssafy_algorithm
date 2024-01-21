package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_1697_aga {
    static int N,K;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        cnt = Integer.MAX_VALUE;
        bfs();
        System.out.println(cnt);
    }
    static void bfs(){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N,0});
        visited[N] = true;
        while(!q.isEmpty()){
            int[] x = q.poll();
            visited[x[0]] = true;
            if(x[0] == K){
                cnt = Math.min(cnt, x[1]);
                return ;
            }
            int nx = 2*x[0];

            if(0<=nx&& nx<=100000 && !visited[nx]){
                q.add(new int[] {nx, x[1]+1});
            }
            nx = x[0]+1;


            if(0<=nx&& nx<=100000&& !visited[nx]){
                q.add(new int[] {nx, x[1]+1});
            }
            nx = x[0]-1;

            if(0<=nx&& nx<=100000&& !visited[nx]){
                q.add(new int[] {nx, x[1]+1});}
        }
    }
}
