package CodeTree;

import java.io.*;
import java.util.*;
/*
* 1. 4*4격자는 고정이다.
* 2. m 개의 몬스터 1개의 팩맨
* 몬스터는 8개의 방향을 가진다.
* 복제 시도, 몬스터 이동, 팩맨 이동
* 시체 소멸, 복제품 완성
*
* */
public class Main_CodeTree_팩맨_24_04 {

    static int m,t,n=4;
    static int[][][] board;//여기서 몬스터들의 위치를 관리해주고..?
    static int[][][] egg;// value : 몬스터가 가지는 방향을 의미// [][]에 [i]방향에 있는 녀석들의 갯수를 의미한다.
    static int[][] died;//시제를 의미하는 것이고. 죽으면 2로 셋팅해준다.
    static int[][] sums;// board[x][y]가 가지는 배열의 합을 구하는 곳.
    static int px, py;//팩맨의 정보


    static int[] pdx = {-1,0,1,0}, pdy= {0,-1,0,1};
    static int[] dx = {-1,-1,0,1,1,1,0,-1} , dy={0,-1,-1,-1,0,1,1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][n][8];//[x,y,dir]의 개숫를 의미한다.
        egg = new int[n][n][8];
        died = new int[n][n];
        sums = new int[n][n];
        st = new StringTokenizer(br.readLine());
        px = Integer.parseInt(st.nextToken()) - 1;
        py = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mx = Integer.parseInt(st.nextToken()) - 1;
            int my = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            board[mx][my][d]++;
            sums[mx][my]++;
        }
        while(t-->0){

            copy();
//            System.out.println("step 1 finish");
//            printers();
            moveM();
//            System.out.println("step 2 finish");
//            printers();
            moveP();
//            System.out.println("step 3 finish");
//            printers();
            diedown();// 시체의 값을 감소시켜준다.
//            System.out.println("step 4 finish");
//            printers();
            copyfinish();//
//            System.out.println("step 5 finish");
//            printers();

        }
        result();

    }

    static void moveM(){
        int[][][] temp = new int[n][n][8];
        int[][] sumT = new int[n][n];
        //여기서 x,y마다 각각 있는 녀석들을 가지고 순회해줄 예정이다.
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n ;j++){
                if(sums[i][j]<=0) continue;
                for(int d = 0 ; d<8;d++){
                    if (board[i][j][d]>0){
                        int cx = i;
                        int cy = j;
                        int curD = d;
//                        System.out.println("nx : " + cx + "ny : " + cy + "dir : " + curD);

                        for(int dd = 0 ; dd <8; dd++){
                            int dir = (d+dd+8)%8;
                            int nx = cx + dx[dir];
                            int ny = cy + dy[dir];
                            if(inRange(nx,ny)&&died[nx][ny]==0&&!(px==nx&&py==ny)){
                                cx = nx;
                                cy = ny;
                                curD = dir;
//                                System.out.println("nx : " + cx + "ny : " + cy + "dir : " + curD);
//                                System.out.println("++_+_+_+_+_+_+");
                                break;
                            }
                        }
                        //그렇게된다면 여기서 i,j,d의 다음 목적지가 결론적으론 정해짐에 따라
                        //다음 위치에 저장하기 위해서
                        //temp에 저장, sumT에 저장해줘야한다
                        temp[cx][cy][curD]+=board[i][j][d];
                        sumT[cx][cy] += board[i][j][d];
                    }
                }
            }

        }
        board = temp;
        sums =sumT;
    }
    static void printers(){
        //
        System.out.println("팩맨 정보 " + px +  " , " + py );
        System.out.println("---------암튼 각 위치마다의 몬스터들의 합 print --------");
        for(int i = 0 ; i<4;i++){
            System.out.println(Arrays.toString(sums[i]));
        }
        System.out.println("_____위치마다 복사되는 객체들의 정보 ________________");
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int d=  0 ; d<8;d++){
                    System.out.print(egg[i][j][d]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("_________시체 정보____________");
        for(int i = 0 ; i < n; i++){
            System.out.println(Arrays.toString(died[i]));
        }

    }
    static void moveP(){
        //여기선 이제부터 모든 방향을 탐색하고
        //모든 방향에서 얻은 최선을 구해야한다 그러기 위해선
        //px로부터 이동되는 위치를 찾아야한다.
        int[] dirs = new int[3];
        //dirs 움직임을 위한 거리들
        int maxEat = -1;//최대한 많이 먹어야한다.
        for(int d1 = 0; d1<4 ; d1++){
            int x1 = px+pdx[d1];
            int y1 = py+pdy[d1];
            if(!inRange(x1,y1)) continue;
            int cnt =0;

            for(int d2 = 0; d2<4 ; d2++){
                int x2 = x1+pdx[d2];
                int y2 = y1+pdy[d2];
                if(!inRange(x2,y2)) continue;
                for(int d3 = 0; d3<4 ; d3++){
                    int x3 = x2+pdx[d3];
                    int y3 = y2+pdy[d3];
                    if(!inRange(x3,y3)) {
                        continue;
                    }

                    cnt = sums[x1][y1] + sums[x2][y2]+ (x1==x3&&y1==y3 ? 0 : sums[x3][y3]);
//                    System.out.println("cnt : " + cnt + "  MaxCnt"  + " " + maxEat);
                    if(cnt>maxEat){
                        dirs = new int[] {d1,d2,d3};
                        maxEat = cnt;
                    }
                }
            }
        }
        //여기서 실제 팩맨을 움직여주면서 팩맨이 이동한 위치들에서 죽으면
        //죽여주고 sums도 갱신채워야한다.
//        System.out.println(Arrays.toString(dirs));
        for(int i = 0 ; i< 3; i++){
            px +=pdx[dirs[i]];
            py +=pdy[dirs[i]];

            if(sums[px][py]>0){
                died[px][py]=3;
                sums[px][py]=0;
                board[px][py] = new int[8];
            }

//            System.out.println();
        }
//        System.out.println("먼저 몬스터들의 현황을 확인하고");
//        for (int i = 0 ;  i <4 ; i++ ) System.out.println(Arrays.toString(sums[i]));
//        System.out.println("여기서부턴 died의 현황을 보여준다");
//        for (int i = 0 ;  i <4 ; i++ ) System.out.println(Arrays.toString(died[i]));

    }


    static boolean inRange(int x, int y){
        return 0<=x && x< n && 0<= y && y<n;
    }


    static void result(){
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans+=sums[i][j];
            }
        }
        System.out.println(ans);
    }

    static void copyfinish(){
        for(int i =0 ; i<n;i++){
            for(int j = 0 ; j < n ; j++){
                for(int d = 0 ; d<8;d++){
                    board[i][j][d] += egg[i][j][d];
                    sums[i][j] += egg[i][j][d];
                }
            }
        }
    }

    static void copy(){
        egg = new int[n][n][8];
        for(int i =0 ; i<n;i++){
            for(int j = 0 ; j < n ; j++){
                for(int d = 0 ; d<8;d++){
                    egg[i][j][d] = board[i][j][d];
                }
            }
        }
    }
    static void diedown(){
        for(int i =0 ; i<n;i++){
            for(int j = 0 ; j < n ; j++){
                if(died[i][j]>0) died[i][j]-=1;
            }
        }
    }
}
