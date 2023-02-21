package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;

public class Main_boj_2805_서울_20반_권지훈 {
	static int[] tree;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int min = 0;
		int max= Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			 int temp= Integer.parseInt(st.nextToken());
			 max = Math.max(max, temp);
			 tree[i] = temp;
		}
			 while(min < max) {
					
					int mid = (min + max) / 2;
					long sum = 0;
					for(int treeHeight : tree) {
						
						/*
						 *  tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
						 *  tree의 잘린 길의의 합을 구한다.
						 *  이 때 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에
						 *  0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야한다.
						 */
						if(treeHeight - mid > 0) { 
							sum += (treeHeight - mid);
						}
					}
					
		 
					/*
					 * 자른 나무 길의의 합이 M보다 작다는 것은
					 * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
					 * 즉, 상한(max)를 줄여야 한다.
					 */
					if(sum < M) {
						max = mid;
					}
					
					/*
					 * 자른 나무 길이의 합이 M보다 크다는 것은
					 * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
					 * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
					 * 높여야 하므로 하한(min)을 올려야 한다.
					 */
					else {
						min = mid + 1;
					}
				}
				
				System.out.println(min - 1);
				
			
	}
}
