package CodeTree;
import java.io.*;
import java.util.*;
/*
    move(); -> 기사 이동을 구현한다
    movable() -> 기사 이동 가능성을 treu false로 반환한다


*/
public class Main_CodeTree_왕실기사의대결_aga {

    static int L,N,Q;
    static int[][] wall;//벽을 의미
    static Kngiht[] kngihts;
    static boolean[] moveTarget;//이동해야하는 밀린 기사들을 의미한다.
    static int totalDamege;
    static int[] score;
    static int[] dx= {-1,0,1,0} , dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        wall = new int[L][L];
        for(int i = 0 ; i < L ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < L ; j++){
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int j = 0 ; j < L ; j++){
//            System.out.println(Arrays.toString(wall[j]));
//        }
        kngihts = new Kngiht[N];
        score = new int[N];
        for(int i = 0 ; i < N;i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            int h= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            int k= Integer.parseInt(st.nextToken());
            kngihts[i] = new Kngiht(x,y,h,w,k);
        }

        totalDamege =0 ;
//        System.out.println("기사의 초기 상탱");
//        System.out.println(Arrays.toString(kngihts));
        while(Q-->0){
            st = new StringTokenizer(br.readLine());
            moveTarget = new boolean[N];
            int idx = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            Kngiht cur = kngihts[idx];
            if(cur.k<=0) continue;
            //이걸 통해서 기사의 체력이 0 이하이면 죽었기때문에 진행이 안된다를 의미해준다.

            if(movable(idx,d)){
                //이동이 불가능하게된다면 아무것도 하지 않는것이잖아
//                System.out.println("여길 못와..?");
                cur.x += dx[d];
                cur.y += dy[d];
                for(int i = 0 ; i < N;i++){
                    if(!moveTarget[i])continue;
                    if(i== idx) continue;
                    Kngiht kngiht = kngihts[i];
                    kngiht.x += dx[d];
                    kngiht.y += dy[d];
                    int dmg = damege(kngiht);
//                    totalDamege += Math.min(dmg, kngiht.k);
                    kngiht.k -= dmg;
                }
            }
//            System.out.println("1라운드 뒤 기사 상태");
//            System.out.println(Arrays.toString(kngihts));

        }
        int answer = 0;
        for(int i = 0 ; i < N;i++){
            Kngiht cur = kngihts[i];
            if(cur.k>0){
                answer += (cur.ik-cur.k);
            }
        }
//        System.out.println(Arrays.toString(kngihts));
        System.out.println(answer);
    }
    static int damege(Kngiht kngiht){
        int dmg =0 ;
        for(int i = kngiht.x; i< kngiht.x+ kngiht.h;i++){
            for(int j = kngiht.y; j< kngiht.y+ kngiht.w;j++) {
                if(wall[i][j]==1) dmg++;
                }
            }

        return dmg;
    }
    static boolean movable(int idx,int dir){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        while(!q.isEmpty()){
            //여기에서 판단하는거 어떰?
            int cur = q.poll();//현재 이거는 이동할 기사이고
//            System.out.println(cur + " 기사의 이동 가능성을 판단중입니다.");
            //기사가 이동한뒤에 주변 기사들이 있는지를 먼저 확인한다.
            //그럴려면
            Kngiht ckn = kngihts[cur];
            int nx = ckn.x + dx[dir];
            int ny = ckn.y + dy[dir];
            if(!(0<=nx&&nx+ckn.h-1<L&&0<=ny&&ny+ckn.w-1<L)){
//                System.out.println("1qjs false");
                return false;
            }

            for(int i = nx; i< nx+ ckn.h;i++){
                for(int j = ny; j< ny+ ckn.w;j++) {
                    if(wall[i][j]==2 ){
//                        System.out.println(i + " " +  j);
//                        System.out.println("2qjs false");
                        return false;
                    }
                }
            }
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            for(int i = 0 ; i < N ; i++){
                if(moveTarget[i]) continue;
                if(i == idx ) continue;
                Kngiht next = kngihts[i];
                for(int x = next.x ; x< next.x+next.h;x++){
                    if(moveTarget[i]) break;
                    for(int y = next.y ; y< next.y +next.y;y++){
                        if(x>=nx&&x<nx+ckn.h&&y>=ny&&y<ny+ckn.w&&!moveTarget[i]){
                        q.add(i);
                        moveTarget[i] = true;
                        break;
                        }
                    }
                }

            }

        }
//        System.out.println("True 나옴! 이동 쌉가능!!");
        return true;
    }

    static class Kngiht{
        int x,y,h,w,k,ik;

        @Override
        public String toString() {
            return "Kngiht{" +
                    "x=" + x +
                    ", y=" + y +
                    ", h=" + h +
                    ", w=" + w +
                    ", k=" + k +
                    ", ik=" + ik +
                    '}';
        }

        public Kngiht(int x, int y, int h, int w,int k) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
            this.k = k;
            this.ik = k;
        }
    }
}