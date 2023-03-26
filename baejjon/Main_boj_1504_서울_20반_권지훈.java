package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int end;
    int weight;

    public Point(int end, int weight){this.end = end; this.weight = weight;}

    @Override
    public int compareTo(Point o) {
        return weight - o.weight;
    }
}

public class Main_boj_1504_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 200_000_000;
    static List<Point> list[];
    static int dist[];
    static boolean check[];
    static int n, v;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // ê·¸ëž˜?”„ ? •ë³? ???ž¥?•  listë¥? ì´ˆê¸°?™”?•œ?‹¤.
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        dist = new int[n + 1];
        check = new boolean[n + 1];

        // ê°„ì„  ? •ë³? ì´ˆê¸°?™”
        for(int i = 0 ; i < v; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // list?— graph? •ë³? ???ž¥ list?˜ index?Š” ì¶œë°œ?…¸?“œ
            // element?Š” ?„ì°©ë…¸?“œ?? ê°?ì¤‘ì¹˜ë¥? ???ž¥?•œ?‹¤.
            list[start].add(new Point(end, weight));
            // ë¬´ë°©?–¥ ê·¸ëž˜?”„?´ë¯?ë¡? ë°˜ë??„ ì¶”ê??•´ì¤??‹¤.
            list[end].add(new Point(start, weight));
        }

        // ?•„?ˆ˜ ?…¸?“œ ì´ˆê¸°?™”
        st = new StringTokenizer(br.readLine());
        int require1 = Integer.parseInt(st.nextToken());
        int require2 = Integer.parseInt(st.nextToken());

        // ???´ ë©”ì†Œ?“œ ?˜¸ì¶?
        int answer = solve(require1, require2);
        bw.write(answer+ "\n");

        bw.close();
        br.close();
    }

    private static int solve(int required1, int required2){
        int result1 = 0;
        int result2 = 0;

        // ê²½ë¡œ1
        // 1 -> ?•„?ˆ˜1 ìµœë‹¨ê±°ë¦¬
        result1 += dijkstra(1, required1);
        // ?•„?ˆ˜1 -> ?•„?ˆ˜2 ìµœë‹¨ê±°ë¦¬
        result1 += dijkstra(required1, required2);
        // ?•„?ˆ˜2 -> n ìµœë‹¨ê±°ë¦¬
        result1 += dijkstra(required2, n);

        //ê²½ë¡œ2
        // 1 -> ?•„?ˆ˜2 ìµœë‹¨ê±°ë¦¬
        result2 += dijkstra(1, required2);
        // ?•„?ˆ˜2 -> ?•„?ˆ˜1 ìµœë‹¨ê±°ë¦¬
        result2 += dijkstra(required2, required1);
        // ?•„?ˆ˜1 -> n ìµœë‹¨ê±°ë¦¬
        result2 += dijkstra(required1, n);

        // ê²½ë¡œ1 && ê²½ë¡œ2 -> ê°??Š”ê¸¸ì´ ?—†?Š” ê²½ìš°
        if(result1 >= INF && result2 >= INF) return -1;
        else return Math.min(result1, result2);
    }

    private static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(check[curNode] == true) continue;
            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;
                // ë¯¸ë°©ë¬? && ê¸°ì¡´?˜ ê³„ì‚°?œ ê±°ë¦¬ë³´ë‹¤ ?ƒˆë¡œìš´ ê±°ë¦¬ê°? ?ž‘?„ ê²½ìš°
                if(check[nextNode] == false && dist[nextNode] > curWeight + nextWeight){
                    dist[nextNode] = curWeight + nextWeight;
                    queue.add(new Point(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }
}