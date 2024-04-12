package CodeTree;

import java.io.*;
import java.util.*;

/*
* 먼저 dfs를 통해서 순서와 상관없이 x,y 3개를 고른다.
*
* */
public class Main_Codetree_방화벽설치 {
    static int n,m;
    static int[][] room;
    static int result = 0;
    static ArrayList<int[]> fire;
    static int[] dx = {0,1,-1,0} , dy = {1,0,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        fire = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j]==2){
                    fire.add(new int[] {i,j});
                }
            }
        }

        dfs(0,0);
        System.out.println(result);

    }

    static void dfs(int pos, int depth){
        //pos를 가지고 n으로 나눈 목이 x가되고
        //
        if(depth==3){
            result =Math.max(result,bfs());
            return;
        }

        for(int i = pos; i<n*m;i++){
            int x = i/m;
            int y = i-x*m;
//            System.out.println(x + "  " + y);
            if(room[x][y]==0){
                room[x][y] = 1;
                dfs(i+1,depth+1);
                room[x][y]= 0;
            }
        }


    }
    static int bfs(){
        boolean[][] v = new boolean[n][m];
        int[][] temp = new int[n][m];
//        System.out.println("bfs Temp Array : ------------------------------------");
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                temp[i][j] = room[i][j];
            }
//            System.out.println(Arrays.toString(temp[i]));
        }
        Deque<int[]> q = new ArrayDeque<>();
        for(int[] f : fire){
            q.add(new int[] {f[0],f[1]});
            v[f[0]][f[1]] = true;
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d= 0 ; d<4 ;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(0<=nx && nx< n && 0<= ny && ny < m && !v[nx][ny]&&temp[nx][ny]==0 ){
                    temp[nx][ny]=2;
                    v[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        int cnt = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(temp[i][j]==0) cnt++;
            }
        }
//        System.out.println(cnt);
        return cnt;
    }

}
