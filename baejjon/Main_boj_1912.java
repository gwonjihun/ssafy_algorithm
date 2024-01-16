package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_1912 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp =  new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i = 1; i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }
        int max = Integer.MIN_VALUE ;
        for(int a : dp){
            max = Math.max(max,a);
        }
        System.out.println(max);
    }

}
