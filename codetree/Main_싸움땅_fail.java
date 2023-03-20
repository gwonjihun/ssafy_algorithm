package gwonjihun.codetree;

import java.io.*;
import java.util.*;


public class Main_싸움땅_fail {
	static class person{
		int x,y,ablity,dir,gun;
		
		public person(int x, int y, int dir, int ablity, int gun) {
			super();
			this.x = x;
			this.y = y;
			this.ablity = ablity;
			this.dir = dir;
			this.gun = gun;
		}

		@Override
		public boolean equals(Object obj) {
			person other = (person) obj;
			if (x == other.x && y == other.y) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "person [x=" + x + ", y=" + y + ", ablity=" + ablity + ", dir=" + dir + ", gun=" + gun + "]\n";
		}
		
	}
	
	static ArrayList<Integer>[][] map;
	static person[] p_l;
	static int[] dx= {-1,0,1,0}, dy = {0,1,0,-1};
	static int[] point;
	static int n, m, k;// n : 맵 크키 ,  m은 플레이어수 k는 턴 수
///로 ↑, →, ↓, ←을 의미
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p_l = new person[m];
		point = new int[m];
		map = new ArrayList[n][n];
		for(int i = 0; i<n; i++) {
			for(int j= 0 ; j< n ; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j= 0 ; j< n ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp !=0) {
				map[i][j].add(tmp);
				}
			}
		}
		
		for(int i = 0; i < m ;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x =  Integer.parseInt(st.nextToken())-1;
			int y =  Integer.parseInt(st.nextToken())-1;
			int d =  Integer.parseInt(st.nextToken());// 방향
			int s =  Integer.parseInt(st.nextToken()); // 능력치
			p_l[i] = new person(x,y,d,s,0);
			
		}
		System.out.println(Arrays.toString(p_l));
		for(int i = 0; i<k;i++) {
			System.out.println("round :: "+ i );
			simulation();
		}
		
		answer();
	}
	static boolean inRange(int x, int y) {
		return 0<=x && x<n && 0<=y&& y<n;
	}
	// 왼 위 오 아
	static void simulation() {
		for(int i=0; i< p_l.length;i++){
			person cur_p = p_l[i];
			int[]  pos = move(cur_p);
			int fig_idx=check(pos);
			if(fig_idx==-1){
//				System.out.println(i+ ": 듀얼이 없음");
				
				int weapon = weapon_take(pos[0],pos[1]);//이거할때  drop해줘야함
				if(weapon> cur_p.gun) {
					drop_weapon(cur_p.x,cur_p.y, weapon);
					map[cur_p.x][cur_p.y].add(cur_p.gun);
					
				}
				p_l[i] = new person(pos[0],pos[1],pos[2], cur_p.ablity,  weapon);
			}else{
				//여기서사람들이 싸워야한단 말이지
				p_l[i] = new person(pos[0],pos[1], pos[2], cur_p.ablity, cur_p.gun);
				//여기서 해당 턴의 사람의 위치, 방향 값 갱신
				System.out.println(i+" vs "+fig_idx);
				fight(i, fig_idx);
			}
			
			System.out.println(i+"번째 사람 이동 종료");
			System.out.println(Arrays.toString(p_l));
		}
	}
	//로 ↑, →, ↓, ←을 의미
	static void fight(int idx1, int idx2){
		int pl_1_A = p_l[idx1].ablity+ p_l[idx1].gun;
		int pl_2_A = p_l[idx2].ablity+ p_l[idx2].gun;
		if(pl_1_A>pl_2_A){
//			System.out.println("111");
			lose(idx2);
			win(idx1);
			point[idx1] += (pl_1_A-pl_2_A);
		}else if(pl_1_A<pl_2_A){
//			System.out.println("2");
			lose(idx1);
			win(idx2);
			point[idx2] += (pl_2_A-pl_1_A);
		}else{
			if(p_l[idx1].ablity> p_l[idx2].ablity){
				System.out.println("3");
				lose(idx2);
				win(idx1);
			}else{
				System.out.println("44");
				lose(idx1);
				win(idx2);
			}
		}
	}
	static void lose(int idx){
		int cx = p_l[idx].x;
		int cy = p_l[idx].y;
		int cd = p_l[idx].dir;
		if(p_l[idx].gun==0){
		map[cx][cy].add(p_l[idx].gun);
		p_l[idx].gun = 0;
		}
		int nx;
		int ny;
		while(true){
			nx = cx +dx[cd];
			ny = cy +dy[cd];
			if(inRange(nx,ny) && check(new int[] {nx,ny}) ==-1)
				break;
			cd = (cd+1)%4;
		}
		int gun = weapon_take(nx,ny);
		p_l[idx].x = nx;
		p_l[idx].y = ny;
		p_l[idx].dir = cd;
		if(p_l[idx].gun<gun) {
			drop_weapon(nx,ny,gun);
			p_l[idx].gun = gun;
		}
		
	}
	static void win(int idx){
		p_l[idx].gun = Math.max(p_l[idx].gun,weapon_take(p_l[idx].x,p_l[idx].y));
	}
	static void drop_weapon(int x, int y,int gun) {
		ArrayList<Integer> weapons = map[x][y];
		int idx = -1;
		for(int i = 0 ;i < weapons.size();i++){
			if(weapons.get(i)==gun) {
				idx = i;
			}
		}
		if(idx!=-1) {
			weapons.remove(idx);
		}
	}
	static int weapon_take(int x, int y){
		//총이 없으면 -1,
		ArrayList<Integer> weapons = map[x][y];
		int gun = -1;
//		if(weapons.size()==0){return gun;}
		for(int i = 0 ;i < weapons.size();i++){
			gun = Math.max(gun,weapons.get(i));
		}
		return gun ;
	}
	static int check(int[] pos){
		// return : 없는경우는 -1, 플레이어가 있는 경우는 index를 리턴해준다
		//
		for(int i = 0 ; i< p_l.length;i++){
			if(p_l[i].x == pos[0] && p_l[i].y == pos[1]){
				return i;
			}
		}
		return -1;
	}
	static int[] move(person p){
		int cx = p.x;
		int cy = p.y;
		int cd = p.dir;
		int nx = cx+dx[cd];
		int ny = cy+dy[cd];
		if(!inRange(nx,ny)){
			cd = (cd+2)%4;
			nx = cx+dx[cd];
			ny = cy+dy[cd];
		}
		return new int[] {nx,ny, cd};
	}// 사람의 다음 위치를 구하는 함수
	static void answer() {
		for(int a : point) System.out.print(a+" ");
		System.out.println();
	}
	
	
	//true는 p1 false p2

}
