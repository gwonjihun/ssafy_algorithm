package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * 2가지 방법
 * 연산자 순서를 저장하고 마지막 depth에서만 계산한다.
 * 여기서 연산자 순서를 저장해주는 방식으로 진행하게 된다면? 0 1 2 3을 가지고 순서를 정해준다
 * 
 * 각 단계에서 계산을 해준다. 
 * 
 * */
public class Main_boj_15658 {
	static int N;
	static int[] arr;// 숫자가 들어가있는 값들
	static int[] count;
	//+, - , * , / 이 들어간다.
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <4;i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int depth,int sum) {
		if(depth== N) {
			min = Math.min(sum, min);
			max = Math.max(sum, max);
			return;
		}
		for(int i = 0 ; i<4;i++) {
			if(count[i]==0) continue;
			count[i]--;
			dfs(depth+1,calcul(sum,arr[depth],i));
			count[i]++;
		}
//		sum(+,-,*,/)arr[depth]
	}
	static int calcul(int x,int y,int d) {
		switch (d) {
		case 0:
			return x+y;
		case 1:
			return x-y;
		case 2:
			return x*y;
		case 3:
			return (int)x/y;
			
		}

		return 0;
	}
}
