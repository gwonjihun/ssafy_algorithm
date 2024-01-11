package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_10971_aga {

	static int[][] map;
	static int[] route;
	static boolean[] visited;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		route = new int[N];
		map = new int[N][N];
		visited= new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				
			}
		}
		
	}
	
}
