package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_D3_1873_서울_20반_권지훈 {
	static char[] dir = { '<', '>', '^', 'v' }, cmd;
	static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 }, tank;
	//tank x , y, dir
	static char[][] map;
	static int H, W, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String ss = br.readLine();
			StringTokenizer st = new StringTokenizer(ss, " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == dir[0] || map[i][j] == dir[1] || map[i][j] == dir[2] || map[i][j] == dir[3]) {
						for (int tan = 0; tan < 4; tan++) {
							if (map[i][j] == dir[tan]) {
								tank = new int[] { i, j, tan };
								map[i][j] = '.';
								break;
							}
						}
					}
				}
			}
			// 데이터 입력 및 탱크 위치 저장

			C = Integer.parseInt(br.readLine());

			cmd = br.readLine().toCharArray();
			// 명령어 저장

			for(int i=0;i<C;i++) {
				if(cmd[i]=='S') {
					shoot();
				}else if(cmd[i]=='U'){
					move(2);
				}else if(cmd[i]=='D'){
					move(3);
					
				}else if(cmd[i]=='L'){
					move(0);
					
				}else if(cmd[i]=='R'){
					move(1);
					
				}
			}
			//이걸로 결과 변경
			map[tank[0]][tank[1]] = dir[tank[2]];
			sb.append("#"+t+" ");
			for (char[] a : map) {
                for(char r : a){
				sb.append(r);
                }sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
	static void shoot() {
		int x= tank[0];
		int y = tank[1];
		int dir = tank[2];
		
		while(true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(0>nx || nx>=H || 0>ny || ny>=W) {
				break;
				//전쟁지역을 벗어난 경우
			}
			if(map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
			if(map[nx][ny] == '#') {
				break;
			}
			x = nx;
			y = ny;
		}
	}
	static void move(int d) {
		tank[2] = d;
		if(0>tank[0]+dx[d] || tank[0]+dx[d]>=H || 0>tank[1]+dy[d] || tank[1]+dy[d]>=W) return;
		if(map[tank[0]+dx[d]][tank[1]+dy[d]]=='.') {
			tank[0]+=dx[d];
			tank[1]+=dy[d];
		}
	}
}