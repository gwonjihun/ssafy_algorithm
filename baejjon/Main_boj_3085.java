package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_3085 {
    static int N;
    static int[] dx = {0,1}, dy = {1,0};
    static int Max = Integer.MIN_VALUE;
    static char[][] arr;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0 ; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }
        for(int type = 0 ; type<2; type++){
            for(int x = 0 ; x<N; x++){
                for(int y = 0; y< N ; y++){
                    int nx = x+dx[type];
                    int ny = y+dy[type];
                    if(0>nx||nx>=N||0>ny||ny>=N){
//                        System.out.println(nx + " " + ny);

                        continue;
                    }

                    swap(x,y,nx,ny);
                    Max = Math.max(Max,findCandy());

                    swap(x,y,nx,ny);
                }
            }
        }
        System.out.println(Max);
    }
    static int findCandy(){
        int temp =-1;
        for(int i = 0 ; i < N;i++){
            int count = 1;
            char[] tempArr = arr[i];
            char tar = tempArr[0];
            for(int j = 1; j<N;j++){

                if(tar==tempArr[j]){
                    count++;
                    temp= Math.max(count,temp);
                }else{
                    temp= Math.max(count,temp);
                    tar = tempArr[j];
                    count=1;
                }
            }
            //가로를 먼저 조사한다.
            tempArr = new char[N];
            for(int y = 0 ; y < N ; y++){
                tempArr[y] = arr[y][i];
            }
            count = 1;
            tar = tempArr[0];
            for(int j = 1; j<N;j++){

                if(tar==tempArr[j]){
                    ++count;
                    temp= Math.max(count,temp);
                }else{
                    temp= Math.max(count,temp);
                    tar = tempArr[j];
                    count=1;
                }
            }

            if(temp == N ){
                return N;
            }
        }
        // type : 0은 가로 1은 세로로 동작하게 한다./
        // 이건 그냥 dx,dy를 설정해서하면될꺼같은데?
        return temp;
    }
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

}
