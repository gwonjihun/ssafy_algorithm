package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16920_2nd {
	static int n,m,p;
	static char[][] map;
	static ArrayDeque<int[]>[] pq;
	static int[] score,distance;//플레이어별 성의 영토 크기를 의미

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());

		
		pq = new ArrayDeque[p+1];
		for(int i = 0 ; i <=p ;i++) {
			pq[i] = new ArrayDeque<>();
		}
		score = new int[p+1];
		distance = new int[p+1];
		
		map = new char[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i< p ; i++) {
			distance[i+1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j< m ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]>'0') {
					int idx = map[i][j]-'0';
					pq[idx].add(new int[] {i,j});
					score[idx]++;
				}
			}
		}
//		for(int i = 1; i <= p; i++) {
//			System.out.print(score[i]+" ");
//		}
//		System.out.println();
		while(true) {
			boolean flag = true;
			
			for(int i = 1;i<=p;i++) {
				//여기서 bfs를 동작시킨다.
				if(pq[i].isEmpty()) {
					continue;
				}
				flag= false;
				bfs(i);
			}
			
			if(flag) {
				break;
			}
			
		}
		
		for(int i = 1; i <= p; i++) {
			System.out.print(score[i]+" ");
		}
		System.out.println();
		
		
		
	}
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static void bfs(int idx) {
		ArrayDeque<int[]> q = pq[idx];
		int size = distance[idx];
		for(int i = 0 ; i <size;i++) {
			int qsize = q.size();
			for(int s = 0; s<qsize;s++) {

				int[] cur = q.poll();
				
				for(int d = 0 ; d<4 ;d++) {
					int nx = cur[0]+dx[d];
					int ny = cur[1]+dy[d];
					
					if(0<=nx&&nx<n&&0<=ny&&ny<m&&map[nx][ny]=='.') {
						map[nx][ny] = (char) ('0'+idx);
						score[idx]++;
						q.add(new int[] {nx,ny});
					}
				}
			}
			if(q.isEmpty()) {
				return;
			}
		}
	}
}
