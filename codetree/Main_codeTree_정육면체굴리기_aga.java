package CodeTree;

import java.io.*;
import java.util.*;

public class Main_codeTree_정육면체굴리기_aga {

    static int n,m,x,y,k;
    static int[] dice = new int[6]; // [맨위, 12,3,6,9, 맨 밑]으로 구성된다.
    static int[][] board;
    static int[] dx ={0,0,-1,1}, dy={1,-1,0,0};
    static void rotate(int dir){
        //dir 0,1,2,3로만 구성되고
        //0,1,2,3,4는 오, 왼, 상, 하로 회전되는것이다.
        int temp = dice[0];
        switch (dir) {
            case 0: //오 0,2,4,5가 차례대로 외전
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 1: //왼 0,2,4,5가 회죈
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 2: //상 0,1,3,5가 회전
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 3: //하 0,1,3,5가 회전
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while(k-->0){
            int dir = Integer.parseInt(st.nextToken())-1;
            int nx = x+ dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx,ny)) continue;
            rotate(dir);
            x= nx;
            y= ny;
            if(board[x][y]==0){
                board[x][y] = dice[5];
            }else{
                dice[5] = board[x][y];
                board[x][y] =0;
            }
            System.out.println(dice[0]);
        }

    }

    public static boolean inRange(int r,int c){
        return 0<=r&&r<n&&0<=c&&c<m;
    }

}
