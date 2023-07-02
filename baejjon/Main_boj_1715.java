package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1715 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 0;
		for(int i = 0 ; i < N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while(pq.size()!=1) {
			int first = pq.poll();
			int second = pq.poll();
			int result = first+ second;
			cnt += result;
			pq.add(result);
		}
		System.out.println(cnt);
	}
}
