package gwonjihun.codetree;

import java.io.*;
import java.util.*;

import gwonjihun.codetree.Main_rotate.node;

public class Main_메이즈러너 {
	static class node {
		int x, y;

		node(int x, int y) {
			this.x = x;
			this.y = y;

		}

		@Override
		public String toString() {
			return "node [x=" + x + ", y=" + y + "]";
		}
	}

	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int n, m, k, cnt;
	static node exit;
	static ArrayList<node> persons;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		persons = new ArrayList<>();
		cnt = 0 ;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			persons.add(new node(x, y));
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		exit = new node(x, y);
		for (int i = 0; i < k; i++) {
			if (persons.size() == 0) {
				break;
			}

			move();
			l1:
			for(int l = 2; l<=n;l++) { // n : 4  l : 2 이면 r의 최대값은 0,1,2
				for(int r = 0 ; r<=n-l; r++) {
					for(int c= 0; c<=n-l;c++) {
						if(find(r,c,l)) {
//							System.out.println(r +" " +c +" " + l);
							rotate(r, c, r+l-1, c+l-1, l);
							break l1;
						}
					}
				}
			}
			
		}
		System.out.println(cnt);
		System.out.println((exit.x+1) + " "+ (exit.y+1));
//		for(int[] a : map)
//		System.out.println(Arrays.toString(a));
//		System.out.println("____________________________");
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));

	}
	static boolean find(int sx, int sy, int len) {
		// 0+2 ->0-1까지만 해야하닌깐 
		
		if(sx<=exit.x&&exit.x<sx+len&&sy<=exit.y&&exit.y<sy+len) {
			for(node p : persons) {
				if(sx<=p.x&&p.x<sx+len&&sy<=p.y&&p.y<sy+len) {
					return true;
				}
			}
			
		}
		return false;
	}
	static void move() {
		for (node p : persons) {
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 0) {
					if (Math.abs(nx - exit.x) + Math.abs(ny - exit.y) < Math.abs(p.x - exit.x)
							+ Math.abs(p.y - exit.y)) {
						p.x = nx;
						p.y = ny;
						cnt++;
						
						break;
					}
				}
			}
		}
		for(int i = 0 ; i < persons.size();i++) {
			node p = persons.get(i);
			if(p.x == exit.x && p.y == exit.y) {
				persons.remove(i);
				i--;
			}
		}
	}

	
	static void rotate(int sx, int sy, int ex, int ey, int len) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i <= ex - sx; i++) {
			for (int j = 0; j <= ey - sy; j++) {

				temp[sx + i][sy + j] = map[sx + len - 1 - j][sy + i]>0?map[sx + len - 1 - j][sy + i]-1:0 ;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = temp[i][j];
			}
		}
		int init_x =  exit.x- sx;
		int init_y =  exit.y- sy;
		//  sx,sy가 0,0으로 생각을 바꿔준다
		int temp_xs = init_x;
		init_x = init_y;
		init_y = len-1-temp_xs;
		
		exit.x =sx+ init_x;
		exit.y =sy+ init_y;
		for (node p : persons) {
//			System.out.println(p);
			if (sx <= p.x && p.x <= ex && sy <= p.y && p.y <= ey) {
				// 이뜻은 사람들이 해당 범위 에 있는 사람이라는 의미로
//				System.out.println("회전 ");
				init_x =  p.x- sx;
				init_y =  p.y- sy;
				//  sx,sy가 0,0으로 생각을 바꿔준다
				temp_xs = init_x;
				init_x = init_y;
				init_y = len-1-temp_xs;
				
				p.x =sx+ init_x;
				p.y =sy+ init_y;
			}
		}

//		System.out.println("--------이동후--------------");
//		for (node p : persons)
//			System.out.println(p);

//		System.out.println("exit : " + exit);
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
//		for(int[] a: map) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println("#################################");
	}
}
