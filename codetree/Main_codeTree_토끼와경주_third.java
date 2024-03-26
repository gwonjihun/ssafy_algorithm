package CodeTree;

import java.io.*;
import java.util.*;

public class Main_codeTree_토끼와경주_third {

    static class Rabbit implements Comparable<Rabbit> {
        int x,y,jump;
        long pid;

        public Rabbit(int x, int y, int jump, long pid) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.pid = pid;
        }

        @Override
        public int compareTo(Rabbit o) {
            if(this.jump!= o.jump) return Integer.compare(this.jump,o.jump);
            if((this.x+this.y)!= (o.x+o.y)) return Integer.compare((this.x+this.y),(o.x+o.y));
            if(this.x!= o.x) return Integer.compare(this.x,o.x);
            if(this.y!= o.y) return Integer.compare(this.y,o.y);
            return Long.compare(this.pid,o.pid);
        }
    }

    static class Pair implements Comparable<Pair>{
        int x,y;
        long pid;

        public Pair(int x, int y, long pid) {
            this.x = x;
            this.y = y;
            this.pid = pid;
        }

        @Override
        public int compareTo(Pair o) {
            if((this.x+this.y)!=(o.x+o.y)) return -Integer.compare((this.x+this.y),(o.x+o.y));
            if(this.x!=o.x) return -Integer.compare(this.x,o.x);
            if(this.y!=o.y) return -Integer.compare(this.y,o.y);
            return -Long.compare(this.pid,o.pid);

        }
    }

    static int n,m,p;
    static boolean[] jumped;
    static long[] pid;
    static long[] dist;


    static long[] score;
    static long totalSum=0;

    static Pair[] position;
    static HashMap<Long,Integer> idToIdx;//pid -> idx로 전환해준다
    static PriorityQueue<Rabbit> rabbitPQ;
    static void init(StringTokenizer st){
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        position = new Pair[p];
        score = new long[p];

        dist = new long[p];

        totalSum = 0;
        pid = new long[p];
        jumped = new boolean[p];

        idToIdx = new HashMap<>();
        rabbitPQ = new PriorityQueue<>();

        for(int i = 0 ; i < p;i++){
            pid[i] =Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());

            position[i] = new Pair(0,0,0);
            score[i]=0;

            idToIdx.put(pid[i],i);

            rabbitPQ.add(new Rabbit(position[i].x,position[i].y,0,pid[i]));
        }
    }
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};

    static int move(long sx, int range){
        sx = sx%((range-1)*2);
        return sx <= (range-1)? (int) sx : range-1 -(int)sx%(range-1);
    }
    static Pair moves(int x,int y,long dis,int d){
        int nx = x; int ny = y;
        if(d == 0 ){
            nx = move(x+dx[d]*dis,n);
        }
        if(d == 1 ){
            ny = move(y+dy[d]*dis,m);
        }
        if(d == 2 ){
            nx = move(Math.abs(x+dx[d]*dis),n);
        }

        if(d == 3 ){
            ny = move(Math.abs(y+dy[d]*dis),m);
        }
        return new Pair(nx,ny,0);
    }
    static void jumpRabbit(StringTokenizer st){
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < p ; i++){
            jumped[i] = false;
        }
        while(k-->0){
            Rabbit curR = rabbitPQ.poll();
            int idx = idToIdx.get(curR.pid);
            PriorityQueue<Pair> dir = new PriorityQueue<>();
            for(int d= 0 ; d<4;d++){
                Pair nPos = moves(curR.x,curR.y,dist[idx],d);
                dir.add(nPos);
            }
            Pair next = dir.poll();
            position[idx] = next;
            //next에서는 무조건, x,y값만 가지고 판단함
            totalSum+= (next.x+next.y+2);
            score[idx] -= (next.x+next.y+2);
            jumped[idx]=true;
            rabbitPQ.add(new Rabbit(position[idx].x,position[idx].y, curR.jump+1, pid[idx]));
        }
        PriorityQueue<Pair> bonusQ = new PriorityQueue<>();
        for(int i = 0 ; i <p;i++){
            if(jumped[i]) bonusQ.add(new Pair(position[i].x,position[i].y,pid[i]));
        }
        Pair bonus = bonusQ.poll();
        int idxB = idToIdx.get(bonus.pid);
        score[idxB] +=s;

    }

    static void printResult(){
        long max = 0;
        for(int i = 0 ; i < p ; i++){
            max = Math.max(max,totalSum+score[i]);
        }
        System.out.println(max);
    }
    static void editRabbit(StringTokenizer st){
        long id =Long.parseLong(st.nextToken());
        int idx = idToIdx.get(id);
        int l = Integer.parseInt(st.nextToken());
        dist[idx] = dist[idx]*l;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        while(Q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            switch (query){
                case 100:
                    init(st);
                    break;
                case 200:
                    jumpRabbit(st);
                    break;
                case 300:
                    editRabbit(st);
                    break;
                case 400:
                    printResult();
                    break;
            }
        }


    }
}
