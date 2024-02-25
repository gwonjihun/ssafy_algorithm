package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16235_aga {
	static class Tree {
		int x, y, age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	static int[][] map;// 이건 겨울철마다 추가되는 양분의 값
	static int N, M, K;// N 배열의 크기
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static Deque<Tree> t_D = new ArrayDeque<>();
	static int[][] eat;// 현재 먹을 수 있는 양분의 값들

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		eat = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(eat[i], 5);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			t_D.add(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken())));
		}
		while (day++ < K) {
			spring();
//			summer();
			fall();
			winter();
//			System.out.println("!!");
		}

		System.out.println(t_D.size());// 최종 살아있난 나무의 개수를 return해준다.
	}
	static void winter() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j<N ;j++) {
				eat[i][j] += map[i][j];
			}
		}
	}
	static void fall() {
		Deque<Tree> temp = new ArrayDeque<>();
		for(Tree t : t_D) {
			if (t.age%5 ==0)
			{
				temp.add(t);
			}
		}
		while(!temp.isEmpty()) {
			Tree t = temp.poll();
			for(int i=0;i<8;i++) {
				if(0<t.x+dx[i]&& t.x+dx[i]<=N && 0<t.y+dy[i]&& t.y+dy[i]<=N )
				t_D.addFirst(new Tree(t.x+dx[i],t.y+dy[i],1));
			}

//			System.out.println("456456456456");
		}
	}
	static void spring() {
		int size = t_D.size();
		Deque<Tree> die = new ArrayDeque<>();
		while (size > 0) {
//			System.out.println("!!?");
			Tree cur = t_D.pollFirst();
			if (cur.age <= eat[cur.x][cur.y]) {
				// 살아 남음
				eat[cur.x][cur.y] = cur.age;

				cur.age += 1;
				t_D.addLast(cur);
//				System.out.println("!!!");
			} else {
				die.add(cur);
			}
			size-=1;
		}

		while (!die.isEmpty()) {
			Tree cur = die.poll();
			eat[cur.x][cur.y]+= cur.age/2;
		}
	}
}
