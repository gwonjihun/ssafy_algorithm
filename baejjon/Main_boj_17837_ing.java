package gwonjihun.baejjon;
import java.util.*;
import java.io.*;

public class Main_boj_17837_ing {
// 지도 색상 관련 int 2차형 배열
// dxdy, 
// 말들 관리를 어떻게 할것이냐가 제일 중요한 부분인데...
// ArrayList 2차원으로 해서 진행한다고 하면 -> 
// ArrayList.merge를 이용해서 바로 뒤로 붙이면 될꺼같고	
	static class Chess{
		int x,y,dir;

		public Chess(int x, int y, int dir) {

			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	static int[] dx = {0,0,-1,1}, dy= {1,-1,0,0};
	static int N, K;
	static int time=0;
	static int[][]map;
	static Chess[] ches;
	static ArrayList<Integer>[][] C_map;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ches = new Chess[K+1];
		map = new int[N+1][N+1]; //인덱스 번호는 1부터 시작하닌깐.
		C_map = new ArrayList[N+1][N+1]; //인덱스 번호들로 체스의 위치를 관리해준다?
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1;j<=N;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				C_map[i][j]= new ArrayList<>();
			}
		}
		
		for(int i = 1;i<=K;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken())-1;
			ches[i] = new Chess(x,y,dir);
		}
		while(true) {
			time++;
			if(time>1000) {
				System.out.println(time);
				time = -1;
				break;
			}
			move();
		}
		System.out.println(time);
	}
	
	static void move() {
		for(int i = 1;i<=K;i++) {
			int dir = ches[i].dir;
			int x = ches[i].dir;
			int y = ches[i].dir;
			int nx = ches[i].dir;
			int ny = ches[i].dir;
			
			
			if(!inRange(nx,ny) || map[nx][ny]==2) {
				if(dir==0 || dir== 1) {
					ches[i].dir = 1-dir;
				}else {
					ches[i].dir = 5-dir;
				}
				//
				int cnx = x+dx[ches[i].dir];
				int cny = y+dy[ches[i].dir];
				if(!inRange(cnx,cny)|| map[cnx][cny]==2) continue;
				if(map[ny][nx]!=2) {
					i--;
					continue; //다시 i를 진행시켜야하기떄문에.
				}
			}else if(map[nx][ny]==0 || map[nx][ny]==1) {
				//옳기는 위치는 구해졌고.. 이제
				// 시작 위치의 말들이 몇개가 있는지 부터 확인하고 
				// 시작위치의 말들을 전부다 nx,ny로 갱신해주는 작업을 해줘야하는데
				// 갱신하기 전에 갱신 순서를 설정해줘야한다.
				boolean start = false;
				ArrayList<Integer> temp = new ArrayList<>();// 이사가야하는 체스목록
				for(int j=0;j<C_map[x][y].size();j++) {
					int num = C_map[x][y].get(j);
					if(num==i) {
						start = true;
						temp.add(i);
						C_map[x][y].remove(j);
						j--;
						continue;
					}
					if(start) {
						ches[num].y=nx;
						ches[num].x=ny;
						temp.add(num);
						C_map[x][y].remove(j);
						j--;
					}
				}
				
				ches[i].x= nx;
				ches[i].y= ny;
				if(map[nx][ny]==0) {
					for(int j = 0; j<temp.size();j++) {
						C_map[nx][ny].add(temp.get(j));
					}
				}else if(map[nx][ny]==1) {
					for(int j = temp.size()-1; j>=0;j--) {
						C_map[nx][ny].add(temp.get(j));
					}
				}
				
				if(C_map[nx][ny].size()>=4) { 
					System.out.println(time);
					System.exit(0);}
			}
			
		}
	}
	static boolean inRange(int x, int y) {
		return 0<x&&x<=N&&0<y&&y<=N;
	}
}
