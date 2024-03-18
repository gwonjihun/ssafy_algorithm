package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_전기차 {
    static class Pair{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] wall;//벽위치
    static int[] dx ={-1,0,0,1}, dy={0,-1,1,0};
    static int tx,ty,fuel,gx,gy,cnt;
    static int n,m;
    static int moveCnt;

    // 여기다가 [x,y]도착지 정로를 넣어줄껏이고
    //wall에다가 -1은 벽 1,2,3,4,6,7...은 사람으로 계산해준다.
    static Pair[] goal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        wall = new int[n][n];
        goal = new Pair[m];

        for(int i = 0 ; i < n ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                int ipt = Integer.parseInt(st.nextToken());
                wall[i][j] = ipt==1 ? -1 : ipt;
            }
        }
        st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken())-1;
        ty = Integer.parseInt(st.nextToken())-1;

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;

            goal[i] = new Pair( ex,ey);
            wall[sx][sy] = i+1;
        }
//        for(int i = 0 ; i < n ; i++){
//            System.out.println(Arrays.toString(wall[i]));
//        }

        for(int rount = 0 ; rount<m;rount++){
            moveCnt = 0;
            //이걸로 3명의 목적지가 있으면 찾는거고
            int idx = move();
            if(idx ==-1){
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(-1);
                return;
            }
//            System.out.println(idx);
//            System.out.println("move 종료후 상태 " + tx + " " + ty + " " + fuel);
            int gx = goal[idx-1].x;
            int gy = goal[idx-1].y;
//            System.out.println(idx+ " "+ gx + " " + gy + " ");
            if(!moveGoal(gx,gy)){
//                System.out.println("!@#!@#");
                System.out.println(-1);
                return;
            }
//            System.out.println("movegoal 종료후 상태 " + tx + " " + ty + " " + fuel);
        }
        System.out.println(fuel);
    }
    static boolean moveGoal(int gx,int gy){
        boolean[][] v= new boolean[n][n];
        Deque<int[]> q= new ArrayDeque<>();
        v[tx][ty] = true;
        q.add(new int[] {tx,ty,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[2]>fuel){
                break;
            }
            if(cur[0]==gx&&cur[1]==gy){
                moveCnt = cur[2];
                tx = gx;
                ty = gy;
                fuel -= cur[2];
                fuel += moveCnt*2;
                return true;
            }
            for(int d= 0 ; d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(inRange(nx,ny)&&!v[nx][ny]&&wall[nx][ny]!=-1){

                    q.add(new int[] {nx,ny,cur[2]+1});
                    v[nx][ny]=true;
                }
            }
        }
//        System.out.println(tx + " " + ty + " " + fuel);

        return false;
    }
    static int move(){
//        int gx = -1, gy =-1,dist = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]){
                    if(o1[0]==o2[0]){
                        return Integer.compare(o1[1],o2[1]);
                    }
                    return Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[2],o2[2]);
            }
        });
//        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] v= new boolean[n][n];
        v[tx][ty] = true;
        q.add(new int[] {tx,ty,0});
//        System.out.println("q.poll의 결과들");
//        System.out.println("_________________________");
        while(!q.isEmpty()){
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            if(cur[2]>=fuel){
                break;
            }
            if(wall[cur[0]][cur[1]]>0){
                fuel-=cur[2];
                int idx = wall[cur[0]][cur[1]];
                wall[cur[0]][cur[1]] = 0 ;
                tx = cur[0];
                ty = cur[1];
                return idx;

//                if(cur[2]==dist){
//                    if(cur[0] == gx){
//                        if(cur[1]<gy){
//                        gx = cur[0];
//                        gy = cur[1];
//                        dist = cur[2];
//                        }
//                    }
//                    if(cur[0]<gx){
//                        gx = cur[0];
//                        gy = cur[1];
//                        dist = cur[2];
//                    }
//                }else if(cur[2]<dist){
//                    gx = cur[0];
//                    gy = cur[1];
//                    dist = cur[2];
//                }
            }
            for(int d= 0 ; d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(inRange(nx,ny)&&!v[nx][ny]&&wall[nx][ny]!=-1){

                    q.add(new int[] {nx,ny,cur[2]+1});
                    v[nx][ny]=true;
                }
            }
        }
//        if(dist!=Integer.MAX_VALUE){
////                moveCnt = cur[2];
//            fuel-=dist;
//            int idx = wall[gx][gy];
//            wall[gx][gy] = 0 ;
//            tx = gx;
//            ty = gy;
//            return idx;
//        }
        return -1;
    }
    static boolean inRange(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
/**
 * 1. 최적지를 찾는다. 만약 최적지를 찾는 도중 fuel보다 큰 값이 나오면 -1로 리턴해준다
 * 2. move함수를 -1이 아니라면 tx의 위치와 fuel은 갱신된다.
 * 3. moveGoal(gx,gy)로 이동한다. 이때 -1이뜬다면 -1을 출력하고 return
 */
}
