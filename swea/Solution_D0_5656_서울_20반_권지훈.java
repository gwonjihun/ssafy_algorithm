package swea;

import java.util.*;
import java.io.*;

/*
* 1. 벽돌을 부수는 번호를 선택하는 중복조합
* 2. 상하좌우 벽동을 부수는 함수
* 3. 벽돌이 부셔진뒤 나머지 벽돌이 내려오는 함수
*
* */
public class Solution_D0_5656_서울_20반_권지훈 {
    static int N, W, H,Max_s=0;
    static int[][] arr,map;
    static int[] dup;
    static boolean[][] v;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];
            dup = new int[N];
            for(int i = 0 ; i < H ; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0 ; j<W;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0);
//            down();
            for(int[] a : arr){
                System.out.println(Arrays.toString(a));
            }
            System.out.println(Max_s);
        }

    }
    static void perm(int cnt){
        if(cnt == N){

            map = new int[H][W];
            for(int i = 0 ; i <W;i++){
                for(int j = 0 ; j < H; j++){
                    map[j][i] = arr[j][i];
                }
            }
            int sum = 0 ;
            for(int i = 0 ; i< N ; i++){
                sum += shot(dup[i]);
                down();
            }
                Max_s= Math.max(Max_s,sum);
                return;
        }
        for(int i = 0;i<W;i++){
            dup[cnt] = i;
            perm(cnt+1);
        }
    }

    static int shot(int y){
//        System.out.println(y);
        int cnt = 0;
        for(int x = 0; x<H;x++){
            if(map[x][y] == 0 ) continue;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {x,y});
//            System.out.println(x+ " " + y);
            map[x][y]= 0;
            cnt++;
            while(!q.isEmpty()){
                int[] xy = q.pollFirst();
//                System.out.println(Arrays.toString(xy));
                for(int i=0;i<4;i++){
                    int nx = xy[0];
                    int ny = xy[1];
                    int len = map[nx][ny];
                    for(int d=1;d<len;d++){
                        nx +=dx[i];
                        ny +=dy[i];
                        if(0<=nx && nx<H && 0<= ny && ny<W &&  map[nx][ny]!=0){
                            if( map[nx][ny]>1) {
                                q.addLast(new int[]{nx, ny});
                            }
                            map[xy[0]][xy[1]] = 0;

//                            System.out.println("!@#!@#!@#!@#");
                            cnt++;
                        }
                    }
                }
            }
            break;
        }
        for(int[] a : map){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        return cnt;
    }
    static void down(){
        for(int i = 0;i<W;i++){
            for(int j = H-1; j>0;j--){
                if(map[j][i]!=0) continue;
                for(int k = j-1;k>=0;k--){
                    if(map[k][i]== 0) continue;
                    map[j][i] = map[k][i];
                    map[k][i] = 0 ;
                    break;
                }
            }
        }

        for(int[] a : map){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("!~@#!@#!@#!@#!@#!@#!@#!@#");
    }
}
