package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_17143_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	static class shark {

		int size;
		int speed;
		int dir;

		shark(int speed, int dir, int size) {
			this.size = size;
			this.dir = dir;
			this.speed = speed;
		}
	}
	static shark[][] map;
	static shark[][] temp;
	static int p = -1, H, W, cnt = 0; // ?‚¬?Œ?´ ?ˆ?Š” ?œ„ì¹˜ëŠ” cnt?Š” ?‚¬?Œ?´ ?¡?? ?ƒ?–´?˜ ?ˆ˜
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	// ë²½ì„ ë§Œë‚˜?„œ ?ƒ?–´ê°? ë°˜ë? ë°©í–¥?œ¼ë¡? ?šŒ? „?•˜?Š” ë°©ë²•?? d+5%4
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int sharks = Integer.parseInt(st.nextToken());
		map = new shark[H][W];
		for (int i = 0; i < sharks; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = new shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}

		while (++p < W) {
			catch_sh();
			move();
		}

		System.out.println(cnt);
	}

	static void move() {
		temp = new shark[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// ?—¬ê¸°ì„œ ?ƒ?–´ê°? ?´?™?•´?•¼?•˜?Š”?° ë¨¼ì? temp shark 2ì°¨ì›?–‰? ¬?„ ë§Œë“¤?–´ì¤??‹¤
				if (map[i][j] != null) {
					int x = i;
					int y = j;
					int size = map[i][j].size;
					int dir = map[i][j].dir;
					int speed = map[i][j].speed;
					
					if(dir == 0 || dir == 1) // ?ƒ ?•˜
						speed %= (H -1) * 2; 
					else if(dir == 2 || dir == 3) // ì¢? ?š°
						speed %= (W -1) * 2;
					for (int l = 0; l < speed; l++) {
						// nxë¡? ?…‹?Œ…?„ ?•´ì¤˜ì•¼?•œ?‹¤.
//						System.out.println(dir);
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						if (0 > nx || nx >= H || 0 > ny || ny >= W) {
							dir = dir % 2 == 0 ? dir + 1 : dir - 1;
						}
						x = x + dx[dir];
						y = y + dy[dir];
					}
					if (temp[x][y] != null) {
						temp[x][y] = temp[x][y].size > size ? temp[x][y] : new shark(speed, dir, size);
					} else {
						temp[x][y] = new shark(speed, dir, size);
					}
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// ?ƒ?–´?˜ ?´?™ê³? ?‹¸???´ ??‚œ?’¤?˜ tempë¥? ?›?˜ map?— ë°˜ì˜
				map[i][j] = temp[i][j];
			}
		}

	}

	static void catch_sh() {
		for (int i = 0; i < H; i++) {
			if (map[i][p] != null) {
				cnt += map[i][p].size;
				map[i][p] = null;
				break;
			}
		}
	}

}
