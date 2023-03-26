package gwonjihun.baejjon;
import java.util.*;
import java.io.*;

public class boj_2251 {
    static int Maxa,Maxb,Maxc;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Maxa = Integer.parseInt(st.nextToken());
        Maxb = Integer.parseInt(st.nextToken());
        Maxc = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        bfs();
        Collections.sort(answer);
        for(int a : answer){
            System.out.printf("%d ",a);
        }
    }

    static class Bottle{
        int a;
        int b;
        int c;

        public Bottle(int a, int b, int c){
            super();
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Bottle{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    '}';
        }
    }

    static void bfs(){
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visited = new boolean[Maxa+1][Maxb+1][Maxc+1];

        q.add(new Bottle(0,0,Maxc));
//      ì´ˆê¸° ?ƒ?ƒœ
        while(!q.isEmpty()){
            Bottle cur = q.poll();
//            System.out.println(cur.toString());
            if(visited[cur.a][cur.b][cur.c]){
                continue;
            }
            if(cur.a==0){
                answer.add(cur.c);
            }

            visited[cur.a][cur.b][cur.c] = true;
//           ë¬¼ì„ ?„£?–´ì£¼ëŠ” ì¼??´?Š¤?Š”
//            abc?—?„œ
//            a-> b b->a a->c c->a b->c c->b
//            ë¬¼ì„ ?„£?–´ì¤„ë•Œ ? „ë¶? ?“¤?–´ê°??Š”ê²ƒê³¼ ?‚¨?Š” ê²? 2ê°?ì§??˜ ê²½ìš°?”© ?žˆ?‹¤

//           case c->a
            if (cur.a+ cur.c<=Maxa){
                q.add(new Bottle(cur.a+ cur.c, cur.b, 0));
            }else{
                q.add(new Bottle(Maxa, cur.b, cur.c-(Maxa-cur.a)));
            }
//           case a->c
            if (cur.a+ cur.c<=Maxc){
                q.add(new Bottle(0, cur.b, cur.a+ cur.c));
            }else{
                q.add(new Bottle(cur.a+ cur.c-Maxc, cur.b, Maxc));
            }
//           case a->b
            if (cur.a+cur.b<=Maxb){
                q.add(new Bottle(0, cur.a+ cur.b, cur.c));
            }else{
                q.add(new Bottle(cur.a+cur.b-Maxb,Maxb,cur.c));
            }
//           case B->A
            if (cur.a+cur.b<=Maxa){
                q.add(new Bottle(cur.a+ cur.b,0,  cur.c));
            }else{
                q.add(new Bottle(Maxa,cur.a+cur.b-Maxa,cur.c));
            }
//           case b->c
            if (cur.b+cur.c<=Maxc){
                q.add(new Bottle(cur.a,0,cur.b+cur.c));
            }else{
                q.add(new Bottle(cur.a,cur.b+cur.c-Maxc,Maxc));
            }
//            case c->b
            if (cur.b+cur.c<=Maxb){
                q.add(new Bottle(cur.a,cur.b+cur.c,0));
            }else{
                q.add(new Bottle(cur.a,Maxb,cur.b+cur.c-Maxb));
            }

        }
    }

}
