package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_6593_상범빌딩_bfs {
	static class node{
		int x,y,z;
		int cnt;
		
		public node(int x, int y, int z, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
		
	}
	static int[] dx = { 0, 0, 1, -1, 0, 0 }, dy = { 1, -1, 0, 0, 0, 0 }, dz = { 0, 0, 0, 0, 1, -1 };
	static char[][][] map;
	static boolean[][][] v;
	static int cnt = Integer.MAX_VALUE;
	static int L, R, C;
	static int sx, sy, sz;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String temp = br.readLine();
//			System.out.println(temp);
			StringTokenizer st = new StringTokenizer(temp);
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0) {
//				System.out.println("이거 발통이 되는거는 맞아..");
				break;}
			map = new char[L][R][C];
			v = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String t = br.readLine();
//					System.out.println(t+"데이터 입력 반는게 뭔지 확인용");
					char[] tmp = t.toCharArray();
					map[i][j] = tmp;
					for(int k= 0; k<C;k++) {
						if(tmp[k]=='S') {
							sz = i;
							sx = j;
							sy = k;
						}
					}
				}
				
				br.readLine();
			}
			cnt = bfs(sx,sy,sz);
//			System.out.println(cnt + "이것은 바로!");
			if (cnt == Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + cnt + " minute(s).");
			}
		}
	}

	static int bfs(int x, int y, int z) {
//		System.out.println("몇번뜨냐");
		Deque<node> q = new ArrayDeque<>();
		q.add(new node(x,y,z,0));
		v[z][x][y]=true;
		while(!q.isEmpty()) {
			node cur = q.poll();
			for(int d=0;d<6;d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y +dy[d];
				int nz = cur.z +dz[d];
				if(isRange(nx, ny, nz)&&map[nz][nx][ny]!='#'&&!v[nz][nx][ny]) {
					if(map[nz][nx][ny]=='E') {
						return cur.cnt+1;
					}
					v[nz][nx][ny]=true;
					q.add(new node(nx,ny,nz,cur.cnt+1));
				}
			}
			
		}
		return Integer.MAX_VALUE;
	}
	static boolean isRange(int x, int y, int z) {
		
		return 0<=x&&0<=y&&0<=z&&x<R&&y<C&&z<L;
	}
}
