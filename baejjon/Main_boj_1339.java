package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
/*
 * 풀이 접근법.
 * 1. 입력받은 문자들을 가지고 Map<character , Integer>에 넣어서 사이즈를 확인한다
 * 2. Set의 사이즈를 기반으로 9~0까지를 순서로 각 알파벳별로 가중치를 만든다.
 * 3. 각 가중치로 문자열을 계산해서 max 값과 비교한다.
 * */
public class Main_boj_1339 {
	static int N;
	static Map<Character,Integer> map;
	static int[] weight; // 가중치
	static String[] str;
	static boolean[] visited = new boolean[10];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		map = new HashMap<Character, Integer>();
		int idx = 0;
		for(int i = 0 ; i <N;i++) {
			str[i] = br.readLine();
			for(int j = 0 ; j < str[i].length();j++) {
//				System.out.println("1");
				if(map.containsKey(str[i].charAt(j)))continue;
				map.put(str[i].charAt(j), idx++);
			}
		}
		weight = new int[map.size()];
		dfs(0);
		
		
		System.out.println(max);
	}
	static void dfs(int depth) {
		if(depth == weight.length) {
			//여기서 덧셈 계산해주고 max값을 찾아준다.
//			System.out.println("!@#!@#!@#");
			int sum = 0;
			for(int i = 0 ; i<N;i++) {
				int temp = 0;
				for(int j= 0 ; j<str[i].length();j++) {
					int idx = map.get(str[i].charAt(j));
					temp = temp*10+weight[idx];
				}
				sum += temp;
			}
			max = Math.max(sum, max);
			return;
		}
		for(int i = 0 ; i < 10;i++) {
			if(visited[i]) continue;
			weight[depth] = i;
			visited[i]=true;
			dfs(depth+1);
			visited[i]=false;
		}
	}
	

	
}
