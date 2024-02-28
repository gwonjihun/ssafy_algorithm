package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_16927 {
    static int N,M,R;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

//        int mx = N;
//        int my = M;
        for(int i = 0 ; i  < N ; i ++ ){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i< Math.min(N,M)/2;i++){
            // i는 회전의 시작 좌표이고
            // mn 은
            rotate(i,R);

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j< M ;j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate(int st,int r){
        //st는 시작점
        //R은 회전 횟수
        int V_mod =  2*(N-2*st) + 2*(M-2-2*st);
        r %= V_mod;

        for(int s= 0 ; s<r;s++){
            int save = map[st][st];
            for(int i = st; i<M-st-1;i++){
                map[st][i]=map[st][i+1];
            }
            for(int i = st;i<N-st-1;i++){
                map[i][M-st-1] = map[i+1][M-st-1];
            }
            for(int i = M-st-1;i>st;i--){
                map[N-st-1][i] = map[N-st-1][i-1];
            }
            for(int i = N-st-1;i>st;i--){
                map[i][st] = map[i-1][st];
            }
            map[st+1][st] = save;
        }
    }
}
