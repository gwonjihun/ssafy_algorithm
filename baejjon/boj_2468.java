package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2468 {
    static int[][] arr;
    static boolean[][] checked;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // max 빗물 ?��?��
        int Maxh = 0;

        //map data input
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]>Maxh){
                    Maxh = arr[i][j];
                }
            }
        }
//        System.out.println(Maxh);
        int answer =0;
//        for(int h= 0;h<Maxh+1;h++){
        	for(int h= Maxh;h>=0;h--){
            checked = new boolean[n][n];
            int cnt = 0;
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(!checked[x][y] && arr[x][y]>h){
                        cnt += dfs(x,y,h);
//                        cnt += bfs(x,y,h);
//                        ?��기서 그래?�� ?��?��?�� ?��?��?�� ?��?��?��?��?�� ?��?��?��?��?�� �?�? 체크?��주기
                    }
                }

            }

            answer = Math.max(answer,cnt);
//            System.out.println("temp: " + answer);
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y, int h){
        //
        checked[x][y]=true;
        for(int i=0 ; i< 4 ; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0|| ny<0|| nx>=n || ny>=n) continue;
            if(checked[nx][ny]) continue;
            if (arr[nx][ny] > h){
                dfs(nx,ny,h);
            }
        }
        return 1;
    }
}
