package gwonjihun.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_swea_2805_서울_20반_권지훈 {
	static int[][] arr;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dx = {1,1,-1,-1};
		int[] dy = {1,-1,1,-1};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i= 0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) 
				{
					arr[i][j]= s.charAt(j) - '0';
				}
			}
			
			int mid = N/2; 
			//5 -> 4까지이닌깐 -> 2
			//9 -> 8까지 mid 는 4 -> 
			
			int sum = 0;
			
			for(int i= 0;i<N-mid;i++) {
				for(int j=0;j<N-mid;j++) {
					if(i+j>=N-mid) continue;
					for(int k=0;k<4;k++) {
						if(!visited[i*dx[k]+mid][j*dy[k]+mid]) 
						{
						 sum+=arr[i*dx[k]+mid][j*dy[k]+mid];
						 visited[i*dx[k]+mid][j*dy[k]+mid]= true;
						}
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
