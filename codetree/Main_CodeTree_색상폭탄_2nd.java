package CodeTree;

import java.io.*;
import java.util.*;
public class Main_CodeTree_색상폭탄_2nd {
    static class Bomb{
        int x,y,total,red;
        //x : 가장 큰 행 정보
        //y : 가장 작은 열 정보 -> 같은 행을 기준으로
        //total : 폭탄의 모든 수량
        //red : 빨간색 폭탄의 수량

        public Bomb(int x, int y, int total, int red) {
            this.x = x;
            this.y = y;
            this.total = total;
            this.red = red;
        }
    }
    static Bomb bestBomb;//최고 폭탄을 의미한다.


    static int n,m;
    static int[][] board;// 폭탄 지도
    static int score;
    static int[] dx= {0,0,1,-1}, dy ={1,-1,0,0};
    static boolean[][] visited;
    static void bombCompare(Bomb bomb){
        if(bomb.total<2) return;
        if(bestBomb.total<bomb.total){
            bestBomb= bomb;
        }else if(bestBomb.total==bomb.total){
            if(bestBomb.red>bomb.red){
                bestBomb=bomb;
            }else if(bestBomb.red==bomb.red){
                if(bestBomb.x< bomb.x){
                    bestBomb= bomb;
                }else if(bestBomb.x == bomb.x){
                    if(bestBomb.y> bomb.y){
                        bestBomb= bomb;
                    }

                }
            }
        }
    }
    //빨간 벽돌은 방문 여부와 상관없이
    static Bomb bfs(int sx,int sy){
        boolean[][] v = new boolean[n][n];//이걸로 처리해줄꺼임 암튼
        Queue<int[]> q = new ArrayDeque<>();
        int color = board[sx][sy];
        int total = 0 ;
        int red = 0;
        int maxX = -1;
        int miny = -1;
        q.add(new int[] {sx,sy});
        visited[sx][sy]= true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d= 0 ; d<4;d++){
                int nx= cur[0]+dx[d];
                int ny= cur[1] + dy[d];
                if(inRange(nx,ny)&&!v[nx][ny]&&(board[nx][ny]==color||board[nx][ny]==0)){
                    q.add(new int[] {nx,ny});
                    v[nx][ny]= true;
                    total++;
                    if(board[nx][ny]==color){
                        visited[nx][ny]=true;
                        if(maxX<nx){
                            maxX= nx;
                            miny= ny;
                        }else if(maxX== nx){
                            miny = Math.min(ny,miny);
                        }
                    }
                    if(board[nx][ny]==0){
                        red++;
                    }
                }
            }
        }

        return new Bomb(maxX,miny,total,red);
    }
    static void find(){
        //여기서 찾을때는 바로 그것
        //x,y를 돌면서 색상이 빨간색, 벽돌이 아닌 녀석들을 골라서
        //bfs를 돌려본다.
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j]<1) continue;
                if(visited[i][j]) continue;
                bombCompare(bfs(i,j));
                //
            }
        }
    }
    static void boom(){
        score+=(int) Math.pow(bestBomb.total,2);//점수부터 사전에 계산해주고
        int sx = bestBomb.x;
        int sy = bestBomb.y;
        int color = board[bestBomb.x][bestBomb.y];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        v[sx][sy] =true;
        board[sx][sy]= -2;//-2는 빈 공간을 의미한다.
        q.add(new int[] {sx,sy});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d= 0 ;d <4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(inRange(nx,ny)&&!v[nx][ny]&&(board[nx][ny]==color||board[nx][ny]==0)){
                    q.add(new int[] {nx,ny});
                    board[nx][ny]= -2;
                    v[nx][ny] =true;
                }
            }
        }
    }
    static void gravite(){
        for(int i = n-1 ; i >0;i--){
            for(int j = 0 ; j< n ; j++){
                if(board[i][j]!=-2) continue;
                for(int t = i-1;t>=0;t--){
                    if(board[t][j]==-1) break;
                    if(board[t][j]>=0){
                        board[i][j] = board[t][j];
                        board[t][j]= -2;
                        break;
                    }
                }
            }
        }
    }
    static void rotate(){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i<n;i++){
            for(int j = 0 ; j < n ; j++){
                temp[n-1-j][i] = board[i][j];
            }
        }
        board = temp;
    }
    static void printer(){
        System.out.println("______board printer()_______");
        for(int i = 0 ; i < n ; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    static boolean inRange(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        score= 0;
        for(int i = 0 ; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                board[i][j] =Integer.parseInt(st.nextToken());
            }
        }
//        visited = new boolean[n][n];

        while(true){
            visited = new boolean[n][n];
            bestBomb = new Bomb(-1,-1,0,0);
            find();//최고의 폭탄 묶음을 찾는다.
            if(bestBomb.x==-1&&bestBomb.y==-1){
                break;
            }
            boom();//폭발시킨다.
            gravite();
            rotate();
//            printer();
            gravite();
        }
        System.out.println(score);
    }
}
