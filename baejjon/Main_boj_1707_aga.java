package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_1707_aga {
    static List<Integer>[] graph;
    static int[] color;
    static boolean[] visit;
    static final int red = 1;
    static int v, e;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new List[v+1];
            color = new int[v + 1];
            for (int i = 0; i < v + 1; i++) {
                graph[i]= new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }
            boolean result = false;
            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    result = bfs(i);
                }
                if (!result) break;
            }


            if (result) System.out.println("YES");
            else System.out.println("NO");

        }
    }

    static boolean bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        color[x] = red;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[(cur)]) {
                if (color[next] == color[cur]) return false;

                if (color[next] == 0) {
                    color[next] = color[cur] * -1;
                    q.add(next);
                }
            }
        }
        return true;
    }

}
