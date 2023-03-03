package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D0_5644_서울_20반_권지훈 {
	static class Charger  {
		int x;
		int y;
		int len;// 범위
		int c; // 용량
		Charger(int x, int y, int len, int c) {
			this.x = x;
			this.y = y;
			this.len = len;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Charger [c=" + c + "]";
		}
		

	}

	static int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };
	static int[] Alist, Blist;
	static int A;
	static Charger[] charger;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int x1 = 1;
			int y1 = 1;
			int x2 = 10;
			int y2 = 10;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			Alist = new int[N];
			Blist = new int[N];

			charger = new Charger[A];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Alist[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Blist[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int len = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				charger[i] = new Charger(x, y, len, c);
			}
			Arrays.sort(charger,(Charger o1, Charger o2) -> Integer.compare(o1.c, o2.c));
			// 여기까지가 입력의 끝이다
			// 아래부터는 0초부터 list의 끝까지 달리며 반복을 해줘야한다.
			int answer = chage(x1, y1, x2, y2);
			for (int time = 0; time < N; time++) {
				// 먼저 0일 때 충전기마다의 가능한 충전량을 확인한다.
				// 이때 둘의 index가 동일하면
				// 시간 단위닌깐 먼저
				x1 += dx[Alist[time]];
				y1 += dy[Alist[time]];
				x2 += dx[Blist[time]];
				y2 += dy[Blist[time]];
				answer += chage(x1, y1, x2, y2);

			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);

	}

//	static int chage(int x1, int y1, int x2, int y2) {
//		int[][] amount = new int[2][A];
//		// 2차원 배열에 사용자A(0)와 사용자B(1)의 BC별로 충전가능한 값을 저장해준다.
//
//		// 사용자A의 충전 가능한 BC의 p값
//		for (int j = 0; j < A; j++) {
//			amount[0][j] = charger(x1, y1, charger[j]);
//		}
//
//		// 사용자B의 충전 가능한 BC의 p값
//		for (int j = 0; j < A; j++) {
//			amount[1][j] = charger(x2, y2, charger[j]);
//
//		}
//
//		// 사용자 A와 사용자 B의 충전량의 합중 최댓값을 구해준다.
//		int max = 0;
//		for (int i = 0; i < A; i++) {
//			for (int j = 0; j < A; j++) {
//				int sum = amount[0][i] + amount[1][j];
//
//				// 같은 BC를 이용하는 경우 값을 반으로 나눠줘야한다.
//				// 주의할 점은 한 쪽은 아예 값이 0일수도 있으므로(해당 BC를 이용할 수 없는 위치) 정확히 둘다 같이 이용하고 있는 경우에만
//				// 나누어주어야한다.
//				if (i == j && amount[0][i] == amount[1][j])
//					sum /= 2;
//				if (sum > max)
//					max = sum;
//			}
//		}
//
//		return max;
//	}

	static int charger(int x, int y, Charger c) {
		int len = Math.abs(c.x - x) + Math.abs(y - c.y);
		if (len <= c.len) {
			return c.c;
		}
		return 0; //
	}
	
//	static int chage(int x1, int y1, int x2, int y2) {
//		// 여기서 먼저 a,b의 충전기 사용 가능량을 구한다? 근데 거기서
//		// a는 무조건 가장큰것을 주고 같은 상황이라면
//		int Amax = 0; // 가장 첫버째
//		int Bmax = 0;
//		System.out.println("--");
//		for (int i = 0; i < A; i++) {
//			// 여기서 비지니스 로직은
//			// 먼저 A를 채워준다
//			// 1. a,b가 1개밖에 없는 배터리를 동시에 쓸때
//			// a에게 하나 할 당해준다
//			// 2. a
//			int a = charger(x1, y1, charger[i]);
//			int b = charger(x2, y2, charger[i]);
//			
//			if (a == 0 && b == 0) {
//				continue;
//			}// 아무도 없을때는 맞아
//			// 2. a,b에 값에 대해서 생각할 때
//			// 3 10 0 -> Amax랑 값을 비교해서 넣어준다
//			// 4 10 10 -> 이거 일때는 Amax값이 0이면 -> Amax에 넣어준다
//			// 5 0 10 -> Bmax랑 값을 비교해서 넣어준다.
//			// 6 0 0 -> 아무 동작도 하면 안됨
//			System.out.println("a : " + a + " " + " b : " + b);
//			// Max값이 0 이 아니라는 뜻은 결국 가장
////			if(Amax!= 0 && Bmax != 0 ) break;
//			
//			if (a != 0 && b == 0) {
//				Amax =Math.max(Amax, a);
//				continue;
//			}
//			if (a == 0 && b != 0) {
//				Bmax = Math.max(Bmax, b);
//				continue;
//			}
//			if (a != 0 && b != 0) {
//				if(Amax!=0) {
//					Bmax = Math.max(Bmax, b);
//					
//				}else {
//					Amax = a;
//				}
//				
//			}
//			
//			
//		}
//		System.out.println("Amax : " + Amax +" " + "Bmax : " + Bmax);
//		return Amax + Bmax;
//	}
	static int chage(int x1, int y1, int x2, int y2) {
		// 여기서 먼저 a,b의 충전기 사용 가능량을 구한다? 근데 거기서
		// a는 무조건 가장큰것을 주고 같은 상황이라면
		int[][] cha_li = new int[A][2];
		for (int i = 0; i < A; i++) {
			// 여기서 비지니스 로직은
			// 먼저 A를 채워준다
			// 1. a,b가 1개밖에 없는 배터리를 동시에 쓸때
			// a에게 하나 할 당해준다
			// 2. a
			cha_li[i][0] = charger(x1, y1, charger[i]);
			cha_li[i][1] = charger(x2, y2, charger[i]);
		}
		int MAX = 0 ; 
		for(int i= 0 ; i <A;i++) {
			for(int j= 0 ; j <A;j++) {
				int sum = cha_li[i][0]+cha_li[j][1];
				if(i == j && cha_li[i][0]==cha_li[j][1]) {
					sum -= cha_li[i][1];
				}
				MAX = Math.max(MAX, sum);
			}	
		}
		
		return MAX;
	}

	// 이걸로 충전해주고
}
