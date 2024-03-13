package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_15686 {
	static int n,m;
	
//	static int[][] arr;
	static List<int[]>chicken;//m개의 치킨 노드를 구할것이고
	static List<int[]>home;//m개의 치킨 노드를 구할것이고
	static int[] choice;//고른 치킨의 수
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		choice = new int[m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++)
			{
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					home.add(new int[] {i,j});
				}else if(num==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0,0);
		
		System.out.println(min);

	}
	static void dfs(int depth, int cCnt) {
		if(cCnt == m) {
			int res = 0;
			
			for(int[] person : home) {
				int temp = Integer.MAX_VALUE;
				for(int idx : choice) {
					int[] cur = chicken.get(idx);
					int dist = Math.abs(person[0]-cur[0])+Math.abs(person[1]-cur[1]);
					
					temp = Math.min(temp,dist);
				}
				res += temp;
			}
			min = Math.min(min, res);
			return;
		}
		for(int i = depth;i<chicken.size();i++) {
			choice[cCnt] = i;
			dfs(i+1,cCnt+1);
			choice[cCnt]= -1;
		}
	}
}

