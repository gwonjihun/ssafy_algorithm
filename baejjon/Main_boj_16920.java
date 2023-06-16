package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16920 {

	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static int N, M, P;
	static char[][] arr;
	static int[] point;
	static int[] ability;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		point = new int[P];
		ability = new int[P];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<P;i++) {
			ability[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		Deque<int[]> q = new ArrayDeque<>();
		for (int p = 1; p <= P; p++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '0' + p) {
						q.add(new int[] { i, j, p });
						point[p - 1]++;
					}
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int zi = 0; zi < size; zi++) {
				int[] cur = q.poll();
				System.out.println(ability[cur[2]-1]);
				for(int ab=1;ab<=ability[cur[2]-1];ab++) {
				for (int d = 0; d < 4; d++) {
					int nx = cur[0] + dx[d]*ab;
					int ny = cur[1] + dy[d]*ab;
					if(inRange(nx,ny) && arr[nx][ny]=='.') {
						arr[nx][ny]=(char) ('0'+cur[2]);
						point[cur[2]-1]++;
						q.add(new int[] {nx,ny,cur[2]});
					}
				}
				}
			}
		}
		
		for(char[] a : arr ) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.toString(point));
	}
//	for(int a: point ) {
//		System.out.print(a+ " ");
//	}System.out.println();
	static boolean inRange(int x, int y) {
		return 0<=x&&x<N&&0<=y&&y<M;
	}
	

	// 처음 q에 넣을때 잘넣어줘야함 잘이라느 것은 결국
}
