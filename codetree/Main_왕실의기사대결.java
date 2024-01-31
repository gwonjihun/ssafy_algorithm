package gwonjihun.codetree;

import java.io.*;
import java.util.*;
public class Main_왕실의기사대결 {
	static int L,N,Q;
	static int[] dx = {-1,0,1,0}, dy= {0,1,0,-1};
	static int[][] map;
	static Night[] nights;
	class Night{
		//기사는 직사각형 형태이다 그래서 x,y를 시작으로 x+h-1, y+w-1까지의 영역을 가지고 움직인다.
		int x,y,h,w,k,dmg;
		//x,y 좌표이고
		//h높이 아래로, w 너비 오른쪽으로 
		//k 초기 체력, dmg는 데미지를 받았다는 의미 을 의미
		Night(int x,int y, int h,int w,int k ){
			this.x = x;
			this.y = y;
			this.h= h;
			this.w = w;
			this.k = k;
			this.dmg=0;
		}
		void hit(int x) {
			if(this.k-(this.dmg+x)<0) {
				this.x = -1;
				this.y= -1;
			}else {
				this.dmg+=x;
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map= new int[L+1][L+1];
		nights= new Night[N+1];
		for(int i = 1 ; i <= L; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= L ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0; 
		for(Night night : nights) {
			if(night.x !=-1) {
				result+=night.dmg;
			}
		}
		System.out.println(result);
	}
	
	//이동한 
	static void findBoom(int idx) {
		Night night = nights[idx];
		int cnt = 0;
		for(int x = night.x ; x<night.x+night.h;x++) {
			for(int y = night.y;y<night.y+night.y;y++) {
				if(map[x][y]==1) cnt++;
			}
		}
		night.hit(cnt);
	}
}
