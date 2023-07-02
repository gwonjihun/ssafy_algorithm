package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_13975 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			long cnt = 0 ; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i <  N ;i++) {
				pq.add((long)Integer.parseInt(st.nextToken()));
			}
			while(pq.size()>1) {
				long first = pq.poll();
				long seconde = pq.poll();
				
				cnt += first+seconde;
				pq.add(first+seconde);
			}
			
			System.out.println(cnt);
			
			
			
			
			
		}
	}
}
