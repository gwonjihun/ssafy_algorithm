package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_11048 {
    static int[][] arr;
    static int[][] dp;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< M ; j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for(int i = 1 ; i < N;i++){
            dp[i][0] = arr[i][0]+dp[i-1][0];
        }
        for(int j = 1 ; j< M; j++){

            dp[0][j] = arr[0][j]+dp[0][j-1];
        }

        for(int i = 1; i< N ; i++){
            for(int j = 1 ; j< M ;j++){
                dp[i][j] = arr[i][j]+ Math.max(Math.max(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
