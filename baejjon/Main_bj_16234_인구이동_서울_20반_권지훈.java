package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_bj_16234_?¸êµ¬ì´?™_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	/*
	 * 1. ?™„?ƒ?œ¼ë¡? ëª¨ë“  ë°°ì—´?˜ ?œ„ì¹˜ë?? ?ƒ?ƒ‰?•´ì¤??‹¤.
	 * 2. ?„ ?ƒ?œ ë°°ì—´?˜ ?œ„ì¹˜ì—?„œ ë¶??„° bfsë¡? ?ƒ?•˜ì¢Œìš°ë¥? ?ˆ?‹¤
	 * 3. 
	 * 4.?ƒ?•˜ì¢Œìš°ë¥? ?Œ?•Œ?Š” visited true?¸ ê³³ì? ?˜ˆ?™¸ë¡? ?‘”?‹¤
	 * 5.? „ë¶??‹¤ ?Œ?•˜?œ¼ë©? ê·¸ë•Œ?Š” visited 1?¸ ê³³ë“¤??   
	 * 6.
	 * */
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N,L,R;
	static Deque<node> q;
	static List<node> li;
	// li?— ?¸êµ? ?´?™ ì¢Œí‘œë¥? ???¥?•œ?‹¤..??—¥..?
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		//ë°°ì—´ ?°?´?„° ?…? ¥
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		//ë¬¸ì œ : ?–´?–»ê²? ë©ˆì¶œê²ƒì¸ê°??¸?°..
		while(true) {
			// 2ì¤? forë¬? + dfsë¡? ë­‰ì³? ¸ ?ˆ?Š” ê³³ì— ???•´?„œ ì°¾ì•„ì¤??‹¤.

			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for (int j=0; j<N; j++) {
					//?´ë¯? ?—°?•©?—?„œ ê³„ì‚°?œ ë¶?ë¶? ? œ?™¸
					if(visited[i][j]) continue;
					li = new ArrayList<>();
					//dfsë¡? ?¸êµ? ?´?™?´ ê°??Š¥?•œ ?œ„ì¹˜ì— ???•´?„œ li?— ???¥?•˜ê³?
					//???¥?˜?Š” ê³³ë§ˆ?‹¤?˜ ?¸êµ¬ìˆ˜ë¥? sum?•˜?—¬ return?•œ?‹¤.
//					System.out.println("dfs call");
					int sum = dfs(i,j);
					if(sum != map[i][j]) 
					{
						flag= false;
						change(sum);
					}//ë©ˆì¶”?Š” ë°©ë²•?? day?— ë³??•¨?´ ?—†?‹¤?Š”ê±? ?™•?¸?•˜?Š” ë°©ë²•?? -> sum 0?´?—¬?„œ flagë¥? trueë¡? ë³??™˜?•´ì¤??‹¤
					 //flagê°? true?´ë©? ê·¸ëƒ¥ ?„˜?–´ê°„ë‹¤
					 //
					 //?—¬ê¸°ì„œ?Š” li?— ???¥?˜?–´?ˆ?Š” ?œ„ì¹˜ì— sum/list.sizeê°’ì„ ê¸°ì??œ¼ë¡? ê°’ì„ ???¥?•´ì¤??‹¤

					//?´ê²? ì§„í–‰?˜ë©?
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