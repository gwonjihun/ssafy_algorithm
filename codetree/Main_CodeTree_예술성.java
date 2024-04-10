package CodeTree;

import java.io.*;
import java.util.*;

/**
 * 전체 탐색하면서 bfs를 통해서 영역을 만들어 준다.
 *
 */

public class Main_CodeTree_예술성 {
    static int n;
    static int[][] map;

    static int[][] groupnum;
    static int[][] temp;
    //이걸
    static boolean[][] visited;

    static ArrayList<Integer> groupCnt;
    static int score = 0;
    static int[] dx = {-1,0,1,0}, dy= {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int i = 0 ; i < n  ; i ++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        for(int r = 0 ; r<= 3; r++){
            int groupMax = 0;
            groupnum = new int[n][n];
            visited = new boolean[n][n];
            groupCnt = new ArrayList<>();

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j< n ; j++){
                    if(visited[i][j]) continue;
                    bfs(i,j,groupMax);
                    groupMax++;
                }
            }
            calcurate();//예술성을 계산하기 위한 곳
//        System.out.println(score);
            if(r!=3){
            rotate();//회전한다.
            }
        }
//        for(int i = 0 ; i < n ; i++){
//            System.out.println(Arrays.toString(groupnum[i]));
//        }
//        for(int a : groupCnt){
//            System.out.print(a +" ");
//        }
//        System.out.println();
        System.out.println(score);

    }
    static void rotate(){
        temp = new int[n][n];
        //지도 copy를 위해서 쓰는 임시 배열\
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[n-1-j][i] = map[i][j];
            }
        }
//        System.out.println("temp 십자가 부분 회전 결과");
        for(int p =0 ; p <4;p++){
            partrotate(p);
        }
//        for(int i = 0 ; i <n ; i++){
//            System.out.println(Arrays.toString(temp[i]));
//        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                map[i][j]= temp[i][j];
            }
        }
//        System.out.println("!");
    }
    static void partrotate(int part){
        int sx = (n/2+1)*(part/2);
        int sy = (n/2+1)*(part%2);
//        System.out.println(sx + " :  " + sy);
        for(int i = 0 ; i<n/2;i++){
            for(int j = 0 ; j < n/2;j++){
                temp[sx+ i][sy + j] = map[sx + n/2 -1-j][sy+i];
            }
        }
    }
    static void calcurate(){
        int tempscore = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int startidx = groupnum[i][j];
                int startnum = map[i][j];
                for(int d=0 ; d<2; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(0<=nx&&nx<n&&0<=ny&&ny<n){
                        int endidx = groupnum[nx][ny];
                        int endnum = map[nx][ny];
                        if(startidx==endidx) continue;
                        tempscore += (groupCnt.get(startidx)+groupCnt.get(endidx))*startnum*endnum;
                    }
                }

            }
        }
//        System.out.println("회전 후 해당 예술 점수 " + tempscore);
        score += tempscore;

    }
    //나는 여기서 x,y를 시작점으로하여서
    //map[x][y]와 같은 값들만은 탐색해서
    //groupnum에다가 groupidx를 할당해 줄 것이야.
    static void bfs(int x,int y, int gNum){
        int num = map[x][y];//이거랑 같은 녀석들만을 찾아다닐것이야.
//        System.out.println(gNum);
//        System.out.println(num);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        visited[x][y]= true;
        groupnum[x][y] = gNum;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d= 0 ; d<4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(!(0<=nx&&nx<n&&0<=ny&&ny<n)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny]!=num) continue;

                groupnum[nx][ny] = gNum;
                visited[nx][ny] = true;
                q.add(new int[] {nx,ny});
                cnt++;
//                    System.out.println("!!!!");

            }
        }
        groupCnt.add(cnt);

    }

}
