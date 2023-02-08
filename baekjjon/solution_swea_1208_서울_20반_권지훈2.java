package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution_swea_1208_서울_20반_권지훈2 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[] arr = new int[101]; 
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 100; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			int l = 0;
			int r = 100;
			while (true) {
				if(arr[l]>0) break;
				l++;
			}
			
			while (true) {
				if(arr[r]>0) break;
				r--;
			}
			int cnt=0;
			while(cnt<=n) {
				if(arr[l]==0) { l++;
				continue;
				}
				if(arr[r]==0) {r--;
				continue;
				}
				arr[l]--;
				arr[l+1]++;
				arr[r]--;
				arr[r-1]++;
				cnt++;
			}
			System.out.println("#"+test_case+" "+(r-l));

		}
	}
}
