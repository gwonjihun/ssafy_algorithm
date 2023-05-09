package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11279 {
	static PriorityQueue<Integer> Maxheap = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i =0 ;i<N;i++) {
			int s = Integer.parseInt(br.readLine());
			if(s==0) {
				if(Maxheap.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(Maxheap.poll());
				}
			}else {
				Maxheap.add(s);
			}
		}
		
	}
}
