package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_15650_aga {
    static int[] arr;
    static boolean[] visited;
    static int N,M;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];
        for(int i = 0 ; i < N;i++){
            arr[i] = i+1;
        }
        comb(0,0);
    }
    static void comb(int idx, int depth){
        if(depth==M){
            for(int a : answer){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i = idx;i<N;i++){
//            if(!visited[i]){
//                visited[i] = true;
            answer[depth] = arr[i];
            comb(i+1,depth+1);
//                visited[i]=false;
//            }
        }
    }
}
