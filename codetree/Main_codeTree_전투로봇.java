package gwonjihun.codetree;

import java.io.*;
import java.util.*;

public class Main_codeTree_전투로봇 {

	static class Fish {
		int x, y, dist;

		public Fish(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	static int[][] arr;// fish가 있는 지도
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		Deque<Fish> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					q.add(new Fish(i, j, 0));
					arr[i][j] = 0;
				}
			}
		}
		int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
		int time = 0;
		int eat = 0, age = 2;
		while (true) {
			PriorityQueue<Fish> fishes = new PriorityQueue<>(new Comparator<Fish>() {

				@Override
				public int compare(Fish o1, Fish o2) {
					// TODO Auto-generated method stub
					if (o1.dist == o2.dist) {
						if (o1.x == o2.x)
							return o1.y - o2.y;
						return o1.x - o2.x;

					}
					return o1.dist - o2.dist;
				}
			});
			
			int[][] dist = new int[N][N];
			while(!q.isEmpty()) {
				Fish cur = q.poll();
				for(int d= 0 ; d<4;d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(0<=nx&&nx<N&&0<=ny&&ny<N&&dist[nx][ny]==0&&arr[nx][ny]<=age) {
						dist[nx][ny]=cur.dist+1;
						q.add(new Fish(nx, ny, cur.dist+1));
						if(arr[nx][ny] >= 1 && arr[nx][ny]<age) {
							fishes.add(new Fish(nx,ny,cur.dist+1));
						}
					}
				}
			}
			if(fishes.size()==0) {
				System.out.println(time);
				break;
			}
			Fish target = fishes.poll();
//			System.out.println(target.x + " " + target.y);
			eat++;
			time += target.dist;
			if(eat==age) {
				age++;
				eat=0;
			}
//			System.out.println("age : " + age + " eat : "+ eat);
			arr[target.x][target.y] = 0;
			q.add(new Fish(target.x,target.y,0));
		}
	}
}
