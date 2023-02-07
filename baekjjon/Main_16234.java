package gwonjihun.baekjjon;

import java.io.*;
import java.util.*;

public class Main_16234 {
	/*
	 * 1. 완탐으로 모든 배열의 위치를 탐색해준다.
	 * 2. 선택된 배열의 위치에서 부터 bfs로 상하좌우를 돈다
	 * 3. 
	 * 4.상하좌우를 돌때는 visited true인 곳은 예외로 둔다
	 * 5.전부다 돌았으면 그때는 visited 1인 곳들은   
	 * 6.
	 * */
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N,L,R;
	static Deque<node> q;
	static List<node> li;
	// li에 인구 이동 좌표를 저장한다..?엥..?
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		//배열 데이터 입력
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		while(!flag) {
			// 2중 for문 + dfs로 뭉쳐져 있는 곳에 대해서 찾아준다.

			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for (int j=0; j<N; j++) {
					//이미 연합에서 계산된 부분 제외
					if(visited[i][j]) continue;
					li = new ArrayList<>();
					//dfs로 인구 이동이 가능한 위치에 대해서 li에 저장하고
					//저장되는 곳마다의 인구수를 sum하여 return한다.
					int sum = dfs(i,j);
					//여기서는 li에 저장되어있는 위치에 sum/list.size값을 기준으로 값을 저장해준다
					change(sum);
					//이게 진행되면
				}
			}
			if(!flag) {
				day++;
			}
		}
		
		
	}
	static void change(int sum) {
		int avg = sum/li.size();
		for(node p : li) {
			map[p.x][p.y]= avg; 
		}
	}
	static int dfs(int ix, int iy) {
		int cnt = 0;
		cnt += map[ix][iy];
		q = new ArrayDeque<>();
		q.add(new node(ix,iy));
		visited[ix][iy]= true;
		while(!(q.isEmpty())) {
			node t = q.pollFirst();
			int x = t.x;
			int y = t.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0>nx && 0>ny && N<=nx && N <=ny) continue;
				if (L<=Math.abs(map[x][y]-map[nx][ny])&& Math.abs(map[x][y]-map[nx][ny])<=R&& visited[nx][ny]
						) {
					q.add(new node(nx,ny));
					visited[nx][ny]=true;
					cnt +=
				}
			}
		}
		return cnt;
	}
	
}
class node{
	int x,y;
	node(int x, int y){
		this.x=x;
		this.y=y;
	}
}