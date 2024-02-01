package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2143 {

	static int N,M,T;
	static int[] arrA, arrB;
	static long[] sumA, sumB;
	static long cnt;
	static int aLength, bLength;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		arrA = new int[N];
		aLength = N*(N+1)/2;
		sumA = new long[aLength];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0  ;i < N ; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		for(int i = 0 ; i<N;i++) {
			int sum = 0;
			for(int j = i ; j<N;j++) {
				sum+= arrA[j];
				sumA[idx++] = sum;
			}
		}

		M = Integer.parseInt(br.readLine());
		arrB = new int[M];
		bLength = M*(M+1)/2;
		sumB = new long[bLength];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0  ;i < M ; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		idx = 0;
		for(int i = 0 ; i<M;i++) {
			long sum = 0;
			for(int j = i ; j<M;j++) {
				sum+= arrB[j];
				sumB[idx++] = sum;
			}
		}
		
		Arrays.sort(sumA);
//		System.out.println(Arrays.toString(sumA));
		Arrays.sort(sumB);
//		System.out.println(Arrays.toString(sumB));
		
		cnt = 0 ;
		int idxA= 0 ;
		int idxB = bLength-1;
		while(idxA<aLength&& idxB>=0) {
			long sum = sumA[idxA]+sumB[idxB];
			if(sum == T) {
				long cntA = 0;
				long ta = sumA[idxA];
				while(idxA<aLength&&sumA[idxA]==ta) {
					idxA++;
					cntA++;
				}
				long cntB = 0;
				long tb = sumB[idxB];
				while(idxB>=0&&sumB[idxB]==tb) {
//					System.out.println(idxB);
					idxB--;
					cntB++;
				}
//				System.out.println( cntB+" " +cntA);
				cnt += cntB*cntA;
			}else if(sum>T) {
				idxB--;
			}else {
				idxA++;
			}
		
		}
		System.out.println(cnt);
	}
}
