package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_16926_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[h][w];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(h, w) / 2; //?Œ?•„ê°??Š” ?¼?¸??˜ ?ˆ˜
		for(int i=0; i<n; i++) { //?šŒ? „ ?šŸ?ˆ˜ë§Œí¼ ë°˜ë³µ
			
			for(int j=0; j<count; j++) { //?¼?¸?“¤ ? „ë¶? ?Œë¦¬ê¸°
				int temp = arr[j][j]; //ë§? ë§ˆì?ë§‰ì— ?„£ê¸? ?œ„?•´ ?”°ë¡? ???ž¥!!!!ë°°ì—´?—?„œ ?›?†Œ ?œ„ì¹? ë°”ê??•Œ ?•˜?‚˜ë¥? temp?— ???ž¥?•´?‘?Š”ê±°ëž‘ ê°™ì? ?›ë¦?
				
				for(int k=j+1; k<w-j; k++)
					arr[j][k-1] = arr[j][k];
				
				for(int k=j+1; k<h-j; k++)
					arr[k-1][w-1-j] = arr[k][w-1-j];
				
				for(int k=w-2-j; k>=j; k--)
					arr[h-1-j][k+1] = arr[h-1-j][k];
				
				for(int k=h-2-j; k>=j; k--)
					arr[k+1][j] = arr[k][j];
				
				arr[j+1][j] = temp;
			}
		}
		
		for(int j=0; j<h; j++) {
			for(int k=0; k<w; k++) {
				System.out.print(arr[j][k] + " ");
			}
			System.out.println();
		}
	}

}
