package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_18290 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx= {0,0,1,-1}, dy = {1,-1,0,0};
    static int N,M,K;
    static int answer = Integer.MIN_VALUE;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0,0,0);
        System.out.println(answer);

    }
    static void comb(int sx,int sy,int depth, int sum){
        if(depth==K){
//            System.out.println("SUM : "+ sum);

            answer= Math.max(sum,answer);
//            System.out.println(answer);
            return;
        }

        for(int x= sx; x<N;x++){
            for(int y = sy ; y<M;y++){
                if(visited[x][y]) continue;

                if(check(x,y)){
                visited[x][y] = true;
//                    System.out.println(x+" " + y);
                comb(sx,sy,depth+1,sum+arr[x][y]);
                visited[x][y] = false;
                }
            }
        }
    }
    static boolean check(int x, int y){
        boolean flag = true;
        for(int d = 0 ; d<4;d++){
            int nx = x +dx[d];
            int ny = y + dy[d];
            if(0<=nx&&nx<N&&0<=ny&&ny<M&&visited[nx][ny]){
                flag=false;
            }
        }

        return flag;

    }
}

