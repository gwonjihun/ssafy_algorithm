package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CdoeTree_영양제이사 {
    static int n,m;
    static int[][] tree;

    static ArrayDeque<int[]> drug;
    //영양제를 여기다가 넣어놔주고. x,y로 관리해준다
    //나의 계획은 deque에서 꺼내서 이동시켜준다 그렇게 된다면
    // v가 true가 될것이고 true인 곳에서는 대각선을 조회한다.
    // v가 false라면 나무의 길이를 조회하고 약을 자를뒤에 약을 넣어주는 방식으로 진행나다.

    static boolean[][] v; //약이 투입된 곳만을 관리해준다.
    //처음에는

    static int[] dx = {0,-1,-1,-1,0,1,1,1}, dy = {1,1,0,-1,-1,-1,0,1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n][n];
        drug= new ArrayDeque<>();
        for(int i = n-2; i<n;i++){
            for(int j = 0 ; j <2;j++){
                drug.add(new int[] {i,j});
            }
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < m ; i++){
            v = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken())-1;
            int len = Integer.parseInt(st.nextToken());
            move(dir,len);//이동

            deep();//심기 및 성장 
//            System.out.println("심고 성장");
//            for(int z = 0 ; z < n ; z++){
//            System.out.println(Arrays.toString(tree[z]));
//            }
            sell();//팔기및 약사기
//            System.out.println("팔기 약사기");
//            for(int z = 0 ; z < n ; z++){
//                System.out.println(Arrays.toString(tree[z]));
//            }
//            System.out.println(drug.size() + " 영양제 개수");
        }
        result();


    }
    static void sell(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!v[i][j]&&tree[i][j]>1){
                    tree[i][j]-=2;
                    drug.add(new int[] {i,j});

                }            }
        }
    }
    static void deep(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(v[i][j]){
                    tree[i][j]+=1;
                }
            }
        }
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!v[i][j]) continue;
                int cnt = 0;
                for(int d= 1 ; d<8;d+=2){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(0<=nx&&nx<n&&0<=ny&&ny<n&&tree[nx][ny]>0){
                        cnt++;
                    }
                }
                temp[i][j]= cnt;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                tree[i][j]+=temp[i][j];
            }
        }
    }
    static void move(int d, int l){
        while(!drug.isEmpty()){
            int[] cur = drug.poll();
            int nx = (cur[0] +dx[d]*l+n)%n;
            int ny = (cur[1]+dy[d]*l+n)%n;
            v[nx][ny]=true;
        }
    }
    static void result(){
        int re = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                re += tree[i][j];
            }
        }
        System.out.println(re);
    }
}
