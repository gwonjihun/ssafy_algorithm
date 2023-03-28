package gwonjihun.baejjon;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main_5430_AC_ing {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			char[] cmd = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				br.readLine();
				sb.append("error\n");
				continue;
			}
			Deque<Integer> arr = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			while (st.hasMoreElements()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = true;
			for (char a : cmd) {
				if (arr.size() == 0) {
					System.out.println("error");
					continue ;
				}
				if (a == 'R') {
					flag = !flag;
				} else {
					if (flag) {
						if(arr.isEmpty()) {
							
						}
						arr.pollFirst();
					} else {
						arr.pollLast();
					}
				}
			}
			if (flag) {
				if(arr.size()>0) {
				System.out.print("[");
				System.out.print(arr.pollFirst());
			while(!arr.isEmpty()) {
				System.out.print(",");
				System.out.print(arr.pollFirst());
			}
			System.out.println("]");
			}
			} else {
				if(arr.size()>0) {
					System.out.print("[");
					System.out.print(arr.pollLast());
				while(!arr.isEmpty()) {
					System.out.print(",");
					System.out.print(arr.pollLast());
				}
				System.out.println("]");
				}
			}
			
			
		}
	}
}
