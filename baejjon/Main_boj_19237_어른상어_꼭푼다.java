package gwonjihun.baejjon;
import java.io.*;
import java.util.*;
/*
1. 1번 상어는 무조건 어른 상어들을 쫓아 낼수 있다.
2. bfs의 조건이 
2-1 인접한 칸중에 아무 냄새가 없는 칸으로 간다
2-2 아무 냄새 없는 칸이 여러개일때 상어는 자식의 방향에 따라 우선순위를 가지고 탐색하게된다
2-3 이동한 방향으로 dir이 바뀌게 된다.
*/
public class Main_boj_19237_어른상어_꼭푼다 {
	static class Shark{
		int num, x,y,c_dir;
		int[][] rank;
		
	}
	static class perpum{
		int num,time;
	}
	static int[] dx = {-1,1,0,0}, dy= {0,0,-1,1};
	static int[][] map;// -> 초기 위치배열을 받아온다
	static perpum[][] graph;//여기는 상어의 채취를 기록하는 배열
	//상어는 동시에 움직인다. 그렇다면 temp를 가지고 움직여야하는데
	static int N,M,K;// n : 지도의 크기 m : 상어의 개수 k: 냄새가 남는 시간
	static List<Shark> sh; // 상어의 위치리스트
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		map = new int[N][N];
		graph = new perpum[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					
				}
			}
		}
		int time = 0;
		int answer = -1;
		while(time<1000) {
			if(sh.size()==0)
			{	answer =time;
				break;}
		}
		System.out.println(answer);
	}
	
	//상어를 동시에 움직인다.
	static void move() {
		int[][] temp = new int[N][N];
		for(Shark shk : sh) {
			boolean flag = false;
			// flag 를 통해서 4방 탐색 결과에 따라 냄새없는 공간이 없으면 false 
			// 다음 이동가능 지역이 있으면 true로 하여서 보내준다.
			for(int d = 0 ; d<4;d++) {
				
			}
			//인접한 칸에 냄새가 전부 있고? 
			if(flag) continue;
			for(int dir : shk.rank[shk.c_dir]) {
				int nx = shk.x+dx[dir];
				int ny = shk.y+dy[dir];
				if(graph[nx][ny].num == shk.num) {
					//여기
					if(temp[nx][ny]==1) {
						break;
					}
					temp[nx][ny] = shk.num;
					shk.c_dir = dir;
					break;
				}
			}
			
		}
		
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j<N; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	static void perpum_down() {
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(graph[i][j].time==1) {
					graph[i][j] = null;
				}else {
				graph[i][j].time-=1;
				}
			}
		}
	}
}
