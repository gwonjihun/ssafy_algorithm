package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_15688 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0 ; i < N; i ++) {
			arr.add(Integer.parseInt(br.readLine()));
			
		}
		Collections.sort(arr,Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i ++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
