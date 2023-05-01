package gwonjihun.codetree;

import java.io.*;
import java.util.*;
/*
1. 경주 격자가 필요한가?
*/
public class Main_토끼잡는다 {
	
	
		
	static class Rabbit {
		int pid, dist, r, c, j_cnt, scr;
		boolean jump;

		Rabbit(int pid, int dist) {
			this.pid = pid;
			this.dist = dist;
			this.r = 1;
			this.c = 1;
			this.j_cnt = 0;
			this.scr = 0;
			boolean jump = false;
		}

	}

	static class compare_jump implements Comparator<Rabbit> {
		// 여기서는 점프를할 떄

		@Override
		public int compare(Rabbit o1, Rabbit o2) {
			// TODO Auto-generated method stub
			if (o1.j_cnt == o2.j_cnt) {
				if ((o1.r + o1.c) == (o2.r + o2.c)) {
					if (o1.r == o2.r) {
						if (o1.c == o2.c) {
							return o1.pid - o2.pid;
						} else
							return o1.c - o2.c;
					} else
						return o1.r - o2.r;
				} else
					return (o1.r + o1.c) - (o2.r + o2.c);
			} else
				return o1.j_cnt - o2.j_cnt;
		}

	}

	static class compare_scr implements Comparator<Rabbit> {

		@Override
		public int compare(Rabbit o1, Rabbit o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int N, M, P;
	static Rabbit[] rabbits;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			switch (Integer.parseInt(st.nextToken())) {
			case 100:
				init();
				break;
			case 200:
				game();
				break;
			case 300:
				change();
				break;
			case 400:
				System.out.println(end());
				return;
			}
		}
	}

	static void init() {
		P = Integer.parseInt(st.nextToken());
		rabbits = new Rabbit[P];
		for (int i = 0; i < P; i++) {
			int pid = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			rabbits[i] = new Rabbit(pid, dist);
		}
	}

	static void game() {
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		// k는 점프 횟수 S는 마지막 우선순위인 토끼가 얻는 점수
		PriorityQueue<Rabbit> j_q = new PriorityQueue<>(new compare_jump());

		for (int i = 0; i < P; i++) {
			rabbits[i].jump = false;
			j_q.offer(rabbits[i]);
		}
		for (int i = 0; i < K; i++) { // 점프할 수 있는 우선순위 큐

			Rabbit rb = j_q.poll();
			int tx = 0, ty = 0;
			for (int d = 0; d < 4; d++) {
				int dir = d;
				int len= rb.dist;
				if(d%2==0) {
					len = len%(2*(N-1));
				}// 점프를 하는 부분
				else {
					len = len%(2%(M-1));
				}
				int nx = rb.r + len*dir;
				int ny = rb.c + len*dir;
				
				if(tx+ty==nx+ny) {
					if(tx==nx) {
						if(ty<ny) {

							tx = nx;
							ty =nx;
						}
					}
					else if(tx<nx) {
						tx = nx;
						ty =nx;
						
					}
				}else if(tx+ty<nx+ny) {
					tx = nx;
					ty =nx;
				}
				
				
			}
			rb.r = tx;
			rb.c = ty;
			rb.j_cnt += 1;
			rb.jump = true;
			for (int s = 0; i < P; i++) {
				if (rabbits[s].pid != rb.pid) {
					rabbits[s].scr += tx + ty;
				}
			}
			j_q.offer(rb);
		}
		PriorityQueue<Rabbit> s_q = new PriorityQueue<>(new compare_scr());
		for (int i = 0; i < P; i++) {
			if (rabbits[i].jump) {
				s_q.offer(rabbits[i]);
			}
		}
		Rabbit r = s_q.poll();
		r.scr += S;
	}

	static void change() {
		int pid = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (Rabbit rabbit : rabbits) {
			if (rabbit.pid == pid) {
				rabbit.dist = k * rabbit.dist;
				return;
			}
		}
	}

	static int end() {
		int scr = -1;
		for (Rabbit rabbit : rabbits) {
			if (rabbit.scr > scr)
				scr = rabbit.scr;
		}
		return scr;
	}
}
