package Boj;

import java.io.*;
import java.util.*;

/*
1. 1번 노드를 시작으로 해서 dfs를 돌리고 얻은 node와 dist를 가져온다.
2. 첫번째 dfs를 통해서 얻어온 node는 트리 지름의 하나의 끝 점을 구한것이다.
3. 두번째 dfs는 얻었던 node를 기점으로 돌려서 다른 지름의 끝점과 길이를 구할 수 있다.
*/
public class Main_boj_1967_aga {

    static List<int[]>[] edges;//int[] {e, edge};
    static int n;
    static boolean[] visited;//방문했던 노드들
    static int[] max = new int[] {-1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n];
        for(int i = 0 ; i < n ; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());
            edges[start].add(new int[] {end,dist});
            edges[end].add(new int[] {start,dist});
        }
        visited = new boolean[n];
        visited[0] = true;
        dfs(0,0);
        visited = new boolean[n];
        visited[max[0]]=true;
        dfs(max[0],0);
        System.out.println(max[1]);
        // 여기에 코드를 작성해주세요.
    }
    //last노드를 알아야지 가능함.
    static void dfs(int start, int sum){
        if(sum>max[1]){
            max[0]= start;
            max[1]= sum;
        }
        for(int[] next : edges[start]){
            if(!visited[next[0]]){
                visited[next[0]] = true;
                dfs(next[0],sum+next[1]);
                visited[next[0]] = false;

            }
        }

    }
}
