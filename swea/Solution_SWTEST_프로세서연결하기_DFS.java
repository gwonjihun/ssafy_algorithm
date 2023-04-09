package gwonjihun.swea;

import java.io.*;
import java.util.*;

/*
1. List에 graph에 있는 프로레스를 모두 넣는다. (단, 격자의 경계선은 제외한다.
2. 그리고 dfs(int idx) -> dfs(0)을 통해서 프로세스 중 경계선이 아닌 내부에 있는 프로세스들에 대해서
idx를 통해 list에 있는 프로세스에 접근해서 프로세스를 전선을 통해 연결한다
dfs에서는 for문을0~3까지 dir4개의 방향을 정하고 방향을 정한뒤 while문을 통해서
map에 nx,ny가 0일때만  2라는 값을 할당한다 만약 0이 아닌 값을 만나면 바로 break해서 다음 dfs로 못넘어가게
진행해준뒤 
그리고 최종적으로 idx가 list.size()일떄 map에서 -1로 표시된 값들을 cnt해준다
  
*/
public class Solution_SWTEST_프로세서연결하기_DFS {

	static class node {
		int x, y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N;
	static int[][] map;
	static ArrayList<node> list;
	static int Min_length,Max_core;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			list = new ArrayList<>();
			
			Min_length = Integer.MAX_VALUE;
			Max_core = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0 && i>0 && j> 0 && j<N-1 && i<N-1) {
						list.add(new node(i, j));

					}
				}
			}
			dfs(0,0,0);
			System.out.println("#"+t+" "+Min_length);
		}
	}
	static void dfs(int idx,int ch_core,int cnt) {
		if(idx==list.size()) {
			if(ch_core>Max_core) {
				Max_core  = ch_core;
				Min_length = cnt;
				
			}else if(ch_core==Max_core) {
				if(cnt<Min_length) {
					Min_length = cnt;
				}
			}
			return;
		}
		node cur = list.get(idx);
		for(int d=0;d<4;d++) {
			int nx = cur.x; int ny = cur.y;
			int temp = 0;
			while(true) {
				nx +=dx[d];
				ny+=dy[d];
				if(!inRange(nx,ny)) {
					break;
				}
				if(map[nx][ny]!=0) {
					temp=0;
					break;
				}
				temp++;
			}
			nx = cur.x; ny = cur.y; 
			for(int i = 0 ;i<temp;i++) {
				nx += dx[d];
				ny += dy[d];
				map[nx][ny]= -1;
			}
			if(temp> 0) {
				dfs(idx+1,ch_core+1,cnt+temp);
				nx = cur.x; ny = cur.y;
				for(int i = 0 ; i <temp;i++) {
					nx += dx[d];
					ny += dy[d];
					map[nx][ny]=0;
				}
			}
		}// 4개 방향을 중 1개를 선택한 경우
		dfs(idx+1,ch_core,cnt); // idx프로세스를 선택안한 경우
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<N;
	}
}
/*
1
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
*/
