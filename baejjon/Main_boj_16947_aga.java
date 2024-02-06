package Boj;
import java.io.*;
import java.util.*;
public class Main_boj_16947_aga {
    static int N;
    static List<Integer>[] graph;
    static boolean[] isCircle;//각 번호마다 순환이 되는지 유무를 확인하기 위한 함수
    static int[] dist;//
    static boolean[] visited;// cir과 거리측정에 사용시에 씀
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        graph = new List[N+1];
        isCircle = new boolean[N+1];
        for(int i = 0; i<=N;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i = 1; i<= N ; i++){
            visited = new boolean[N+1];
            isCircle[i] = circle(i,i,i);
        }
//        System.out.println(Arrays.toString(isCircle));
        for(int i = 1; i<=N;i++){
            visited = new boolean[N+1];
            System.out.print(distance(i)+" ");
        }
    }

    static boolean circle(int start, int prev, int cur){
        if(cur== start&&visited[start]){
//            System.out.println(start);
            return true;
        }
        for(int a : graph[cur]){
//            System.out.println(a);
            if(!visited[a]&&a!=prev){
                visited[a]=true;
                if(circle(start,cur,a)){
//                    System.out.println(a);
                    return true;
                }
                visited[a]=false;
            }
        }
        return false;
    }

    static int distance(int st ){
        if(isCircle[st]) return 0;
        Queue<int[]> q = new ArrayDeque<>();
        visited[st] = true;
        q.add(new int[] {st,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(isCircle[cur[0]]) return cur[1];

            for(int next : graph[cur[0]]){
                if(!visited[next]){
                    visited[next]=true;
                    q.add(new int[]{next,cur[1]+1});
                }
            }
        }
        return 0;
    }
}