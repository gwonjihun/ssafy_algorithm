package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_boj_21608_서울 {
	static int[][] map; // 학생이 앉는 지도
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static int N;
	static int[][] student;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		student = new int[N*N][5];
		map = new int[N][N];
		for(int i=0; i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			int num4 = Integer.parseInt(st.nextToken());
			student[i] = new int[] {num,num1,num2,num3,num4};
		}
		for(int i = 0;i < N*N;i++) {
			//여기서 이제 student배열에 대해서 진행하는
//			if()
		}
		
	}
}
