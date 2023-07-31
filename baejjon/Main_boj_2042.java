package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2042 {
	static int N,M,K;
	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		for(int i = 1 ; i < N+1 ; i ++ ) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegementTree segement = new SegementTree(N);
		
		segement.init(arr, 1, 1,N);
		for(int i = 0 ; i <M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) {
				//update
				segement.update(1,1,N,b,c-arr[b]);
				arr[b]=c;
			}else {
				//sum
				System.out.println(segement.sum(1, 1, N, b, (int)c));
			}
		}
	}
	
	static class SegementTree
	{
		long tree[];
		int treesize;
		
		public SegementTree(int arrsize) {
			int h = (int) Math.ceil(Math.log(arrsize)/Math.log(2));
			this.treesize = (int) Math.pow(2,h+1);
			tree = new long[this.treesize];
		}
		
		public long init(long[] arr,int node, int start,int end) {
			if(start==end) {
				return tree[node]=arr[start];
				}
			return tree[node]=init(arr,node*2,start,(start+end)/2)+
					init(arr,node*2+1,(start+end)/2+1,end);
			
		}
		
		public void update(int node, int start,int end, int idx, long diff) {
			if(idx<start|| idx >end) return;
//			System.out.println(node);
			tree[node] += diff;
			
			if(start!=end) {
				update(node*2, start,(start+end)/2,idx,diff);
				update(node*2+1, (start+end)/2+1,end,idx,diff);
			}
			
		}
		
		public long sum(int node,int start, int end, int left,int right) {
			//left, right는 내가 원하는 범위
			//start,end는 다음 노드가 가르키는 범위죠
			if(end<left||start>right) {
				return 0;
			}
			
			if(left<=start && end <= right) {
				return tree[node];
			}
			
			return sum(node*2,start,(start+end)/2,left,right)+
					sum(node*2+1,(start+end)/2+1,end,left,right);		}
	}
}
