package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동_서울_20반_권지훈{
	/*
	 * 1. ?��?��?���? 모든 배열?�� ?��치�?? ?��?��?���??��.
	 * 2. ?��?��?�� 배열?�� ?��치에?�� �??�� bfs�? ?��?��좌우�? ?��?��
	 * 3. 
	 * 4.?��?��좌우�? ?��?��?�� visited true?�� 곳�? ?��?���? ?��?��
	 * 5.?���??�� ?��?��?���? 그때?�� visited 1?�� 곳들??   
	 * 6.
	 * */
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N,L,R;
	static Deque<node> q;
	static List<node> li;
	// li?�� ?���? ?��?�� 좌표�? ???��?��?��..??��..?
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		//배열 ?��?��?�� ?��?��
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		//문제 : ?��?���? 멈출것인�??��?��..
		while(true) {
			// 2�? for�? + dfs�? 뭉쳐?�� ?��?�� 곳에 ???��?�� 찾아�??��.

			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for (int j=0; j<N; j++) {
					//?���? ?��?��?��?�� 계산?�� �?�? ?��?��
					if(visited[i][j]) continue;
					li = new ArrayList<>();
					//dfs�? ?���? ?��?��?�� �??��?�� ?��치에 ???��?�� li?�� ???��?���?
					//???��?��?�� 곳마?��?�� ?��구수�? sum?��?�� return?��?��.
//					System.out.println("dfs call");
					int sum = dfs(i,j);
					if(sum != map[i][j]) 
					{
						flag= false;
						change(sum);
					}//멈추?�� 방법?? day?�� �??��?�� ?��?��?���? ?��?��?��?�� 방법?? -> sum 0?��?��?�� flag�? true�? �??��?���??��
					 //flag�? true?���? 그냥 ?��?��간다
					 //
					 //?��기서?�� li?�� ???��?��?��?��?�� ?��치에 sum/list.size값을 기�??���? 값을 ???��?���??��

					//?���? 진행?���?
				}
			}
			if(flag) {
				break;
			}else {
				flag = true;
				day++;
			}
		}
		System.out.println(day);
		
	}
	static void change(int sum) {
		if(li.size()==0) return;
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
		li.add(new node(ix,iy));
		visited[ix][iy]= true;
		while(!(q.isEmpty())) {
			node t = q.pollFirst();
			int x = t.x;
			int y = t.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0>nx || 0>ny || N<=nx || N <=ny) continue;
				if (L<=Math.abs(map[x][y]-map[nx][ny])&& Math.abs(map[x][y]-map[nx][ny])<=R&& !(visited[nx][ny]))
				{
					li.add(new node(nx,ny));
					q.add(new node(nx,ny));
					visited[nx][ny]=true;
					cnt += map[nx][ny];
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