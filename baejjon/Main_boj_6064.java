package Boj;

import java.io.*;
import java.util.*;

public class Main_boj_6064 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int result = -1;
            boolean flag = false;
            for(int i = x ; i<(N*M) ; i+=M){
                if(i%N==y){
                    flag =true;
                    result = i+1;
                    break;
                }
            }

        if(!flag){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
        }
    }
}
