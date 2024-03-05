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
public class Main_boj_16937 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int H = sc.nextInt();
//		int W = sc.nextInt();
//		
//		int N = sc.nextInt();
//		int[][] stickers = new int[N][2];
//		for(int i=0; i<N; i++) {
//			stickers[i][0] = sc.nextInt();
//			stickers[i][1] = sc.nextInt();
//		}
//		
//		int sum = 0; // 넓이 합
//		int max = 0; // 최대 넓이
//		for(int i=0; i<N-1; i++) {
//			for(int j=i+1; j<N; j++) {
//				if(stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
//						stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
//					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
//				}
//				else if(stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
//						stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
//					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
//				}
//				else if(stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
//						stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
//					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
//				}
//				else if(stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
//						stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
//					sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
//				}
//				if(max < sum) max = sum;
//			}
//		}
//		
//		System.out.println(max);
//		sc.close();
		String a = "a";
		String b = new String("a");
		System.out.println(a==b);
	}

}

