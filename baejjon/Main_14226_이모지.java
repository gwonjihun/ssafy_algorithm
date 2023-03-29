package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_14226_이모지 {

	static int goal;
	static int time = Integer.MAX_VALUE;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		goal = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001];
		bfs(1, 0, 0);
		System.out.println(time);
	}

	static void bfs(int str_len, int clip_len, int ctime) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { str_len, clip_len, ctime });
		visited[str_len][clip_len] = true;
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			if (cur[0] == goal) {
				if (time > cur[2]) {
					time = cur[2];
					return;
				}
			}
			
			if (cur[0]+cur[1]<2000 && !visited[cur[0] + cur[1]][cur[1]] ) {
				// 붙여넣기
				q.add(new int[] { cur[0] + cur[1], cur[1], cur[2] + 1 });
				visited[cur[0] + cur[1]][cur[1]] = true;
			}
			if (!visited[cur[0]][cur[0]]) {
				//복사
				q.add(new int[] { cur[0], cur[0], cur[2] + 1 });
				visited[cur[0]][cur[0]] = true;
			}
			if (cur[0] - 1 >= 0) {
				//삭제
				if (!visited[cur[0] - 1][cur[1]]) {
					q.add(new int[] { cur[0] - 1, cur[1], cur[2] + 1 });
					visited[cur[0] - 1][cur[1]] = true;
				}
			}
			
		}
	}
}
