package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_2164_서울_20반_권지훈 {
	public static void main(String args[]) throws Exception {
		Deque<Integer> card = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<=N ; i++) {
			card.offer(i);
		}
		
		while(card.size()>1) {
			card.poll();
			int temp = card.poll();
			card.addLast(temp);			
		}
		System.out.println(card.peek());
	}
}
