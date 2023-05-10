package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_21921 {

	public static void main(String[] args) throws Exception{
		int cnt = 0;
		int dup = 0;
		int N;
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		int left = 0;
		int right = x-1;
		int sum = 0;
		for(int i = left; i<=right;i++) {
			sum += arr[i];
		}
		while(right<N) {
			
			
			left++;
			right++;
		}
		
	}
}
