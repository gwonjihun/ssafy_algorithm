package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D6_사람네트워크 {

	static int[][] graph;
	static int[][] shorts_graph;
	static int n, min;
	static final int INF = 1000000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {

			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j< n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (i!=j&&graph[i][j] == 0) {
						graph[i][j] = INF;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					for (int k = 0; k < n; k++) {
						if (j == k || i == k)
							continue;
						if (graph[i][k] + graph[k][j] < graph[i][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
//					if(i!=j) {
					sum += graph[i][j];
//					}
				}
//				System.out.println(sum);
				if(sum <min) {
					min = sum;
				}
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
