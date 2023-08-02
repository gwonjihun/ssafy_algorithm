package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_18436 {
	static int[] arr, tree;
	static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr =new int[n+1];
//		System.out.println(h);
		int ts = 4*n;
		tree = new int[ts];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(arr));
		init(1,1,n);
//		System.out.println(Arrays.toString(tree));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <T;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			if(op == 1) {
//				update(1, 1, n, a, b%2==0 ? 1 : 0);
//				arr[a] =b ;
//			}else {
//				long cnt = query(n, 1, n, a, b);
////				System.out.println(cnt);
//				System.out.println(op%2!=0 ? cnt : b-a+1-cnt);
//			}
			if(op == 1) {
				// 홀 > 짝 
				if(arr[a]%2==1 && b%2 ==0) {
					update(1,1,n,a,1);	
				}
				// 짝 > 홀 
				else if(arr[a]%2==0 && b%2==1) { 
					update(1,1,n,a,0);	
				}
				arr[a] =b ;
			}else {
//			long cnt = query(1, n, 1, a, b);
			long cnt = query(1, 1, n, a, b);
//			System.out.println(cnt);
			System.out.println(op%2==0 ? cnt : b-a+1-cnt);
			}
		}
//		System.out.println(sb);
	}

	static int init(int node, int start, int end) {
		if (start == end) {
			if (arr[start] % 2 == 0)
				return tree[node] = 1;
			else
				return 0;
		}
		return tree[node] = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
	}

	static int update(int node, int start, int end, int idx, int val) {
		if (idx < start || end < idx) {
//			System.out.println("!");
//			System.out.println(tree[node]);
			return tree[node];}
		if (start == end) {
//			System.out.println("2");
//			System.out.println(val);
			return tree[node] = val;
		}
		return tree[node] = update(node * 2, start, (start + end) / 2 , idx, val)
				+ update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
	}
//	static int query(int s,int e, int node,  int l, int r) {
//		if(r < s || e < l) return 0;
//		if(l <= s && e <= r) {
//			return tree[node];
//		}
//		int mid = (s+e)/2;
//		return query(s,mid,node*2,l,r)+query(mid+1,e,node*2+1,l,r);
//	}
	
	static int query(int node,int start,int end,int left,int right)
	{
		if(right<start || end <left) {
//			System.out.println("node : " + node + " 0!");
			return 0;
		}
		if(left<=start && end<=right) {
//			System.out.println("node : " + node + " " +tree[node]);
			return tree[node];
		}
		return query(node*2,start,(start+end)/2,left,right)+
				query(node*2+1,(start+end)/2+1,end,left,right);
	}
}
