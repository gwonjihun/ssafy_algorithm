package gwonjihun.codetree;

import java.io.*;
import java.util.*;
 
//크게 1분 동안 3개의 동작을 진행한다
// 1. 격자의 모든 사람이 이동한다
// 2. 도착했다면 다른사람이 이동할 수 없고 이동을 멈춘다
// 3. t번 사람이 베이스캠프 내부에서 나와서 움직임의 리스트에 들어가진다.
// 3-> 도착지는 고정이고 베이스 캠프가 유동적으로 바뀌는대 해당 베이스 캠프는  행이 고 열이 작은 베이스 캠프로 들어가게된다.
// 
public class Main_CodeTree_코드트리빵_2st {
	
	static class Player{
		int x,y,idx;//시작지점과, 목표정보를 가지고 있는 idx를 의미

		public Player(int x, int y, int idx) {
//			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Player [x=" + x + ", y=" + y + ", idx=" + idx + "]\n";
		}
		
	}
	static class Goal{
		int x,y;

		public Goal(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dx= {-1,0,0,1}, dy  = {0,-1,1,0};
	static int n,m;
	static ArrayDeque<Player> players;
	static ArrayList<Goal> goals;
	static int[][] board;
	static int t = 1;
	static int fm;
	static boolean[][][] v; //사람별 방문했던 기록을 하는 곳
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		//board 1 : 베이스캠프 , -1은 사용한 베이스캠프 or player가 도착한 편의점 위치를 의미 즉 방문 못하는 곳
		v = new boolean[m][n][n];//m은 사람 idx를 의미한다.
		players = new ArrayDeque<>();
		goals = new ArrayList<>();
		for(int i = 0 ; i <n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			goals.add(new Goal(x, y));
		}
		fm = m;
		//이건 사람이 편의점에 도착하면 1씩 감소시켜준다.
		insert(0);
		while(fm>0) {
			move();
			if(t<m) {
				insert(t);
				System.out.println("!!!!!!!!");
			}
			t++;
			
		}
//		sou
		
	}
	//time번 시간의 사람이 베이스켐프를 선택하는 동작을 진행한다.
	static void insert(int time) {
		System.out.println(time);
		Goal goal = goals.get(time);
		ArrayDeque<Goal> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		visited[goal.x][goal.y] =true;
		q.add(new Goal(goal.x,goal.y));
		while(!q.isEmpty()){
			Goal cur = q.poll();
			for(int d= 0 ; d<4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visited[nx][ny]&&board[nx][ny]!=-1) {
					if(board[nx][ny]==1) {
						players.add(new Player(nx, ny, time));
						System.out.println(nx + " " + ny + " " + time);
						board[nx][ny]=-1;
						v[time][nx][ny]= true;
						return;
					}
					visited[nx][ny]=true;
					q.add(new Goal(nx,ny));
				}
				
			}
			
			
		}
		
	}
	//static deque에 있는 size만큼만 이동을하면서
	//사람들의 idx기반 최종 목적지에 도착했는지 유무를 먼저 확인한다.
	//그리고 다음 초에 움직임에 대한 정보를 저장해놓는다.
	static void move() {
		int size = players.size();
		for(int i = 0 ; i < size;i++) {
			Player cur = players.poll();
			int idx = cur.idx;
			Goal tar = goals.get(idx);
			System.out.println(cur);
			System.out.println(tar.x + " " + tar.y);
			if(tar.x==-1&&tar.y==-1) continue;
			for(int d  = 0 ;d <4 ; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!v[idx][nx][ny]&&board[nx][ny]!=-1){
					if(nx == tar.x && nx==tar.y) {
						System.out.println(idx + "도착");
						board[nx][ny]=-1;
						tar.x=-1;
						tar.y=-1;
						fm--;
					}
					v[idx][nx][ny]=true;
					players.add(new Player(nx, ny, idx));
				}
			}
		}
	}

}
