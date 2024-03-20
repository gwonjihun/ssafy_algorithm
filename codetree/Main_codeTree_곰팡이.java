package CodeTree;

import java.io.*;
import java.util.*;
public class Main_codeTree_곰팡이 {
        static class Dirty{
            int dir;
            int speed;
            int size;
            public Dirty(int speed,int dir,int size){
                this.dir = dir;
                this.size = size;
                this.speed = speed;
            }
        }
        static int n,m,k;
        // static int[][] arr;
        static int get;//먹는 곰팡이
        static Dirty[][] map;
        static int[] dx = {-1,1,0,0}, dy ={0,0,1,-1};
        //dir%2 = 0 -> dir+1 : dir-1;
        //움직임이 한사이클을 도는 경우는 2*(n-1)
        // static int cury = 0;
        static int ans = 0;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new Dirty[n][m];
            for(int i = 0 ; i < k;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken());
                map[x][y] = new Dirty(s,d,b);
            }
            for(int i = 0 ; i < m ; i++){
                get(i);
                move();
            }
            System.out.println(ans);
            // 여기에 코드를 작성해주세요.
        }
        static void get(int y){
            for(int i = 0 ;i<n;i++){
                if(map[i][y]!=null){
                    ans += map[i][y].size;
                    map[i][y]= null;
                    break;

                }
            }

        }

        static void move(){
            Dirty[][] temp = new Dirty[n][m];

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j]==null) continue;
                    int dir = map[i][j].dir;
                    int speed = map[i][j].speed;
                    int size = map[i][j].size;
                    // int len = speed;
                    int x =i;
                    int y = j;

                    if(dir/2<1){
                        //좌우
                        speed %= (n-1)*2;
                    }else{
                        //상하
                        speed %= (m-1)*2;
                    }
                    for(int l = 0 ; l<speed;l++){
                        int nx = x+dx[dir];
                        int ny = y+dy[dir];
                        if(!(0<=nx&&nx<n&&0<=ny&&ny<m)){
                            dir = dir%2==0?dir+1:dir-1;
                        }
                        x = x + dx[dir];
                        y = y + dy[dir];
                    }
                    if(temp[x][y]!=null){

                        temp[x][y] = temp[x][y].size>size? temp[x][y] : new Dirty(speed,dir,size);
                    }else{

                        temp[x][y] = new Dirty(speed,dir,size);

                    }
                }
            }

            for(int i = 0 ;i<n;i++) {
                for(int j = 0; j<m;j++) {
                    map[i][j] = temp[i][j];
                }
            }
        }
    }