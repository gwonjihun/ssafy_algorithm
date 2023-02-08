package gwonjihun.baekjjon;
import java.util.*;
import java.io.*;
/*
 * 1. 종료가 가능한지를 먼저 체크한다. 
 * 2. 
 * 
 * */
public class Main_boj_17837_ing {
	
	static int[][] map,cnt,check;
	// map : 지도 내부의 색깔 정보
	// cnt : 위치마다 말의 갯수
	// check : 초기 성공 가능 여부 확인을 위한 정보
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int N,K;
	
	static List<node_12> li;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt= new int[N][N];
		check= new int[N][N];
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		li = new ArrayList<>();
		//데이터 입력 및 가능성 확인.
		for(int i=0; i<K;i++) {
			st= new StringTokenizer(br.readLine()," ");			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			li.add(new node_12(x, y, d));
			if(d<3) {
				for(int j=0;j<N;j++) {
					check[x-1][j]+=1;
				}
			}else{
				for(int j=0;j<N;j++) {
					check[j][y]+=1;
				}
			}
		}
		int ch= 0;
		for(int i=0; i<K;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]>=4) {
					ch++;
				}
			}
			
			
		}
		if(ch==0) { System.out.println(-1); return;}
	
	}

}

class node_12{
	int x;
	int y;
	int d;
	node_12(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
		
	}
}
