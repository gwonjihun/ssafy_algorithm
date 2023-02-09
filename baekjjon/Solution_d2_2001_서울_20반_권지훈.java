package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d2_2001_서울_20반_권지훈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=Tc;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr= new int[n][n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}			
			int max = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int sum = 0;
					for(int x=0;x<m;x++) {
						for(int y=0;y<m;y++) {
							if(x+i>=n || y+j>=n ) continue;
							sum += arr[x+i][y+j];
							
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		
		
		
		}
		
		System.out.println(sb);
		
	}
}
