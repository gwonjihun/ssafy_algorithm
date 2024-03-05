package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 * 틀린 이유 : 시간 초과가 발생한다.
 * 원인 : 해당 코드는 스티커를 중복없이 한개를 고르고 그다음에 x,y모든 위치에 대해서 확인하고 있는데
 * 이러한 방식으로 문제를 진행하게된다면
 * 100*100*100*99*100*100이 되며 시간 초과가 발생할 수 있따
 * 다른 방식의 접근법 결국에는 H,W를 가지고
 * sticker들을 2개를 고른다음에 둘을 가지고 H*W에 전부 들어갈 수 있는가의 유무만을 판단해주는 방식으로
 * 진행해 줘야한다.
 * */
public class Main_boj_16937_fail {
	static int H, W, N;
	static boolean[][] v;
	static int[][] sticker;
	static int size = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		v = new boolean[H][W];

		N = Integer.parseInt(br.readLine());

		sticker = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			sticker[n][0] = Integer.parseInt(st.nextToken());
			sticker[n][1] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0, 0);

		System.out.println(size);
	}

	static void dfs(int depth, int idx, int sum) {
		if (depth == 2) {
			size = Math.max(sum, size);
			return;
		}
		for (int x = 0; x < H; x++) {
			for (int y = 0; y < W; y++) {
				if(v[x][y]) continue;
				for (int i = idx; i < N; i++) {
					boolean flag = false;
					int xs = sticker[i][0];
					int ys = sticker[i][1];
					//flag true -> 스티커를 붙이는데 문제가 발생한다는 의미
					for(int nx = x ; nx < x+xs-1;nx++) {
						if(flag) break;
						for(int ny = y ; ny< y+ys-1;ny++) {
							if(!inRange(nx,ny)||v[nx][ny]) {
								flag = true;
								break;
							}
						}
					}
					if(flag) continue;
					attach(x,y,xs,ys);
					dfs(depth+1,i+1,sum+xs*ys);
					attach(x,y,xs,ys);
					flag = false;
					
					for(int nx = x ; nx < x+ys-1;nx++) {
						if(flag) break;
						for(int ny = y ; ny< y+xs-1;ny++) {
							if(!inRange(nx,ny)||v[nx][ny]) {
								flag = true;
								break;
							}
						}
					}
					if(flag) continue;
					attach(x,y,ys,xs);
					dfs(depth+1,i+1,sum+xs*ys);
					attach(x,y,ys,xs);
					flag = false;
				}
			}
		}

	}
	static boolean inRange(int x,int y) {
		return 0<=x&&x<H&&0<=y&&y<W;
	}
	static void attach(int x,int y, int xs,int ys) {
		for(int i = x ; i < x+xs-1;i++) {
			for(int j = y ; j< y+ys-1;j++) {
				v[i][j]= !v[i][j];
			}
		}
	}

}
