package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2193 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

        long [] answer = new long[N+1]; // 정수형 범위를 초과하는 것에 주의한다.

        answer[0] = 0;
        answer[1] = 1;



        for( int i =2; i<=N; i++){
            answer[i] = answer[i-1]+answer[i-2];
        }

        System.out.println(answer[N]);

    }
}