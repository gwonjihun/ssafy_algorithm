package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_1202_보석훔치기 {
	static class dia implements Comparable<dia>{
		int Val;
		int Mo;
		
		public dia(int val, int mo) {
			Val = val;
			Mo = mo;
		}

		@Override
		public int compareTo(dia o) {
			if(this.Mo==o.Mo) {
				return o.Val-this.Val;
			}
			// TODO Auto-generated method stub
			return this.Mo-o.Mo;
		}

	}
	static PriorityQueue<Integer> q;
	static int[] bag;
	static dia[] qhtjr;
	static int N,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q = new PriorityQueue<>(Comparator.reverseOrder());
		N = Integer.parseInt(st.nextToken());
		// 보석 개수
		K = Integer.parseInt(st.nextToken());
		bag = new int[N];
		
		
		
		// 가방 개수
		
		
		/*
 * 1. 보물을 무게가 낮고 가치가 높은에들로
 * 2. 우선순위 큐에서는 가치가 가장 높은애를 나오게 해주고
*/	}
}
