package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_boj_17071 {

	static int K, M;
	static boolean[][] v = new boolean[500001][2];
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(M==K) {
			System.out.println(0);
		}else {
		System.out.println(bfs(M));
		}
	}
	static int bfs(int start) {
		int time= 0;
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		v[start][time] =true;
		
		while(!q.isEmpty()) {
		
			if(K>500000) {
				return -1;
			}
			int newTime = time%2;
			if(v[K][newTime]) return time;
		
			
			
			System.out.println("");
		
			for(int j = 0, size = q.size() ; j < size; j++) {
				int now = q.poll();
				int nextTime = (time+1)%2;
				int next;
				
				next = now -1;
				if(next>=0&& !v[next][nextTime]) {
					v[next][nextTime]= true;
					q.add(next);
				}
				next = now +1;
				if(next<=500000&& !v[next][nextTime]) {
					v[next][nextTime]= true;
					q.add(next);
				}
				next = now *2;
				if(next<=500000&& !v[next][nextTime]) {
					v[next][nextTime]= true;
					q.add(next);
				}
			}
			time++;
			K+=time;
		}
		return -1;
	}
}
