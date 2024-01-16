package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_11053_aga {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr;
        int[] dp;

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i =1; i< N;i++){
            for(int j = 0 ; j< i;j++){
                if(arr[j]<arr[i] && dp[i] <=dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0 ;
        for(int i : dp){
            max = Math.max(i,max);
        }
        System.out.println(max);
    }

}
