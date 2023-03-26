package gwonjihun.baejjon;
import java.util.*;
import java.io.*;
/*
 * 1. ì¢…ë£Œê°? ê°??Š¥?•œì§?ë¥? ë¨¼ì? ì²´í¬?•œ?‹¤. 
 * 2. 
 * 
 * */
public class Main_boj_17837_ing {
	
	static int[][] map,cnt,check;
	// map : ì§??„ ?‚´ë¶??˜ ?ƒ‰ê¹? ? •ë³?
	// cnt : ?œ„ì¹˜ë§ˆ?‹¤ ë§ì˜ ê°??ˆ˜
	// check : ì´ˆê¸° ?„±ê³? ê°??Š¥ ?—¬ë¶? ?™•?¸?„ ?œ„?•œ ? •ë³?
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int N,K;
	
	static List<node_12> li;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt= new int[N][N];
		check= new int[N][N];
		for(int i =0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		li = new ArrayList<>();
		//?°?´?„° ?…? ¥ ë°? ê°??Š¥?„± ?™•?¸.
		for(int i=0; i<K;i++) {
			st= new StringTokenizer(br.readLine()," ");			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			li.add(new node_12(x, y, d));
			if(d<3) {
				for(int j=0;j<N;j++) {
					check[x-1][j]+=1;
				}
			}else{
				for(int j=0;j<N;j++) {
					check[j][y]+=1;
				}
			}
		}
		int ch= 0;
		for(int i=0; i<K;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]>=4) {
					ch++;
				}
			}
			
			
		}
		if(ch==0) { System.out.println(-1); return;}
	
	}

}

class node_12{
	int x;
	int y;
	int d;
	node_12(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
		
	}
}
