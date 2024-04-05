package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_싸움땅_24상 {

    static class Man implements Comparable<Man>{

        int x,y,d,s,g;

        public Man(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.g= 0;
        }

        @Override
        public int compareTo(Man o1) {
            int o1Sum = o1.g + o1.s;
            int thisSum = this.g + this.s;
            if (thisSum != o1Sum) {
                return thisSum - o1Sum;
            }
            return this.s - o1.s;
        }
    }
    static int N,M,K;
    static Man[] mans;//싸움꾼들을 의미
    static PriorityQueue<Integer>[][] map;//이걸로 한번에 정리해준다.
    static int score[];//최종 스코어를
    static int info[][];// mans가 위치해있는 정보를 관리하는 배열

    static int[] dx = {-1,0,1,0}, dy={0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new PriorityQueue[N][N];
        mans = new Man[M+1];
        score = new int[M+1];
        info = new int[N][N];

        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< N ;j ++){
                map[i][j]= new PriorityQueue<>(Collections
                        .reverseOrder());
                int input = Integer.parseInt(st.nextToken());
                if(input>0){
                    map[i][j].offer(input);
                }
            }
        }
        for(int i = 1;i<=M;i++){
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            mans[i]= new Man(x,y,d,s);
            info[x][y] = i;
        }
        while(K-->0){
            for(int i = 1 ; i <=M; i++){
                move(i);
            }

        }
    }

    static void move(int idx){
        Man cur = mans[idx];
        int nx = cur.x+dx[cur.d];
        int ny = cur.y+dy[cur.d];
        if(!(0<=nx&&nx<N&&0<=ny&&ny<N)){
            cur.d = (cur.d+2)%4;
            nx = cur.x +dx[cur.d];
            ny = cur.y +dy[cur.d];
        }
        int find = finds(nx,ny);
        if(find == -1){
            //아무도 없음
            info[cur.x][cur.y]=0;
            info[nx][ny]=idx;
            if(cur.g!=0){
                map[nx][ny].add(cur.g);
                cur.g=0;
            }
            if(!map[nx][ny].isEmpty()){
            cur.g = map[nx][ny].poll();
            }
            cur.x =nx;
            cur.y =ny;

        }else{

            //누군가 있음.
        }
    }

    static int finds(int x,int y){
        for(int i = 1; i<=M;i++){
            if(mans[i].x==x&&mans[i].y==y){
                return i;
            }
        }
        return -1;
    }
}
