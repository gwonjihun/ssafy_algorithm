package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test_2 {

    static int[][] arr;
    static boolean[][] v;
    static int goal;
    static int N, min_Cnt;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static int Max_Apple;
    static List<int[]> apples;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            N = Integer.parseInt(br.readLine());
            apples = new ArrayList<>();
            arr = new int[N][N];
            goal = 1;
            min_Cnt = 0;
            Max_Apple = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] != 0) {
                        apples.add(new int[]{i, j, arr[i][j]});
                    }
                }
            }
            Collections.sort(apples, (o1, o2) -> Integer.compare(o1[2], o2[2]));

            int[] people = new int[] {0,0,0};
            for(int[] apple: apples){
//                dfs(people,people[] apple,0);
            }
            System.out.println();


            sb.append("#").append(t).append(" ").append(min_Cnt).append("\n");
        }
        System.out.println(sb);
    }
//    static void dfs(int[] peo, int[] app,int cnt,int cha){
//        //
//        if(cha >4){
//            return;
//        }
//        if(peo[2])
//    }
}
