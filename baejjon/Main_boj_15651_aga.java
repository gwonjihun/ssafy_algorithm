package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_15651_aga {
    static int[] arr;
    static boolean[] visited;
    static int N,M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
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
        perm(0,0);
        System.out.println(sb);
    }
    static void perm(int idx,int depth){
        if(depth==M){
            for(int a : answer){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = idx;i<N;i++){
//            if(!visited[i]){
//                visited[i] = true;
            answer[depth] = arr[i];
            perm(i,depth+1);
//                visited[i]=false;
//            }
        }
    }
}
