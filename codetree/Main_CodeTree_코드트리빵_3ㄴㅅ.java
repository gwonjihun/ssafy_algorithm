package gwonjihun.codetree;

import java.io.*;
import java.util.*;
 
//크게 1분 동안 3개의 동작을 진행한다
// 1. 격자의 모든 사람이 이동한다
// 2. 도착했다면 다른사람이 이동할 수 없고 이동을 멈춘다
// 3. t번 사람이 베이스캠프 내부에서 나와서 움직임의 리스트에 들어가진다.
// 3-> 도착지는 고정이고 베이스 캠프가 유동적으로 바뀌는대 해당 베이스 캠프는  행이 고 열이 작은 베이스 캠프로 들어가게된다.
// 
public class Main_CodeTree_코드트리빵_3ㄴㅅ {
	
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

		int t = 1;
		while(fm>0) {
			move();
			if(t<m) {
				insert(t);
//				System.out.println("!!!!!!!!");
			}
			t++;
			
		}
		System.out.println(t);
		
	}
	//static deque에 있는 size만큼만 이동을하면서
	//사람들의 idx기반 최종 목적지에 도착했는지 유무를 먼저 확인한다.
	//그리고 다음 초에 움직임에 대한 정보를 저장해놓는다.
	static void move() {
		int size = players.size();
		for(int i = 0 ; i < size;i++) {
			Player cur = players.poll();
			int idx = cur.idx;//이녀석은 그것이야 바로바로 목적지위치를 찾기 위한 idx
			Goal g = goals.get(idx);
			//이건 해당 idx가 이미 목적지에 도착해서 아무 의미가 없다는 의미야.
			if(g.x == -1 && g.y==-1) {
				continue;
			}
			//다음은 목적지를 이동하기 위한 이동 가능 경로들을 전부다 다음 시간에 움직여야하기 떄문에 poll을 해줘해야해ㅣ
			for(int d = 0 ; d<4;d++) {
				int nx = cur.x +dx[d];
				int ny = cur.y +dy[d];
				if(inRange(nx,ny)&&!v[idx][nx][ny]&&board[nx][ny]!=-1) {
					//1이면 도착지인지를 먼저 확인해야겠찌?
					if(g.x == nx && g.y == ny) {
						//플레이어가 원하던 최종 목적지에 도달했음을 의미하기때문에 board에서는 거길 갈 수가 없어
						board[nx][ny]=-1;
						fm--;
						g.x=-1;
						g.y=-1;
						break;
					}
					v[idx][ny][ny]= true;
					players.add(new Player(nx,ny,idx));
				}
			}
		}
	}
	static boolean inRange(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
	//time번 시간의 사람이 베이스켐프를 선택하는 동작을 진행한다.
	static void insert(int time) {
		Goal start = goals.get(time);
		boolean[][] v= new boolean[n][n];
		Deque<Goal> q = new ArrayDeque<>();
		q.add(new Goal(start.x,start.y));
		v[start.x][start.y]= true;
		while(!q.isEmpty()) {
			Goal cur = q.poll();
			for(int d= 0 ; d<4;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(inRange(nx,ny)&&!v[nx][ny]&&board[nx][ny]!=-1) {
					if(board[nx][ny]==1) {
						players.add(new Player(nx, ny, time));
						board[nx][ny]=-1;
						return;
					}
					v[nx][ny]=true;
					q.add(new Goal(nx, ny));
				}
			}
		}
		
	}


}
