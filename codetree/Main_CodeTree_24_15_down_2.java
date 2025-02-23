package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_24_15_down_2 {

    /*
    * 1. 2025-02-23 13:51 start
    * 2. 2025-02-23 end
    * 접근 법
    * 빨간 사탕 rdx,rdy, bdx,bdy를 기반으로 방문처리를 해준다
    * 만약 동일하게 열, 행에 있는 경우에는
    * 1, 위아래인 경우에 도착지점과 가장 가까운 녀석이 해당 좌표로 변경된다
    * 2.
    * */
    static class States{
        int rdx, rdy, bdx, bdy, depth;

        public States(int rdx, int rdy, int bdx, int bdy, int depth) {
            this.rdx = rdx;
            this.rdy = rdy;
            this.bdx = bdx;
            this.bdy = bdy;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "States{" +
                    "rdx=" + rdx +
                    ", rdy=" + rdy +
                    ", bdx=" + bdx +
                    ", bdy=" + bdy +
                    ", depth=" + depth +
                    '}';
        }
    }
    static int N,M;
    static char[][] board;
    static int cnt=0;
    static boolean[][][][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        visited = new boolean[N][M][N][M];


        int rix = 0 , riy = 0 , bix = 0 , biy= 0;


        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j]=='B'){
                    bix = i;
                    biy = j;
                }
                if(board[i][j]=='R'){
                    rix = i;
                    riy = j;
                }
            }
        }
        System.out.println(bfs(rix,riy,bix,biy));

    }

    static int bfs(int rix, int riy, int bix, int biy){
//        System.out.println(rix+ " " + riy + " " + bix + " " +biy);
        Queue<States> q = new ArrayDeque<>();
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        q.offer(new States(rix,riy,bix,biy,0));
        visited[rix][riy][bix][biy] = true;

        while (!q.isEmpty()){
            States cur = q.poll();
//            System.out.println("______________________");
//            System.out.println(cur);
            int rcx = cur.rdx, rcy =cur.rdy, bcx=cur.bdx, bcy = cur.bdy, dep = cur.depth;

            if(dep > 9 ){
                break;
            }

            for(int d= 0 ; d< 4; d++){
                int rnx = rcx, rny = rcy, bnx = bcx, bny = bcy;

                while(board[rnx+dx[d]][rny+dy[d]] != '#' && board[rnx+dx[d]][rny+dy[d]] != 'O'){
                    rnx += dx[d];
                    rny += dy[d];
                }

                while(board[bnx+dx[d]][bny+dy[d]] != '#' && board[bnx+dx[d]][bny+dy[d]] != 'O'){
                    bnx += dx[d];
                    bny += dy[d];

                }


                if(board[bnx+dx[d]][bny+dy[d]] == 'O'){
                    continue;
                }
                if(board[rnx+dx[d]][rny+dy[d]] == 'O'){
                    return dep+1;
                }

                if(rnx==bnx && rny==bny){
                    int rdist = Math.abs(rnx-rcx) + Math.abs(rny-rcy);
                    int bdist = Math.abs(bnx-bcx) + Math.abs(bny-bcy);

                    if(rdist > bdist){
                        rnx -= dx[d];
                        rny -= dy[d];
                    }else{
                        bnx -= dx[d];
                        bny -= dy[d];
                    }
                }

                if(!visited[rnx][rny][bnx][bny]){
                    visited[rnx][rny][bnx][bny] = true;
                    States a = new States(rnx,rny,bnx,bny,dep+1);
                    q.add(new States(rnx,rny,bnx,bny,dep+1));
//                    System.out.println(a);
//                    System.out.println("______________________");
                }
            }
//            System.out.println("==============================");
        }

        return -1;
    }

}
