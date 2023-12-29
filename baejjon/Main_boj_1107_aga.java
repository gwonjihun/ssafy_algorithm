package Boj;

import javax.swing.text.html.HTML;
import java.io.*;
import java.util.*;

public class Main_boj_1107 {
    static int MinCount = 500_00;
    static int N;
    static int len;
    static int[] arr;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        len = input.length();
        N = Integer.parseInt(input);
        MinCount = Math.abs(N- 100);
        //+-만 가능한 경우의 정답은 이렇게 되는거고
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        if(M >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<M;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(MinCount);
    }

    static void dfs(int depth,int answer){
        if(depth>6) return;
        if(depth >=1){
            if(answer == N){
                MinCount = Math.min(MinCount,len);
            }else{
                MinCount = Math.min(MinCount,Math.abs(answer-N)+depth);
            }
        }

        for(int i = 0 ; i < 10;i++){
//            if(answer== 0 && i == 0) continue;
            boolean flag = false;
            for(int a : arr){
                if(a == i) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            dfs(depth+1,answer*10+i);
        }
    }
}
