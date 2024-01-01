package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_9095_aga {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ;t<T;t++) {
            answer = 0;
            int n = Integer.parseInt(br.readLine());
            dfs(0, n);
            System.out.println(answer);
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
