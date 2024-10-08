package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16940 {
	static int n; // 정점의 수
	static ArrayList<HashSet<Integer>> list; // 인접 리스트
	static int[] visit; // 방문 여부
	static int[] answer; // 정답 순서
	static Queue<Integer> queue; 
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new int[n + 1];
		answer = new int[n + 1];
		queue = new LinkedList<Integer>();
		
		// 인덱스 값을 1 부터 씀
		for(int i = 0; i <= n; i++) {
			list.add(new HashSet<>());
		}
		
		// 인접 리스트 생성
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.get(index).add(value);		
			list.get(value).add(index);
		}
		
		// 정답 생성
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		// 시작이 1이 아니면 X
		if(answer[1] != 1) {
			System.out.println("0");
			return;
		}

		bfsCheck(1);
	
 	}
	
	public static void bfsCheck(int x) {
		queue.offer(x);
		visit[x] = 1;
		int index = 2; // 2 번째부터 탐색
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			int count = 0;
			for(int next : list.get(cur)) {
				if(visit[next] == 0) {
					visit[next] = 1;
					count++;
				}
			}
			
			for(int i = index; i < index + count; i++) {	
				if(visit[answer[i]] == 0) {
					System.out.println("0");
					return;
				}
				else {
					queue.offer(answer[i]);
				}		
			}
			index += count;
		}
		
		System.out.println("1");
	}
}
