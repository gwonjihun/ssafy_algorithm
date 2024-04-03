package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_싸움땅_24상 {
    static class Player implements Comparable<Player>{
        int x,y,d,s,g,idx;

        @Override
        public String toString() {
            return "Player{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", s=" + s +
                    ", g=" + g +
                    ", idx=" + idx +
                    '}';
        }

        public Player(int x, int y, int d, int s, int idx) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.idx = idx;
        }

        @Override
        public int compareTo(Player o) {
            int thissum = this.g+this.s;
            int osum = o.g+ o.s;
            if(thissum!=osum) return Integer.compare(thissum,osum);
            return Integer.compare(this.s,o.s);
        }
    }

    static int n, m,k;
    static PriorityQueue<Integer>[][] board;
    static Player[] players;
    static int[] score;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
        board = new PriorityQueue[n][n];
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        players = new Player[m];
        score = new int[m];

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                board[i][j]= new PriorityQueue<>(Collections.reverseOrder());
                int s = Integer.parseInt(st.nextToken());
                if(s > 0) board[i][j].add(s);
            }
        }

        for(int i = 0 ; i <  m ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players[i] = new Player(x,y,d,s,i);
        }

        while(k-->0){
            move();
//            System.out.println("_________k한번 끝________");
        }
        for(int a : score){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    static void move(){
        for(int i = 0 ; i < m;i++){
            Player cur = players[i];
            int nx = cur.x +dx[cur.d];
            int ny = cur.y + dy[cur.d];
            if(!inRange(nx,ny)){
                cur.d = (cur.d+2)%4;
                nx = cur.x +dx[cur.d];
                ny = cur.y + dy[cur.d];
            }

            int fighter = find(nx,ny);
            cur.x = nx;
            cur.y = ny;
            if(fighter>-1) {
                //여기서 싸우는거고
                fight(i,fighter);
            }else{
                getGun(i);


                //
            }
//            System.out.println("_______"+i+"_번 이동 끝_____");
//            for(int t = 0;t<m;t++){
//                System.out.println(players[t]);
//            }
        }

    }
    static void fight(int idx1,int idx2){
        //idx1 : 현재 움직였던 사람
        //idx2 : 도착지에 있던 사람
        int winneridx;
        int loseridx;
        Player cur1 = players[idx1];
        Player cur2 = players[idx2];
        if(cur1.compareTo(cur2)<0){
            winneridx = idx2;
            loseridx =idx1;
        }else{
            winneridx = idx1;
            loseridx =idx2;
        }
        score[winneridx] += Math.abs(cur1.g+cur1.s-cur2.g-cur2.s);
        loser(loseridx);//
        getGun(winneridx);
    }
    static void loser(int idx){
        Player cur = players[idx];
        if(cur.g>0){
            board[cur.x][cur.y].add(cur.g);
            cur.g= 0;
        }
        while(true){
            int nx = cur.x+dx[cur.d];
            int ny = cur.y+dy[cur.d];
            int findidx = find(nx,ny);
            if(inRange(nx,ny)&&findidx==-1){
                cur.x = nx;
                cur.y = ny;
                break;
            }
            cur.d = (cur.d+1)%4;
        }
        getGun(idx);
    }
    static int find(int x,int y){
        for(int i = 0 ; i < m ; i ++){
            Player cur = players[i];
            if(cur.x==x&&cur.y==y){
                return i;
            }
        }
        return -1;
    }
    static void getGun(int idx){
        Player cur = players[idx];
        if(cur.g>0){
            board[cur.x][cur.y].add(cur.g);
            cur.g=0;
        }
        if(!board[cur.x][cur.y].isEmpty()){
        cur.g = board[cur.x][cur.y].poll();
        }
    }
    static boolean inRange(int x,int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
}
