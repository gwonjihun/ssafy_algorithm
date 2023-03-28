package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_21610_서울 {
    static class cloud{
        int x;
        int y;
        cloud(int x, int y ){
            this.x =x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1} , dy = {0,-1,-1,0,1,1,1,0,-1};
    // ??각선 체크?�� 2?�� 배수�? 체크?��?��.
    static int[][] map;
    static boolean[][] v; // 구름?�� ?��?��?�� �??�� 체크
    static int N, M ; // N?? �??��?�� ?���? M?? 명령?�� �??��
    static Deque<cloud> q; // 구름 ???�� 공간

    static Deque<int[]> copymagic; // 구름 ???�� 공간
    static int[][] cmds;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        q = new ArrayDeque<>();
        copymagic = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N][N];

        M = Integer.parseInt(st.nextToken());

        cmds = new int[M][2]; // 0?? 방향 1?? ?��?�� 거리

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 바구?�� 초기 ?��?��?�� ?��?��

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine()," ");
            cmds[i][0] = Integer.parseInt(st.nextToken());
            cmds[i][1] = Integer.parseInt(st.nextToken());
        }//명령?��?�� 복사

        q.addLast(new cloud(N-1,0));
        q.addLast(new cloud(N-1,1));
        q.addLast(new cloud(N-2,0));
        q.addLast(new cloud(N-2,1));
        // 초기 구름 ?��?��
        for(int m = 0 ; m < M ; m++){
            while(!q.isEmpty()){
                cloud cur = q.pollFirst();
                int nx = (N+ cur.x+ dx[cmds[m][0]]*(cmds[m][1]%N))%N;
                int ny = (N+ cur.y+ dy[cmds[m][0]]*(cmds[m][1]%N))%N;

                map[nx][ny] +=1;
                copymagic.add(new int[] {nx,ny});
                v[nx][ny]=true;
            }
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------비내리기 ?���? ?��---------");
            while(!copymagic.isEmpty()){
                int[] cur = copymagic.pollLast();
                for(int i= 2;i<=8;i+=2){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(0<=nx && nx< N && 0<=ny && ny < N && map[nx][ny]>=1){
                        map[cur[0]][cur[1]] +=1;
                    }
                }
            }
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------물복?�� ?��---------");
//            System.out.print("?��?�� ?�� 구름 리스?�� : ");

            for(int i = 0 ; i<N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!v[i][j] && map[i][j]>=2){
                        q.addLast(new cloud(i,j));
                        map[i][j]-=2;
//                        System.out.print(i + " " + j + " | ");
                    }
                }
            }
//            System.out.println();
//            for(int[] a : map){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("---------a마�?�? ?���? ?��---------");
            v= new boolean[N][N];
        }
//        for(int[] a : map){
//            System.out.println(Arrays.toString(a));
//        }
        int cnt = 0 ;
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j < N ; j++) {
            cnt += map[i][j];
            }
        }
        System.out.println(cnt);
    }
}
