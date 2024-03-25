package CodeTree;

import java.io.*;
import java.util.*;
public class Main_CodeTree_토끼경주_fail {

    static class Pair implements Comparable<Pair>{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo( Pair o2) {
            if(this.x+this.y!=o2.x+o2.y) return Integer.compare(o2.x+o2.y,this.x+this.y);
            if(this.x!=o2.x) return Integer.compare(o2.x,this.x);
            return Integer.compare(o2.y,this.y);
        }
    }
    static class Rabbit implements Comparable<Rabbit>{
        int x,y,jump,pid;

        @Override
        public String toString() {
            return "Rabbit{" +
                    "x=" + x +
                    ", y=" + y +
                    ", jump=" + jump +
                    ", pid=" + pid +
                    '}';
        }

        public Rabbit(int x, int y, int jump, int pid) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.pid = pid;
        }

        @Override
        public int compareTo( Rabbit o2) {
            if(this.jump!=o2.jump)
                return Integer.compare(this.jump,o2.jump);
            if(this.x+this.y != o2.x+o2.y)
                return Integer.compare(this.x+this.y, o2.y+o2.x);
            if(this.x!=o2.x)
                return Integer.compare(this.x,o2.x);
            if(this.y!=o2.y)
                return Integer.compare(this.y, o2.y);
            return Integer.compare(this.pid,o2.pid);
        }
    }
    static int n,m,p;
    static int[] pids;
    static int[] dist;
    static int[] jump;
    static long[] score;
    static int[] arrx;
    static int[] arry;
    static long totalScore;
    static HashMap<Integer,Integer> map;//id, 배열의 idx로 구성
    static boolean[] jumped;
    static int[] dx = {1,0,-1,0}, dy ={0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < q ;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 100){
                init(st);
            }else if(cmd == 200){
                jump(st);
            }else if(cmd == 300){
                changeJump(st);
            }else if(cmd == 400){
                scorePrint();
            }
        }
    }
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
        return new Pair(nx, ny);
    }
    static void jump(StringTokenizer st){
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        PriorityQueue<Rabbit> qs= new PriorityQueue<>();
        System.out.println(p);
        for(int i = 0 ; i < p ;i++){
            jumped[i]= false;
            Rabbit curs = new Rabbit(arrx[i],arry[i],jump[i],pids[i]);
//            System.out.println(curs);
            qs.offer(curs);
            System.out.println("qs에 push함");
//            System.out.println("왜 한번만들고 죽지??");
        }
        PriorityQueue<Pair> PairQ = new PriorityQueue<>();
        for(int i = 0 ; i <k;i++){
            Rabbit cur = qs.poll();
            System.out.println(cur);
            int idx = map.get(cur.pid);
            for(int j=0;j<4;++j){
                Pair next = getNextDestination(cur.x,cur.y,j,dist[idx]);
                PairQ.add(next);
            }
            Pair pair = PairQ.poll();
            jumped[idx] = true;
            jump[idx]+=1;
            arrx[idx] =pair.x;
            arry[idx] =pair.y;
            score[idx] -= (pair.x+pair.y+2);

            Rabbit curs = new Rabbit(arrx[idx],arry[idx],jump[idx],pids[idx]);
            qs.offer(curs);
        }
        //int[] -> x, y, pid를 순서로 구성되어있도록 한다.
        PriorityQueue<int[]> qq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]+o1[1]!= o2[0]+o2[1]) return Integer.compare(o2[0]+o2[1],o1[0]+o1[1]);
                if(o1[0]!= o2[0]) return Integer.compare(o2[0],o1[0]);
                if(o1[1]!= o2[1]) return Integer.compare(o2[1],o1[1]);
                return Integer.compare(o2[2],o1[2]);
            }
        });
        for(int i = 0 ; i < p ;i++){
            if(!jumped[i]) continue;
            qq.add(new int[] {arrx[i],arry[i],pids[i]});
        }
        int pid = qq.poll()[2];
        int idx = map.get(pid);
        score[idx] += s;

    }
    static void init(StringTokenizer st){
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        totalScore = 0 ;
        pids = new int[p];
        jumped = new boolean[p];
        dist = new int[p];
        map = new HashMap<>();
        arrx = new int[p];
        arry = new int[p];
        jump = new int[p];
        score = new long[p];
        for(int i = 0 ; i <p ;i++){
            pids[i] = Integer.parseInt(st.nextToken());
            dist[i] = Integer.parseInt(st.nextToken());
            map.put(pids[i],i);
            System.out.println("test");
        }
    }
    static void changeJump(StringTokenizer st){
        int pid = Integer.parseInt(st.nextToken());
        int changedist = Integer.parseInt(st.nextToken());
        int idx= map.get(pid);
        dist[idx] *=changedist;
    }
    static void scorePrint(){
        long max = Long.MIN_VALUE;
        for(int i = 0 ; i < p;i++){
            max = Math.max(max,score[i]+totalScore);
        }
        System.out.println(max);
    }
}
