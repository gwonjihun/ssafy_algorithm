package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_1967_g2 {
	
	static int Max = 0;
	static ArrayList<int[]>[] arr;//그래프를 저장할 노드
	static boolean[] v;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n];
		
		for(int i = 0 ; i<n;i++) {
			arr[i]=new ArrayList<int[]>();
		}
		for(int i = 0 ; i < n-1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			arr[to].add(new int[] {from, weight});
			arr[from].add(new int[] {to, weight});
			
		}
//		for( ArrayList<int[]> c_arr : arr) {
//			for(int[] a : c_arr) {
//				System.out.print(Arrays.toString(a)+" ");
//			}
//			System.out.println("!");
//			System.out.println();
//		}
		for(int j = 0 ; j < n; j++) {
			v = new boolean[n];
			v[j]= true;
			dfs(j,0);
		}
		System.out.println(Max);
	}
	public static void dfs(int start, int sum){
		if(sum> Max) Max = sum;
		ArrayList<int[]> c_arr =arr[start];
		for(int[] a : c_arr) {
			if(v[a[0]]==false) {
			v[a[0]] =true;
			dfs(a[0], sum+a[1]);
			v[a[0]] =false;
			}
		}
		
		
	}
}
