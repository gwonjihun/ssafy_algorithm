package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16954_aga {

	static char[][] map;
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0 }, dy = {0, -1, 0, 1, 1, 1, 0, -1, -1 };
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		
		for(int i = 0 ; i <  8;i++) {
			map[i]= br.readLine().toCharArray();
		}
		
		bfs(7,0);
	}
	
	static void bfs(int x,int y) {
		
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int size = q.size();

			boolean[][] v=  new boolean[8][8];
			for(int i = 0 ; i < size;i++) {
				int[] cur = q.poll();
				if(map[cur[0]][cur[1]]=='#') continue;
				if(cur[0]==0&& cur[1]==7) {
					System.out.println(1);
					return;
				}
				for(int d= 0 ; d<9;d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					if(0<=nx&&nx<8&&0<=ny&&ny<8&&!v[nx][ny]&&map[nx][ny]=='.') {
						v[nx][ny]= true;
						q.add(new int[] {nx,ny});
					}
				}
			}
			for(int i = 7;i>0;i--) {
				map[i]= map[i-1];
			}
			map[0]= new char[8];
			Arrays.fill(map[0], '.');
//			System.out.println("--------------");
		}
		System.out.println("0");
	}
}
