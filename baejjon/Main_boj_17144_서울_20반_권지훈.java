package gwonjihun.baejjon;

import java.util.*;
import java.io.*;
public class Main_boj_17144_서울_20반_권지훈 {
    static int N, M, T, up= -1;
    static int[][] arr;
    static int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1 && up == -1) {
                    up = i;
                }
            }
        }
        for (int i = 0; i < T; i++) {
            spread();

            cleanup(up);
            cleandown(up + 1);


        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != -1) sum += arr[i][j];
            }
        }
//        for (int[] a : arr)
//        {
//            for(int s : a){
//                System.out.print(s+" ");
//            }
//            System.out.println();
//        }
        System.out.println(sum);
    }

    static void spread(){
        int[][] temp = new int[N][M];

        for(int i = 0 ; i<N;i++){
            for(int j= 0 ; j<M; j++){
                int cnt = 0;
                if(arr[i][j]> 0 ){
                    for(int d = 0 ; d <4;d++){
                        int nx = i+dx[d], ny = j + dy[d];
                        if( 0<=nx && nx < N && 0<= ny && ny <M && arr[nx][ny]!=-1){
                            cnt++;
                            temp[nx][ny] += (int)arr[i][j]/5;
                        }
                    }

                    temp[i][j] += (int)(arr[i][j]-((int)(arr[i][j]/5)*cnt));
                }
            }
        }
        for(int i = 0 ; i<N;i++){
            for(int j= 0 ; j<M; j++){
                if(arr[i][j]!=-1) arr[i][j] = temp[i][j];
            }
        }
    }

    static void cleanup(int x){
        int temp = 0 ;
        for(int i = M-1;i>=1;i--){
            if(i == 1){arr[x][i] = 0; continue;}
            if(i == M-1) {
                temp = arr[x][i]; // ?���? ???��
            }
            arr[x][i] = arr[x][i-1];
        }
        int temp_e = arr[0][M-1];
        for(int i=0;i<=x-1;i++){
            arr[i][M-1]= arr[i+1][M-1];
        }
        arr[x-1][M-1] = temp;

        temp = arr[0][0];
        for(int i = 0; i <M-2;i++){
            arr[0][i] = arr[0][i+1];
        }
        arr[0][M-2] = temp_e;

        for(int i = x-1;i>=1;i--){
            if(i == 1 ) {arr[i][0] = temp; continue;}
            arr[i][0]= arr[i-1][0];
        }
    }
    static void cleandown(int x){
        int temp = 0 ;
        for(int i = M-1;i>=1;i--){
            if(i == 1){arr[x][i] = 0; continue;}
            if(i == M-1) {
                temp = arr[x][i]; // ?���? ???��
            }
            arr[x][i] = arr[x][i-1];
        }
        int temp_e = arr[N-1][M-1];
        for(int i=N-1;i>=x+1;i--){
            arr[i][M-1]= arr[i-1][M-1];
        }
        arr[x+1][M-1] = temp;

        temp = arr[N-1][0];
//        System.out.println(temp);
        for(int i = 0; i <M-2;i++){
            arr[N-1][i] = arr[N-1][i+1];
        }
        arr[N-1][M-2] = temp_e;


        for(int i = x+1;i<N-2;i++){
            arr[i][0]= arr[i+1][0];
        }
        arr[N-2][0] = temp;


    }
}
