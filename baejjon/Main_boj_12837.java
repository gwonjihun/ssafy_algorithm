package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_12837 {
	static long[] tree, arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		int ts = 1<<(h+1);
		tree = new long[ts];
		for(int i =0 ; i <m;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(op==1) {
				update(1,1,n,a,b);
			}else {
				System.out.println(sum(1,1,n,a,b));
			}
		}
		
		
		
	}
	
	static long update(int node, int start, int end, int idx,int val) {
		if(idx<start || idx>end) return tree[node];
		if(start == end) return tree[node]+=val;
		return tree[node]= update(node * 2, start, (start + end) / 2 , idx, val)
				+ update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
	}
	static long sum(int node, int start, int end, int left,int right) {
		if(right <start || left >end) return 0;
		if(left <=start && right >=end)
			return tree[node];
		
		return sum(node*2,start,(start+end)/2,left,right)+sum(node*2+1,(start+end)/2+1,end,left,right);
	}
}
