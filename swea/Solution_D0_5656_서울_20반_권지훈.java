package gwonjihun.swea;

import java.sql.Array;
import java.util.*;
import java.io.*;

/*
* 1. 벽돌을 부수는 번호를 선택하는 중복조합
* 2. 상하좌우 벽동을 부수는 함수
* 3. 벽돌이 부셔진뒤 나머지 벽돌이 내려오는 함수
*
* */
public class Solution_D0_5656_서울_20반_권지훈 {
    static int N, W, H,Max_s=Integer.MAX_VALUE;
    static int[][] arr,map;
    static int[] dup;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++){
            Max_s=Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];
            map = new int[H][W];
            dup = new int[N];
            for(int i = 0 ; i < H ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j<W;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // perm에다가 기존 딥카피하나 구해서 보내주고
            perm(0);
//            down();
//            for(int[] a : arr){
//                System.out.println(Arrays.toString(a));
//            }
            System.out.println("#"+t+" "+Max_s);
        }

    }
    static void perm(int cnt){
        if(cnt == N ){
            for(int i=0;i< H;i++){
                for(int j = 0 ; j<W;j++){
                    map[i][j] = arr[i][j];
                }
            }

            for(int i = 0 ; i < N ; i++){
//                System.out.println("********"+dup[i]+"***************");
                shoot(dup[i]);
//                for(int[] a : map){
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println("!@#!@#!@#!@#!!!!!!!!!!!!!!!!!!!!");
                down();
//                for(int[] a : map){
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
            }
//            System.out.println("여기서 한번의 perm cnt-n 끝");
            int sum = 0 ;
            for(int i=0;i< H;i++){
                for(int j = 0 ; j<W;j++){
                    if(map[i][j]!= 0) sum++;
                }
            }
            Max_s = Math.min(Max_s,sum);
            return;
        }
        for(int i = 0 ; i< W;i++){
            dup[cnt] = i;
            perm(cnt+1);
        }
    }
    static void shoot(int y){
        int x=H-1;
        for(int i = 0;i<H;i++){
            if(map[i][y]!=0){
                x = i;
                break;
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[] {x,y,map[x][y]});
        map[x][y]= 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int len = cur[2];

            for(int d = 0; d<4;d++){
                int nx = cur[0]; int ny = cur[1];

                for(int i = 1; i<len;i++){
                    nx += dx[d];
                    ny += dy[d];
                    if(nx <0 || nx>=H || ny<0|| ny>=W || map[nx][ny]==0) continue;
                    if(map[nx][ny]!=0){
                        q.addLast(new int[] {nx,ny,map[nx][ny]});

                        map[nx][ny]=0;
                    }
                }
            }
        }
    }
    static void down(){
        for(int i = 0 ; i<W;i++){
            for(int j = H-1; j>0;j--){
                if(map[j][i]!=0) continue;
                for(int k = j-1;k>=0;k--){
                    if(map[k][i]!=0){
                        map[j][i]= map[k][i];
                        map[k][i] = 0;
                        break;
                    }
                }
            }
        }
    }
}
