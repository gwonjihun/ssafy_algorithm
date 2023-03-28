package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_2805_서울_20반_권지훈{
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
						 *  tree?�� ?���? 길이 = tree?�� ?��?�� - ?��르는 ?���?(mid)
						 *  tree?�� ?���? 길의?�� ?��?�� 구한?��.
						 *  ?�� ?�� ?��르는 ?��치�? 주어�? ?��무의 ?��?��보다 ?�� ?�� ?���? ?��문에
						 *  0 ?��?��?�� 경우(=?��?��)?��?�� ?��?��?�� ?���? ?���? ?��?���? ?��?��?��?���? ?��?��?��?��.
						 */
						if(treeHeight - mid > 0) { 
							sum += (treeHeight - mid);
						}
					}
					
		 
					/*
					 * ?���? ?���? 길의?�� ?��?�� M보다 ?��?��?�� 것�?
					 * ?��르는 ?���?(?��?��)�? ?��?��?�� ?��미이�?�? ?��?���? ?��춰야 ?��?��.
					 * �?, ?��?��(max)�? 줄여?�� ?��?��.
					 */
					if(sum < M) {
						max = mid;
					}
					
					/*
					 * ?���? ?���? 길이?�� ?��?�� M보다 ?��?��?�� 것�?
					 * ?��르는 ?���?(?��?��)�? ?��?��?�� ?��미이�?�? ?��?���? ?��?��?�� ?��?��.
					 * ?��?��, 같을 경우?��?�� 최�??�� ?���? ?��르기 ?��?�� ?��르는 ?��?���?
					 * ?��?��?�� ?���?�? ?��?��(min)?�� ?��?��?�� ?��?��.
					 */
					else {
						min = mid + 1;
					}
				}
				
				System.out.println(min - 1);
				
			
	}
}
