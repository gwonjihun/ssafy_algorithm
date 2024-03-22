package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_메이즈러너_2024_상반기 {
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x =x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	static int n;
	
	static int[][] wall;//벽이 있는 곳의 정보
	static int move =0;
	static int[] dx= {1,-1,0,0}, dy= {0,0,-1,1};
	static ArrayList<Node> q;
	static int m,k;
	static int ex,ey;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		q = new ArrayList<>();
		wall = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <n ;j++) {
				wall[i][j] =Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0 ; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
		}
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		wall[ex][ey]=-1;
		for(int t = 0 ;t<k;t++) {
			if(q.size()==0) {
				break;
			}
			move();
			rotates();
//			print();
//			System.out.println("____________");
		}
		System.out.println(move);
		System.out.println((ex+1)+" "+(ey+1));
	}


	static void print() {
		for(int i = 0 ; i < n ; i++) {
			System.out.println(Arrays.toString(wall[i]));
		}
		for(int j = 0 ; j<q.size();j++)
		System.out.println(q.get(j));
		System.out.println(ex + " " + ey);
	}
	static void rotate(int sx,int sy,int size) {
		int[][] temp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j<n;j++) {
				temp[i][j]= wall[i][j];
			}
		}
		for(int i = 0 ; i <size;i++) {
			for(int j = 0 ; j< size;j++) {
				wall[sx+i][sy+j] = temp[sx+size-(1+j)][sy+i]<=0?temp[sx+size-(1+j)][sy+i]: temp[sx+size-(1+j)][sy+i]-1;
				if(wall[sx+i][sy+j]==-1) {
					ex = sx+i;
					ey = sy+j;
				}
			}
		}
		for(int i = 0;i< q.size();i++) {
			Node cur = q.get(i);
			if(inRange(sx,sy,cur.x,cur.y,size)) {
				int x = cur.x- sx;
				int y = cur.y -sy;
				cur.y = sy+size-(1+x);
				cur.x = sx+y;
			}
		}
//		for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j<n;j++) {
//				wall[i][j]= temp[i][j];
//			}
//		}
	}
	static void move() {
		for(int i = 0;i< q.size();) {
			Node cur = q.get(i);
//			System.out.println(i);
			int cdist = dist(ex,ey, cur.x,cur.y);
			for(int d = 0 ;d<4;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&wall[nx][ny]<1) {
					int ndist = dist(ex,ey,nx,ny);
					if(ndist<cdist) {
						cur.x = nx;
						cur.y = ny;
						move++;
//						System.out.println(nx + " " + ny + " : " + ex + " " +ey);
						if(cur.x==ex&&cur.y==ey) {
							q.remove(i);
							i--;
						}
						break;
					}
				}
			}
			i++;
		}
	}
	static void rotates() {
		for(int size = 2; size<=n;size++) {
			for(int sx = 0; sx<n-size+1;sx++) {
				for(int sy = 0 ; sy<n-size+1;sy++) {
					if(!inRange(sx,sy,ex,ey,size)) continue;
					boolean flag = true;
					for(int i = 0;i< q.size();i++) {
						Node cur = q.get(i);
						if(inRange(sx,sy,cur.x,cur.y,size)) {
							flag = false;
							break;
						}
					}
					if(flag) continue;
					rotate(sx,sy,size);
					//이제 여기서부터 돌려줘야한다.
					//여기서 결국 돌아가는 곳이기 때문에
					return;
				}
			}
		}
	}
	static boolean inRange(int sx,int sy,int x, int y,int size) {
		return (sx<=x&&x<sx+size&&sy<=y&&y<sy+size);
	}
	static int dist(int x,int y, int nx,int ny) {
		return Math.abs(x-nx)+Math.abs(y-ny);
	}
}
