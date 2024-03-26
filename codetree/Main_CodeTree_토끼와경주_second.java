package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_토끼와경주_second {

    static class Rabbit implements Comparable<Rabbit>
    {
        @Override
        public String toString() {
            return "Rabbit{" +
                    "x=" + x +
                    ", y=" + y +
                    ", jump=" + jump +
                    ", pid=" + pid +
                    '}';
        }

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
            if(this.x+this.y != o.x+o.y) return Integer.compare(this.x+this.y, o.x+o.y);
            if(this.x != o.x ) return Integer.compare(this.x,o.x);
            if(this.y != o.y ) return Integer.compare(this.y,o.y);
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
            if(this.x+this.y != o.x+o.y) return -Integer.compare(this.x + this.y, o.x+o.y);
            if(this.x != o.x) return -Integer.compare(this.x,o.x);
            if(this.y != o.y) return -Integer.compare(this.y,o.y);
            return -Long.compare(this.pid,o.pid);
        }
    }

    static HashMap<Long,Integer> idtoIdx;// pid -> index로 전환해준다.
    static int n,m,p;
    static long[]  pid;
    static int[] rx;
    static int[] ry;
    static boolean[] jumped;
    static long[] dist,score;
    static long totalScore;

    static int[] dx ={1,0,-1,0}, dy={0,1,0,-1};
    static PriorityQueue<Rabbit> rabbitQ;
    public static int move(long moveDistance, int range){
        moveDistance = moveDistance %((range-1)*2);
        return moveDistance <= (range-1) ?  (int)moveDistance : (range-1) - (int)moveDistance % (range-1);
    }

    public static Pair getNextDestination(int x, int y, int i, long dis){

        int nx = x,ny = y;
        if(i == 0){ // 오른쪽인 경우
            nx = move(x + dx[i] * dis, m);
        }
        if(i == 1){ // 아래쪽인 경우
            ny = move(y + dy[i] * dis, n);
        }
        if(i == 2){  // 왼쪽인 경우
            nx = move(Math.abs(x + dx[i] * dis), m);
        }
        if(i == 3){ // 아래쪽인 경우
            ny = move(Math.abs(y + dy[i] * dis), n);
        }
        return new Pair(nx, ny, 0);
    }
    static void jump(StringTokenizer st){
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i<p;i++){
            jumped[i]= false;
        }
//        System.out.println(rabbitQ.size());
        while(k-->0){

            Rabbit curR = rabbitQ.poll();
            int idx = idtoIdx.get(curR.pid);
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            for(int d= 0; d<4;d++){
                Pair next = getNextDestination(curR.x, curR.y, d,dist[idx]);
                pq.add(next);
            }
            Pair cur = pq.poll();
            rx[idx]= cur.x;
            ry[idx] = cur.y;
            rabbitQ.add(new Rabbit(rx[idx],ry[idx], curR.jump+1,pid[idx]));
            score[idx] -=(cur.x+cur.y+2);
            totalScore += (cur.x+cur.y+2);
            jumped[idx] = true;
        }
        PriorityQueue<Pair> sq = new PriorityQueue<>();
        for(int i = 0 ; i<p;i++){
            if(!jumped[i]) continue;
            sq.add(new Pair(rx[i],ry[i],pid[i]));
        }
        Pair bonusR = sq.poll();
        score[idtoIdx.get(bonusR.pid)] += s;
    }
    static void init(StringTokenizer st ){
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        rx = new int[p];
        ry = new int[p];
        score = new long[p];
        dist = new long[p];
        pid = new long[p];
//        System.out.println(Arrays.toString(rx));
        jumped = new boolean[p];

        totalScore = 0;
        idtoIdx = new HashMap<>();
        rabbitQ = new PriorityQueue<>();
        for(int i = 0 ; i < p; i++){
            pid[i] = Long.parseLong(st.nextToken());
            idtoIdx.put(pid[i],i);
            dist[i] = Integer.parseInt(st.nextToken());
            rx[i]=0;ry[i]=0;
            rabbitQ.add(new Rabbit(0,0,0,pid[i]));
//            System.out.println(rabbitQ.peek());
        }
    }

    static void editJump(StringTokenizer st){
        long tid = Long.parseLong(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int tidx= idtoIdx.get(tid);
        dist[tidx]= dist[tidx]*l;
    }

    static void resultPrint(){
        long max = 0;
        for(int i = 0 ;i<p;i++){
            long temp = score[i]+totalScore;
            max = Math.max(max,temp);
            System.out.print(temp +" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(score));
        System.out.println(max + " " +totalScore);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());

        while(Q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query==100){
                init(st);
            }else if(query == 200){
                jump(st);
            }else if(query == 300){
                editJump(st);
            }else if(query == 400){
                resultPrint();
            }

        }

    }

}