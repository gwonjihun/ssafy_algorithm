package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_1260 {

    static boolean[] visited;
    static List<Integer>[] graph;
    static int N, M, S;// 정점, 간선 개수 | 탐색을 시작할 번호

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;

        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N];
        dfs(S);
        System.out.println();
        visited = new boolean[N];
        bfs(S);
    }
    static void bfs(int s){
        Deque<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);
        while(!q.isEmpty()){
            int n = q.poll();
            System.out.print((n+1) + " ");
            for(int a : graph[n]){
                if(!visited[a]){
                    visited[a]= true;
                    q.add(a);
                }
            }
        }
    }
    static void dfs(int s){
        visited[s] = true;
        System.out.print((s+1) +" ");
        for(int a : graph[s]){
            //graph[s]에서 가지고 있는 배열을 기반으로
            //미방문인 경우만 출력해주는 것보단.
            if(visited[a]) continue;
            dfs(a);

        }

    }

}
