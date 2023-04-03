package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_19236_청소년_상어 {

	static class Shark {
		int x;
		int y;
		int dir;
		int eat;

		public Shark(int x, int y, int eat, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.eat = eat;
		}

	}

	static class Fish implements Comparable<Fish> {
		int x, y, n, dir;
		boolean die = false;

		public Fish(int x, int y, int n, int dir) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.dir = dir;
			
		}
		public Fish(int x, int y, int n, int dir,boolean die) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.dir = dir;
			this.die = die;
		}
		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub
			return this.n - o.n;
		}
		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", n=" + n + ", dir=" + dir + ", die=" + die + "]\n";
		}

	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, 
			     dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int Max_eat = 0;

	public static void main(String[] args) throws Exception {
		int[][] map = new int[4][4];
		List<Fish> fishs = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i<4;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j<4; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				fishs.add(new Fish(i,j,map[i][j],dir));
			}
		}
		
		Collections.sort(fishs);
//		System.out.println(fishs.toString());
		//상어 등장
		Fish f = fishs.get(map[0][0]-1);
		Shark shark = new Shark(0, 0, f.n, f.dir);
		f.die =true;
		map[0][0]=-1;

		
		dfs(map,shark,fishs);
		System.out.println(Max_eat);
	}
	static void dfs(int[][] arr,Shark s, List<Fish> list) {
		if(Max_eat<s.eat)
		Max_eat=s.eat;
		
		for(int idx =0 ; idx <16 ;idx++) {
			
			moveFish(list.get(idx),arr,list);
		
		}// 물고기가 이동한다.
		
		for(int d =1; d<4;d++) {
			int nx = s.x+dx[s.dir]*d;
			int ny = s.y+dy[s.dir]*d;
			
			if(inRange(nx, ny)&& arr[nx][ny]>0) {
				int[][] arr_c = copyArr(arr);
				List<Fish> list_c = copyFish(list);
				
				arr_c[s.x][s.y]=0;
				Fish f = list_c.get(arr_c[nx][ny]-1);
				Shark newShark = new Shark(f.x,f.y,(f.n+s.eat),f.dir);
				f.die=true;
				arr_c[f.x][f.y]=-1;
				
				
				dfs(arr_c,newShark,list_c);
			}
		}
	}
	
	static void moveFish(Fish f, int[][] map, List<Fish> Fishs) {
		if(f.die) return;
		
		for(int idx = 0; idx<8;idx++) {
			int nextdir = (f.dir+idx)%8;
			int nx = f.x+dx[nextdir];
			int ny = f.y+dy[nextdir];
			
			if(inRange(nx,ny)&&map[nx][ny]>-1) {
				map[f.x][f.y]=0;
				
				if(map[nx][ny]==0) {
					//이동하는 곳에 물고기가 없어요
					f.x = nx;
					f.y = ny;
				}else {
					//이동하는 곳에 물고기가 있어요
					Fish temp = Fishs.get(map[nx][ny]-1);
					temp.x = f.x;
					temp.y = f.y;
					map[temp.x][temp.y] = temp.n;
					
					f.x = nx;
					f.y = ny;
				}
				map[f.x][f.y]= f.n;
				f.dir = nextdir;
				
				return;
			}
			
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<4&&0<=y&&y<4;
	}
	static int[][] copyArr(int[][] arr){
		int[][] temp = new int[4][4];
		for(int i =0;i<4;i++) {
			for(int j =0;j<4;j++) {
				temp[i][j] = arr[i][j];
			}			
		}
		return temp;
	}
	
	static List<Fish> copyFish(List<Fish> list){
		List<Fish> temp = new ArrayList<>();
		for(Fish a: list) temp.add(new Fish(a.x,a.y,a.n,a.dir,a.die));
		return temp;
	}
}
