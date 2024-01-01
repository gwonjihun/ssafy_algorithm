package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_boj_9095_dp {
    static int answer;
    public static void main(String[] args) throws Exception{
        int[] dp = new int[11];
        dp[0]= 0; dp[1]=1; dp[2]=2; dp[3]=4;
        for(int i =4; i<11;i++){
            dp[i] = dp[i-2]+dp[i-1]+dp[i-3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
    static void dfs(int sum, int target){
        if(sum==target){
            answer++;
            return;
        }
        for(int i = 1; i <=3;i++){
            if(sum+i<=target){
                dfs(sum+i,target);
            }
        }
    }
}
