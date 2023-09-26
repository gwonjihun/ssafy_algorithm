package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_1205 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int rank = 1;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for(int i= N-1 ; i >=0 ; i--) {
			System.out.println(arr[i]);
			if(arr[i]<=input) {
				System.out.print(rank);
				break;
			}else {
				rank++;
				P--;
			}
		}
	}
}
