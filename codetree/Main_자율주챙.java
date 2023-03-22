package gwonjihun.codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_자율주챙 {


	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map; // 0은 차도 1은 인도 -1은 방문한 도로
	static int n, m,cnt = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[x][y] = -1;

		int rotate = 0 ;
		while(true) {
			if(map[x+dx[(dir+3)%4]][y+dy[(dir+3)%4]]==0) {
				//1.번
				dir = (dir+3)%4;
				x = x+dx[dir];
				y = y+dy[dir];
				map[x][y]=-1;
				cnt++;
				rotate= 0;
				System.out.println("1번 " +x + " " + y + " " + dir);
			}else if(rotate==4) {
				rotate=0;
				if(map[x+dx[(dir+2)%4]][y+dy[(dir+2)%4]]!=1) {
				x = x+dx[(dir+2)%4];
				y = y+dy[(dir+2)%4];
				if(map[x][y] == 0 ) {
					map[x][y] = -1 ;
					cnt++;
				}
				System.out.println("3번 "+x + " " + y + " " + dir);
				}else {

					System.out.println("4번 "+x + " " + y + " " + dir);
					break;
				}
			}
			else {

				dir = (dir+3)%4;
				rotate++;
				System.out.println("2번 " + x + " " + y + " " + dir);
			}
		}
		System.out.println(cnt);
	}
}
