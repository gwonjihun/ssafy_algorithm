package CodeTree;

import java.io.*;
import java.util.*;

public class Main_codeTree_냉방시스템 {
//
//    static int n,m,k;
//    static ArrayList<int[]> space;
//    static ArrayList<int[]> aircons;
//    static int[][] curTemp;
//    static int[][] temp;
//    static boolean[][][][] ismove;
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//
//        space = new ArrayList<>();
//        aircons = new ArrayList<>(); // int[] -> x,y,dir을가지고 있다. dir은 음.. 0,1,2,3
//        curTemp = new int[n][n];
//        ismove = new boolean[n][n][n][n];
//
//        for(int i = 0 ; i < n ; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0 ; j < n; j++) {
//                int dir = Integer.parseInt(st.nextToken());
//                if (dir == 1) {
//                    space.add(new int[]{i, j});
//                } else if (dir > 1) {
//                    aircons.add(new int[]{i, j, dir - 2});
//                }
//            }
//        }
//
//        for(int i = 0 ; i < m ;i++){
//            st = new StringTokenizer(br.readLine());
//            int x =Integer.parseInt(st.nextToken())-1;
//            int y = Integer.parseInt(st.nextToken())-1;
//            int dir = Integer.parseInt(st.nextToken());
//
//            if(dir==0){
//                ismove[x][y][x-1][y]=true;
//                ismove[x-1][y][x][y] =true;
//            }else{
//                ismove[x][y][x][y-1]=true;
//                ismove[x][y-1][x][y]= true;
//            }
//        }
//        int time = 0;
//        while(time<=100){
//            ice();
//            rotate();
//            melt();
//            time++;
//            if(finish()){
//                break;
//            }
//        }
//        System.out.println(time>100? -1 : time);
//    }
//    static int[] idx = {0,-1,0,1}, idy = {-1,0,1,0};
//    static int[][] sdx = {{-1,0,1},{-1,-1,-1},{-1,0,1},{1,1,1,}};
//    static int[][] sdy = {{-1,-1,-1},{-1,0,1},{1,1,1},{-1,0,1}};
//    static void ice(){
//        for(int i = 0; i < aircons.size();i++){
//            move(aircons);
//        }
//
//    }
//    static void move(int[] airInfo){
//        //airInfo : x,y, dir로 구성되어 있다.
//        int x = airInfo[0];
//        int y = airInfo[1];
//        int dir = airInfo[2];
//
//        boolean[][] v = new boolean[n][n];
//        Queue<int[]> q = new ArrayDeque<>();
//        q.add(new int[] {x+idx[dir],y+idy[dir],5});
//        v[x+idx[dir]][y+idy[dir]] =true;
//        while(!q.isEmpty()){
//            int[] cur = q.poll();
//            if(cur[2]==1)continue;
//            for(int d = 0 ; d<3;d++){
//                int nx = cur[0] + sdx[dir][d];
//                int ny = cur[1] + sdy[dir][d];
//            }
//        }
//
//    }
//    static boolean finish(){
//        for(int i = 0 ; i < space.size();i++){
//            int cur[] = space.get(i);
//            if(curTemp[cur[0]][cur[1]]<k){
//                return false;
//            }
//
//        }
//        return true;
//    }
}
