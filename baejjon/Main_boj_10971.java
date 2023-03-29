package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_10971 {
	static int[][] map;
	static int n, cnt;
	static int[] select;
	static boolean[] visted;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visted = new boolean[n];
		for(int i = 0 ; i < n ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		select =new int[n];
		cnt =Integer.MAX_VALUE;
		perm(0);
		System.out.println(cnt);
	}
	
	public static void calc() {
		int temp =0;
		
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				if(map[select[i]][select[0]]==0) return;
				temp+=map[select[i]][select[0]];
			}else{
				if(map[select[i]][select[i+1]]==0) return;
				temp+=map[select[i]][select[i+1]];
			}
		}
		System.out.print("temp : " + temp+ " ");
		for(int a : select) {

			System.out.print(a + " ");
		}System.out.println();
		cnt = Math.min(cnt, temp);
		
	}
	
	public static void perm(int cnt) {
		if(cnt == n) {
			calc();
			return ;
		}
		for(int i = 0;i<n;i++) {
			if(!visted[i]) {
			visted[i]= true;
			select[cnt]=i;
			perm(cnt+1);
			visted[i]=false;
			}
		}
	}
}
