package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_16235_aga_suc {

    static class Tree{
        int x,y,age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + x +
                    ", y=" + y +
                    ", age=" + age +
                    '}';
        }
    }
    static int N,M,K;
    static int[] dx ={-1,-1,-1,0,1,1,1,0}, dy = {-1,0,1,1,1,0,-1,-1};
    static int[][] arr; //영양분 현황
    static int[][] grow; //겨울철 추가되는 영양분
    static Deque<Tree> tDq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        grow = new int[N][N];

        tDq = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++){
            Arrays.fill(arr[i] , 5);
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                grow[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            tDq.add(new Tree(x,y,age));
        }
        while(K-- >0){
            //봄
            int size = tDq.size();
//            System.out.println("size : "+ size);
//            for(Tree tree : tDq){
//                System.out.println(tree);
//            }
//            for(int i = 0 ; i < N ;i++){
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println("@@@@@@@위는 겨울이 끝난 후이다.@@@@@@@@@@@@@@@222");
            Deque<Tree> die = new ArrayDeque<>();
            while(size-->0){

                Tree cur = tDq.poll();
                if(cur.age<=arr[cur.x][cur.y]){
                    //영양분을 먹고 성장할 수 있는 경우
                    arr[cur.x][cur.y] -= cur.age;
                    tDq.add(new Tree(cur.x,cur.y,cur.age+1));
                }else{
                    die.add(cur);
                }
            }
//            for(Tree tree : tDq){
//                System.out.println(tree);
//            }

//            System.out.println("@@@@@@@위는 봄이 끝난 후이다.@@@@@@@@@@@@@@@222");

            //여름
            for(Tree tree : die){
                arr[tree.x][tree.y] += tree.age/2;
            }

//            for(int i = 0 ; i < N ;i++){
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            System.out.println("@@@@@@@위는 여름이 끝난 후이다.@@@@@@@@@@@@@@@222");

            //가을
            Deque<Tree> spread = new ArrayDeque<>();
            for(Tree tree : tDq){
                if(tree.age%5==0){
                    spread.add(tree);
                }
            }
            for(Tree tree : spread){
                for(int d= 0 ; d<8;d++){
                    int nx = tree.x+ dx[d];
                    int ny = tree.y+ dy[d];
                    if(0<=nx && nx< N && 0<=ny &&ny<N){
                        tDq.addFirst(new Tree(nx,ny,1));
                    }
                }
            }

//            for(Tree tree : tDq){
//                System.out.println(tree);
//            }
//
//            System.out.println("@@@@@@@위는 가을이 끝난 후이다.@@@@@@@@@@@@@@@222");

            //겨울
            for(int i = 0 ; i <  N ; i++){
                for(int j = 0 ; j <  N ; j++){
                    arr[i][j]+=grow[i][j];
                }
            }
        }

        System.out.println(tDq.size());

    }


}
