package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_17143 {
	static class Node{
		int s,d,z;
		public Node(int s, int d, int z) {
			this.s= s;
			this.d=d;
			this.z=z;
		}
	}
	static int r,c,m;
	static Node[][] map;
	static Node[][] temp;//이동 후의 경우를 여기에 저장한다.
	static int total; // 잡은 상어의 전체 크기의 합
	static int[] dx= {-1,1,0,0}, dy= {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		total = 0 ;
		map = new Node[r][c];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c]= new Node(s,d,z);
		}
		
		for(int i = 0 ; i <c;i++) {
			peak(i);//상어를 잡는다.
			moveShark();//상어가 이동한다.
		}
		System.out.println(total);
	}
	
	static void peak(int y) {
		for(int i = 0 ; i <r;i++) {
			if(map[i][y]!=null) {
				total += map[i][y].z;
				map[i][y]= null;
				break;
			}
		}
	}
	static void moveShark() {
		temp = new Node[r][c];
		for(int i = 0 ; i < r;i++) {

			for(int j = 0 ; j<c;j++) {
				if(map[i][j]==null) continue;
				Node cur = map[i][j];
				int speed = cur.s;
				int dir = cur.d;
				int size = cur.z;
				
				if(dir/2<1) {
				//위아래
					speed %= (r-1)*2;
				}else {

					speed %= (c-1)*2;
				//좌우
				}
				int x= i; int y = j;
				for(int l = 0 ; l<speed;l++) {
					int nx = x+dx[dir];
					int ny = y+dy[dir];
				
					if(0>nx||nx>=r||0>ny||ny>=c) {
						dir = dir%2==0 ? dir+1 : dir-1;
					}
					x = x+dx[dir];
					y = y+dy[dir];
				}
				if(temp[x][y]!=null) {
					temp[x][y] = temp[x][y].z > size ? temp[x][y] : new Node(speed,dir,size);
				}else {
					temp[x][y] = new Node(speed,dir,size);
				}
				
			}
		}
		
		
		for(int i = 0 ;i<r;i++) {
			for(int j = 0; j<c;j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}
