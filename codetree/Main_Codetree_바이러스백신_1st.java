package CodeTree;

import java.io.*;
import java.util.*;

public class Main_Codetree_바이러스백신_1st {

    static int n,m;
    static ArrayList<int[]> hospital;
    static boolean[] v;
    static int[][] board;//지도고 2로 다 바꿔놓고 진행하자
    static int minT = Integer.MAX_VALUE;
    static int virus = 0 ;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        hospital = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0 ){
                    virus++;
                }
                if(board[i][j]== 2){
                    hospital.add(new int[] {i,j});
//                    board[i][j] = 0;
                }
            }
        }
        v = new boolean[hospital.size()];

        comb(0,0);

        System.out.println(minT==Integer.MAX_VALUE?-1 : minT);



    }
    static void comb(int depth, int idx){
        if(depth == m){
            int time = bfs();//-1이 나오면 실패한것으로 처리해준다.
//            System.out.println(time);
            if(time>=0){
            minT = Math.min(time,minT);
            }
            return;
        }
        for(int i = idx; i< hospital.size();i++){
            v[i] = true;
            comb(depth+1,i+1);
            v[i]= false;
        }

    }
    static int bfs(){
        int heal = 0;
        int[] dx = {0,1,0,-1}, dy={1,0,-1,0};
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0; j<n ;j++){
                temp[i][j] =board[i][j];
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for(int i =0 ; i < hospital.size();i++){
            if(v[i]){
                int[] cur = hospital.get(i);
                q.add(cur);
                visited[cur[0]][cur[1]]=true;
            }

        }//병원 정보를 q에 전부다 넣어놔 줌.
        int time = 0;
        while(!q.isEmpty()&&virus!=heal){
            boolean flag = false;//이건 q에 들어가는 값이 0이 하나라도 있으면 true를 준다. 만약에 없다? 그러면 false를 하고 다음 날짜로
            //진행을 못하게 해준다.
            int size = q.size();
            for(int s = 0 ; s<size;s++){
                int[] cur = q.poll();
//                System.out.println(Arrays.toString(cur));
                for(int d = 0 ; d<4;d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visited[nx][ny]&&(temp[nx][ny]==0||temp[nx][ny]==2)){
                        q.add(new int[] {nx,ny});
                        if(temp[nx][ny]== 0 )heal++;
                        temp[nx][ny]=2;
                        visited[nx][ny] = true;
                    }
                }
            }
            time++;

        }

        if(heal==virus){
        return time;
        }else{
            return -1;
        }
    }
}
