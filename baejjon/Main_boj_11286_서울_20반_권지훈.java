package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_11286_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int r = Math.abs(o1) - Math.abs(o2);
				if(r!=0) {
					return r;
				}
				else {
					return o1-o2;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i =0;i<tc;i++) {
			int T = Integer.parseInt(br.readLine());
			if(T == 0) {
				if(pq.isEmpty()) { sb.append("0\n");}
				else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(T);
			}
		}
	System.out.println(sb);
	}
}
