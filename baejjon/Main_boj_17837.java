package Boj;

import java.io.*;
import java.sql.Array;
import java.util.*;
//위 문제는 말이 위에 있다고 못움직이는게 아니다.
//이동할 말 위에 다른 말이 있으면 같이 움직여지게 되는 것이기 때문에.
//q를 이용한다고하면 q의 temp가 필요해질 것이다 왜냐면
public class Main_boj_17837 {
    static class Node{
        int x,y,dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int N,K;
    static ArrayDeque<Integer>[][] state;//여기서 말의 위치를 관리해준다
    static int[][] map;// 여기서 각 타일별 상태 관리
    static Node[] nodes;//여기서는 말의 위치를 관리한다.
    static int[] dx={0,0,-1,1}, dy ={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        state = new ArrayDeque[N][N];
        map = new int[N][N];
        nodes = new Node[K];

        for(int i = 0 ;  i < N ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0 ; i < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = new ArrayDeque<>();
            }
        }

        for(int i = 0 ; i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;

            nodes[i] = new Node(x,y,d);
            state[x][y].add(i);
        }

        int t = 1 ;
        while(t<1001){
            for(int i = 0 ; i  < K;i++){
                //여기서 i가 가지고 있는 x,y를 찾야아함
                Node cur = nodes[i];
                int x= cur.x;
                int y = cur.y;
                int d = cur.dir;
                ArrayDeque<Integer> tmp = new ArrayDeque<>();
                while(state[x][y].peek()!=i&&!state[x][y].isEmpty()){
                    tmp.add(state[x][y].pollFirst());
                }


                state[x][y] = tmp;//이렇게해서 i보다 아래 있던 녀석들을 저장해놓는다.

            }
            //t가 증가하기전에 먼저 node들이 전부 움직여야한다.
            t++;
        }
        System.out.println(-1);
    }
}
