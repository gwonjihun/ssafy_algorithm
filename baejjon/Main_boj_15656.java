package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_15656 {
    static int[] arr;
    static int N,M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0);
        System.out.println(sb);
    }
    static void perm(int depth){
        if(depth==M){
            for(int a : answer){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0;i<N;i++){
            answer[depth] = arr[i];
            perm(depth+1);
//                visited[i]=false;
//            }
        }
    }
}
