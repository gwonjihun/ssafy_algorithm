package gwonjihun.codetree;

import java.io.*;
import java.util.*;
 
//크게 1분 동안 3개의 동작을 진행한다
// 1. 격자의 모든 사람이 이동한다
// -> 최단 방향으로 움직여야하는데 이게 매 초마다 사람이 바뀌기 때문에 
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
	static ArrayList<Player> players;
	static ArrayList<Goal> goals;
	static boolean[] start[];
	static int[][] board;
	static int fm;
	static boolean[][][] v; //사람별 방문했던 기록을 하는 곳
	static int[][] dist;// bfs에서 idx번이 움직이는 거리를 기록하고 그걸 바탕으로 최소 거리를 찾아내는 과정이 필요하다;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		//board 1 : 베이스캠프 , -1은 사용한 베이스캠프 or player가 도착한 편의점 위치를 의미 즉 방문 못하는 곳
		v = new boolean[m][n][n];//m은 사람 idx를 의미한다.
		players = new ArrayList<>();
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

		int t = 0;
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

}
