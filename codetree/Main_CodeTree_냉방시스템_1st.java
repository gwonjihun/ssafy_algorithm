package CodeTree;

import java.io.*;
import java.util.*;

/*
* 온도를 관리하는 2차원 배열
* 벽을 관리하는 배열
* 에어컨 위치를 관리해야함..!
* 사무실의 위치를 관리하는 리스트
* 2,3,4,5가 에어컨이라했으닌깐 그냥
* 1,2,3,4가 되는게 좋을듯해
* */
public class Main_CodeTree_냉방시스템_1st {

    static int n,m,k;
    static int[][] roomT;// 온도를 관리한다.
    static ArrayList<int[]> space;
    static ArrayList<int[]> aircon;
    static boolean[][][][] moveF;

    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    roomT = new int[n][n];
    moveF = new boolean[n][n][n][n];
    space = new ArrayList<>();
    aircon = new ArrayList<>();

    for(int i = 0; i < n ; i++){
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < n; j++){
            int dir = Integer.parseInt(st.nextToken());
            if(dir>1){
                aircon.add(new int[] {i,j,dir-2});
            }else if(dir == 1){
                space.add(new int[] {i,j});
            }
        }
    }

    for(int i = 0 ; i < m; i++){
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int dir = Integer.parseInt(st.nextToken());
        if(dir==0){
            moveF[x][y][x-1][y]= true;
            moveF[x-1][y][x][y]=true;
        }else{
            moveF[x][y-1][x][y]= true;
            moveF[x][y][x][y-1]=true;

        }
    }
    int t = 1;
    while(t<=100){
        //t*(n^2+n^2*2+ n

        moves();//에어컨이 시원하게 해주기
        spread();//공기가 흐르는것
        melt();//외벽이 감소하는것
//        for(int i = 0 ; i < n ; i++){
//            System.out.println(Arrays.toString(roomT[i]));
//        }
        if(finish()){
            break;
        }
        t++;
    }
        System.out.println(t >100?-1: t);
    }
    static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
    //초기 1회성 dx
    static int[][] adx = {{-1,0,1},{-1,-1,-1},{-1,0,1}, {1,1,1}};
    static int[][] ady = {{-1,-1,-1},{-1,0,1},{1,1,1},{-1,0,1}};
    static void moves(){
        for(int i = 0 ; i < aircon.size();i++){
            int[] cur = aircon.get(i);
            move(cur[0],cur[1],cur[2]);
        }
    }
    static void move(int sx, int sy, int dir){
//        System.out.println("move 시작");
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        int x = sx+dx[dir];
        int y = sy+dy[dir];
        v[x][y]= true;
        q.add(new int[] {x,y,5 });
        roomT[x][y]+=5;
        while(!q.isEmpty()){
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            if(cur[2]==1) continue;
            //0을 찾으러갈 이유가 없음.
            for(int d= 0; d<3;d++){
                int nx = cur[0] + adx[dir][d];
                int ny = cur[1] + ady[dir][d];
//                System.out.println("dd");
                if(!inRange(nx,ny)) continue;
//                System.out.println("CC");
                if(v[nx][ny]) continue;
//                System.out.println("SS");
                if(check(cur[0],cur[1],dir,d)){
                    q.add(new int[] {nx,ny,cur[2]-1});
                    roomT[nx][ny]+=(cur[2]-1);
                    v[nx][ny] = true;
                }
            }
        }
        //이제부터 q를 돌려줄 것이다.
    }
//    static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
//    초기 1회성 dx
//    static int[][] adx = {{-1,0,1},{-1,-1,-1},{-1,0,1}, {1,1,1}};
//    static int[][] ady = {{-1,-1,-1},{-1,0,1},{1,1,1},{-1,0,1}};

    static boolean check(int x, int y,int sd, int dir){
        int nx = x + adx[sd][dir];
        int ny = y+ ady[sd][dir];
        if(sd==1||sd==3){
            if(!moveF[x][y][x][ny]&&!moveF[x][ny][nx][ny]){
                return true;
            }
        }
        else{
            if(!moveF[x][y][nx][y]&&!moveF[nx][y][nx][ny]){
                return true;
            }
        }
        return false;
    }
    static void spread(){
        int[] sdx = {-1,0}, sdy = {0,-1};
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){

                for(int d= 0 ; d<2; d++){
                    int nx = i+sdx[d];
                    int ny = j+sdy[d];
                    if(inRange(nx,ny)&&!moveF[i][j][nx][ny]&&Math.abs(roomT[i][j]-roomT[nx][ny])>=4){
                        int bet = roomT[i][j]-roomT[nx][ny];

                            temp[i][j] -=(bet/4);
                            temp[nx][ny]+=(bet/4);

                    }
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                roomT[i][j]+=temp[i][j];
            }
        }

    }
    static boolean inRange(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
    static void melt(){
//        System.out.println("melting");
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                if(i==0||i==n-1||j==0||j==n-1){
                    roomT[i][j] += roomT[i][j]>0 ? -1 : 0;
//                    System.out.println(i + " " + j);
                }
            }
        }
//        System.out.println("melting end");
    }
    static boolean finish(){
        for(int i = 0 ; i < space.size();i++){
            int[] cur = space.get(i);
            if(roomT[cur[0]][cur[1]]<k){
                return false;
            }
        }

        return true;
    }
}
