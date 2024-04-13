package CodeTree;

import java.io.*;
import java.util.*;
public class Main_CodeTree_청소는즐거워_2nd {
    static int[][][] spreadPer = {
            {
                    {0,0,2,0,0},
                    {0,10,7,1,0},
                    {5,0,0,0,0},
                    {0,10,7,1,0},
                    {0,0,2,0,0}
            },{
            {0,0,0,0,0},
            {0,1,0,1,0},
            {2,7,0,7,2},
            {0,10,0,10,0},
            {0,0,5,0,0}
    },{
            {0,0,2,0,0},
            {0,1,7,10,0},
            {0,0,0,0,5},
            {0,1,7,10,0},
            {0,0,2,0,0}
    },{
            {0,0,5,0,0},
            {0,10,0,10,0},
            {2,7,0,7,2},
            {0,1,0,1,0},
            {0,0,0,0,0}
    }
    };
    static int n;
    static int[][] dust;//격자에 있는 먼지를 의미.
    static int out;
    static int[][] dirs;
    static int dustX,dustY;
    static int[] dx ={0,1,0,-1}, dy = {-1,0,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dust = new int[n][n];
        dirs = new int[n][n];
        dustX = n/2; dustY = n/2;
        initDir();
//        for(int i = 0 ; i < n ; i++){
//            System.out.println(Arrays.toString(dirs[i]));
//        }
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                dust[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        out = 0;
        while(dustX!=0||dustY!=0){
            //여기서 이제 청소를 시작하는 것인데.
            int dir = dirs[dustX][dustY];
            dustX+=dx[dir];
            dustY+=dy[dir];
//            System.out.println(dustX + " " + dustY);
            clean(dustX,dustY,dir);


        }
        System.out.println(out);
    }
    static boolean inRange(int x,int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }
    static void clean(int x,int y,int dir){
//        System.out.println(dir + " !@#!@#!@#!@#");
        int dustCnt = dust[x][y];
        int spreadCnt= 0;// 이건 주변으로 퍼진 양을 말하고.
        for(int i = 0 ; i < 5; i++){
            for(int j = 0 ; j < 5; j++){
                int nx = x-2+i;
                int ny = y-2+j;
                int mvDust = dustCnt*spreadPer[dir][i][j]/100;
                //이게 nx,ny로 가질 먼지의 양이잖아.
                if(inRange(nx,ny)){
                    dust[nx][ny]+=mvDust;
                }else{
                    //외부로 나가게된 먼지
                    out+=mvDust;
//                    System.out.println("out : " + out);
                }
                spreadCnt+=mvDust;
            }
        }

        int nx = x+dx[dir];
        int ny = y+dy[dir];
//        System.out.println(x + " " + y);
//        System.out.println(nx + " " + ny);
        if(inRange(nx,ny)){
        dust[nx][ny] += dustCnt-spreadCnt;
        }else{
            out+= (dustCnt-spreadCnt);
//            System.out.println("A out " + (dustCnt-spreadCnt));
        }
    }
    static void initDir(){
        int curX = dustX;
        int curY = dustY;
        int curDir = 0;
        int moveNum = 1;
        while(curX!=0||curY!=0){

            for(int i = 0 ; i < moveNum;i++){
                dirs[curX][curY] = curDir;
//                System.out.println(curX+" , "+ curY);
                curX += dx[curDir]; curY+=dy[curDir];

                if(curX==0&&curY==0){
                    break;
                }
            }

            curDir = (curDir+1)%4;
            if(curDir==0||curDir==2){
                moveNum++;
            }

        }
    }
}
