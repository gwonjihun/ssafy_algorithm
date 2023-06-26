package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11000 {
	static class Lecture implements Comparable<Lecture> {

		int start, end;

		Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {

			if (start == o.start)
				return end - o.end;

			return start - o.start;
		}
	}
	public static void main(String[] args) throws Exception{
		int T;
		Lecture[] time;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		time = new Lecture[T];
		
		for(int i = 0 ; i <T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i] = new Lecture(start,end);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(time);
		
		pq.offer(time[0].end);
		for (int i = 1; i < T; i++) {

			if (time[i].start >= pq.peek())
				pq.poll();

			pq.offer(time[i].end);
		}

		System.out.println(pq.size());
	}
}
