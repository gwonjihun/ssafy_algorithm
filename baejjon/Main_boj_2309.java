package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_2309 {
    static int[] arr;    static boolean[] visited;
    static int[] answer = new int[7];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        visited = new boolean[9];
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0,0,0,false);
//        for(int ans : answer){
//            System.out.print(ans+" ");
//        }
    }

    static boolean dfs(int idx, int depth, int sum,boolean flag){
        if(flag){
            return true;
        }
        if(depth==7){

            if(sum== 100 ){
                Arrays.sort(answer);
                for(int ans : answer){
                    System.out.println(ans+" ");
                }
                return true;
            }
            return false;
        }

        for(int i = idx; i<9;i++){
            if(visited[i]) continue;
            answer[depth] = arr[i];
            visited[i] = true;
            flag = dfs(i,depth+1,sum+arr[i],flag);
            visited[i]= false;
        }

        return flag;
    }
}
