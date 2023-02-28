package gwonjihun.swea;

import java.util.*;
import java.io.*;
public class Solution_D0_1952_서울_20반_권지훈 {
    static int year, month_1, day_1,month_3;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 1 ; t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            day_1 = Integer.parseInt(st.nextToken());
            month_1 = Integer.parseInt(st.nextToken());
            month_3= Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            arr = new int[13];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 1; i<=12 ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = year;

            dfs(1,0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int month,int cost){
        if(month>12){
            answer = Math.min(answer,cost);
            return;
        }
        if (arr[month]>0){
            dfs(month+1,cost+day_1*arr[month]);
            dfs(month+1,cost+month_1);
            dfs(month+3,cost+month_3);
        }else{
            dfs(month+1,cost);
        }
    }
}
