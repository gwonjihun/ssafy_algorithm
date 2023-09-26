package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_14890 {

	static int N, L,cnt;
	static int[][] map;
	static int[] checks;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = 0;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0 ; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i ++ ) {
			if(check(i,0,0)) {
				cnt++;
			}
			if(check(0,i,1)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static boolean check(int x, int y, int dir) {
		int[] h = new int[N];
		boolean[] v = new boolean[N];
		
		
		for(int i = 0;i<N;i++) {
			if(dir==0) {
				h[i] = map[x][i];
			}
			else {
				h[i]= map[i][y];
			}
		}
		
		for(int i = 0 ; i<N-1;i++) {
			if(h[i]==h[i+1]) {continue;}
			else if(h[i]-1 == h[i+1]){
				//
				for(int j = i+1;j<i+1+L;j++) {
					if(j>N || v[j] || h[i+1] != h[j]) return false;
					v[j]=true;
				}
			}
			else if(h[i]+1== h[i+1]) {
				for(int j = i;j>i-L;j--) {
					if(j<0 || v[j] || h[i] != h[j]) return false;
					v[j]=true;
				}
			}else {
				return false;
			}
		}
		
		return true;
	}
}
