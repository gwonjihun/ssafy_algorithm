package Boj;

import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int x,y,cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}
public class Main_boj_1261 {
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        map = new int[M][N];

        for(int i = 0 ; i < M;i++){
            String str = br.readLine();
            for(int j = 0 ; j<N;j++){
                map[i][j] =str.charAt(j)-'0';
            }
        }

        System.out.println(bfs(0,0));


    }

    static int bfs(int x,int y){
        int cnt = Integer.MAX_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<>();

        visited[x][y]= true;
        q.add(new Node(x,y,0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x == M-1 && cur.y == N-1){
                cnt = cur.cnt;
                break;
            }
            for(int d = 0 ; d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(0<=nx&&nx<M&&0<=ny&&ny<N&&!visited[nx][ny]){
                    if(map[nx][ny]==0){

//                        System.out.println(nx+ " " + ny + " " + cur.cnt);
                        q.add(new Node(nx,ny,cur.cnt));
                    }else{

//                        System.out.println(nx+ " " + ny + " " + (cur.cnt+1));
                        q.add(new Node(nx,ny,cur.cnt+1));
                    }
                    visited[nx][ny] =true;
                }
            }

        }

        return cnt;
    }

}

