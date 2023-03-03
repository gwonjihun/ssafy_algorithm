package gwonjihun.swea;
import java.io.*;
import java.util.*;
 
public class Solution_D4_1219_현철님_list코드{
    static List<Integer>[] g;
    static boolean [] v;
     
    static int dfs(int i) {
        if (i==99) return 1;
         
        v[i] = true;
        for (int j : g[i]) {
            if (!v[j]) {
                if (dfs(j) == 1) return 1;
            }
        }
        return 0;
    }
     
    static int bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            for (int j : g[i]) {
                if (!v[j]) {
                    if (j==99) return 1;
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
        return 0;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            g = new List[100];
            v = new boolean[100];
            for (int i = 0; i < 100; i++) g[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                g[from].add(to);
            }
            sb.append("#"+t+" "+bfs(0)+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
 