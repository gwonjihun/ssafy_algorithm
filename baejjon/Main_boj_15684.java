package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_15684 {

	static int[][] arr;//사타리를 만들꺼에요
	static int N,M,H;
	static int[] dy = {0,1,-1};
//	static boolean flag = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N];
		
		for(int i = 0 ; i < M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			arr[x][y]= 1;
			arr[x][y+1]= -1;
		}
		int answer = -1;
		for(int i = 0 ; i <=3;i++) {
//			System.out.println("!!!!!");
			comb(0,0,i);
//			if(flag) {
//				answer = i;
//				break;
//			}
		}
		System.out.println(-1);
	}
	static void comb(int idx, int depth,int end) {
//		if(flag) return;
		if(depth == end) {
//			System.out.println(end + " " + depth);
			if(check()) {
				System.out.println(end);
				System.exit(0);
			}
			return;
		}
//		int a = 0;
		for(int i = idx; i<N*H;i++) {
//			a++;
			int x = i/N;
			int y = i%N;
			if(y==N-1) continue;
			if(arr[x][y]!=0||arr[x][y+1]!=0) continue;
//			System.out.println(y);
			arr[x][y]= 1;
			arr[x][y+1]= -1;
			comb(i+2,depth+1,end);
			arr[x][y]= 0;
			arr[x][y+1]= 0;
			
		}
//		System.out.println(a);
	}
	static boolean check() {
		for(int i = 0 ; i < N;i++) {
			int currPosition = i;
            int start = 0;
            while (start < H) {
            	int dir =arr[start][currPosition];
                currPosition += dir;
                start++;
            }
//            System.out.println(start);
            if (i != currPosition)
                return false;
        }

        return true;
	}
}
