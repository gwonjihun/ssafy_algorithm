package CodeTree;

import java.io.*;
import java.util.*;
public class Main_codeTree_원자충돌 {
    static int[] dx = {-1,-1,0,1,1,1,0,-1}, dy={0,1,1,1,0,-1,-1,-1};
    //짝수는 상하좌우 홀수는 대각선들
    static int n,m,k;
    static class Atom{
        int m,s,d;

        public Atom(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static List<Atom>[][] arr;
    static List<Atom>[][] temp;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n][n];
        temp = new ArrayList[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j< n ; j++){
                arr[i][j] = new ArrayList<>();
                temp[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            int m= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());

            arr[x][y].add(new Atom(m,s,d));
        }

        while(k-->0){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j< n ; j++){
                    temp[i][j] = new ArrayList<>();
                }
            }
            move();
//                break;

            split();
        }
        ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                if(arr[i][j].size()<=0) continue;
                for(Atom atom : arr[i][j]){
                    ans+= atom.m;
                }
            }
        }
        System.out.println(ans);
    }
    static void split(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                arr[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                int cnts = temp[i][j].size();
                if(cnts==1){
                    arr[i][j].add(temp[i][j].get(0));
                }else if(cnts >1){
                    int sumM = 0;//질량합
                    int sumS = 0;//속도
                    int[] dirtype = new int[2];
                    for(int at =0;at<cnts;at++ ){
                        sumS += temp[i][j].get(at).s;
                        sumM += temp[i][j].get(at).m;
                        dirtype[temp[i][j].get(at).d%2]++;

                    }
                    if(sumM/5==0) continue;
                    int nextDir;
                    if(dirtype[0]==0||dirtype[1]==0){
                        nextDir=0;//상하좌우
                    }else{
                        nextDir=1;
                    }
                    int atomCnt = temp[i][j].size();

                    for(int movedir = nextDir; movedir<8;movedir+=2){
                        arr[i][j].add(new Atom(sumM/5,sumS/atomCnt,movedir));
                    }

                }
            }
        }
    }
    static void print(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j].size());
            }
            System.out.println();
        }
    }
    static void tempprint(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j].size());
            }
            System.out.println();
        }
    }
    static void move(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                if(arr[i][j].size()<=0) continue;
                int size = arr[i][j].size();
                for(int k = 0 ; k < size;k++){
                    Atom cur = arr[i][j].get(k);
                    int nx = (i+dx[cur.d]*cur.s+n*cur.s)%n;
                    int ny = (j+dy[cur.d]*cur.s+n*cur.s)%n;
                    temp[nx][ny].add(cur);
                }
            }
        }
    }
}
