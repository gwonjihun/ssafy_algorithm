package gwonjihun.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class test_1 {

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
            for(int[] apple : apples){
                int dir = people[2];
                System.out.println(Arrays.toString(people));
                if(people[2] == 0){
                    if(people[0] > apple[0]){
                        if(people[1] > apple[1]){
                            System.out.println("1111");
                            min_Cnt+= 3;
                            for(int a = 1; a<=3;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 3;
                            for(int a = 1; a<=4;a++) dir = (dir+3)%4;
                        }
                    }else if (people[0]<apple[0]){
                        System.out.println("111111");
                        if(people[1] > apple[1]){
                            min_Cnt+= 2;
                            for(int a = 1; a<=2;a++) dir = (dir+3)%4;
                        }else{
                            System.out.println("@@@@@@@@@");
                            min_Cnt+= 1;
                            for(int a = 1; a<=1;a++) dir = (dir+3)%4;
                        }
                    }else{}
                }
                else if(people[2] == 1){
                    if(people[0] > apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 1;
                            for(int a = 1; a<=1;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 2;
                            for(int a = 1; a<=2;a++) dir = (dir+3)%4;
                        }
                    }else if (people[0]<apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 3;
                            for(int a = 1; a<=3;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 3;
                            for(int a = 1; a<=4;a++) dir = (dir+3)%4;
                        }
                    }else{}
                }
                else if(people[2] == 2){
                    if(people[0] > apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 3;
                            for(int a = 1; a<=4;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 1;
                            for(int a = 1; a<=1;a++) dir = (dir+3)%4;
                        }
                    }else if (people[0]<apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 3;
                            for(int a = 1; a<=3;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 2;
                            for(int a = 1; a<=2;a++) dir = (dir+3)%4;
                        }
                    }else{}
                }
                else if(people[2] == 3){
                    if(people[0] > apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 2;
                            for(int a = 1; a<=2;a++) dir = (dir+3)%4;
                        }else{
                            min_Cnt+= 3;
                            for(int a = 1; a<=3;a++) dir = (dir+3)%4;
                        }
                    }else if (people[0]<apple[0]){
                        if(people[1] > apple[1]){
                            min_Cnt+= 1;
                            for(int a = 1; a<=1;a++) dir = (dir+3)%4;
                        }else{
                            System.out.println("!@#!@#");
                            min_Cnt+= 3;
                            for(int a = 1; a<=4;a++) dir = (dir+3)%4;
                        }
                    }else{}
                }

                people[0] = apple[0];
                people[1] = apple[1];
                people[2] = dir;
            }
            System.out.println();


            sb.append("#").append(t).append(" ").append(min_Cnt).append("\n");
        }
        System.out.println(sb);
    }
}
