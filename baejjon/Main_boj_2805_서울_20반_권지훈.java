package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_2805_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
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
						 *  tree?˜ ?˜ë¦? ê¸¸ì´ = tree?˜ ?†’?´ - ?ë¥´ëŠ” ?œ„ì¹?(mid)
						 *  tree?˜ ?˜ë¦? ê¸¸ì˜?˜ ?•©?„ êµ¬í•œ?‹¤.
						 *  ?´ ?•Œ ?ë¥´ëŠ” ?œ„ì¹˜ê? ì£¼ì–´ì§? ?‚˜ë¬´ì˜ ?†’?´ë³´ë‹¤ ?´ ?ˆ˜ ?ˆê¸? ?•Œë¬¸ì—
						 *  0 ?´?•˜?¸ ê²½ìš°(=?Œ?ˆ˜)?—?Š” ?•©?‚°?„ ?•˜ì§? ?•Šê³? ?–‘?ˆ˜ë§? ?•©?‚°?•˜?„ë¡? ?•´?•¼?•œ?‹¤.
						 */
						if(treeHeight - mid > 0) { 
							sum += (treeHeight - mid);
						}
					}
					
		 
					/*
					 * ?ë¥? ?‚˜ë¬? ê¸¸ì˜?˜ ?•©?´ Më³´ë‹¤ ?‘?‹¤?Š” ê²ƒì?
					 * ?ë¥´ëŠ” ?œ„ì¹?(?†’?´)ê°? ?†’?‹¤?Š” ?˜ë¯¸ì´ë¯?ë¡? ?†’?´ë¥? ?‚®ì¶°ì•¼ ?•œ?‹¤.
					 * ì¦?, ?ƒ?•œ(max)ë¥? ì¤„ì—¬?•¼ ?•œ?‹¤.
					 */
					if(sum < M) {
						max = mid;
					}
					
					/*
					 * ?ë¥? ?‚˜ë¬? ê¸¸ì´?˜ ?•©?´ Më³´ë‹¤ ?¬?‹¤?Š” ê²ƒì?
					 * ?ë¥´ëŠ” ?œ„ì¹?(?†’?´)ê°? ?‚®?‹¤?Š” ?˜ë¯¸ì´ë¯?ë¡? ?†’?´ë¥? ?†’?—¬?•¼ ?•œ?‹¤.
					 * ?˜?•œ, ê°™ì„ ê²½ìš°?—?Š” ìµœë??•œ ? ê²? ?ë¥´ê¸° ?œ„?•´ ?ë¥´ëŠ” ?†’?´ë¥?
					 * ?†’?—¬?•¼ ?•˜ë¯?ë¡? ?•˜?•œ(min)?„ ?˜¬? ¤?•¼ ?•œ?‹¤.
					 */
					else {
						min = mid + 1;
					}
				}
				
				System.out.println(min - 1);
				
			
	}
}
