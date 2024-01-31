package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 * subSet을 이용해서 문제를 해결할 수 있다.
 * subSet에서는 depth랑 sum만을 가지고 진행을 하는데
 * 만약 수열의 값이 정렬되어 있지 않은 경우는 2^40으로 시간 초과가 나올 수 있다.
 * 따라서 수열을 먼저 정렬을 진행하고 정렬된 것을 바탕으로 subset을 시작할때
 * subset값이 목표하는 S값을 넘어가면 중단 되도록 설정한다.
 * 또한 S값이 0 인경우 공집합은 포함되선 안되기 때문에 해당 부분을 처리해줘야한다.
 * --->> ㅅ결론적으로 가지치기를 했다고 한들 시간 초과가난다.
 * 2.
 * n을 기준으로 배열을 나눈다
 * left,right 리스트를 가지고 subset의 결과를 가지고 있는다.
 * 그리고 left,right의 값들 중 하나씩 가져오는 two pointer 방식을 응용해서 subset을 만들어준다
 * cnt는 s가 0인경우는 하나 빼준다.
 * */
public class Main_boj_1208 {
	static int N, S;
	static long result;
	static long[] arr;
	static List<Long> left,right;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		left = new ArrayList<>();
		right = new ArrayList<>();
		subSet(0,N/2,0,left);
		subSet(N/2,N,0,right);
		Collections.sort(left);
		Collections.sort(right);
//		System.out.println("!");
		result = 0;
		int pl = 0;
		int pr = right.size()-1;
		while(pl<left.size()&&pr>=0) {
//			System.out.println("1");
			long temp = left.get(pl)+right.get(pr);
			if(temp == S){
				long a = left.get(pl);
				long cntl = 0;
				while(pl<left.size() && left.get(pl)==a) {
					cntl++;
					pl++;
				}
				long b = right.get(pr);
				long cntr = 0;
				while(pr>=0 && right.get(pr)==b) {
					cntr++;
					pr--;
				}
				result +=(cntr*cntl);
			}else if(temp > S) {
				pr--;
			}
			else {
				pl++;
			}
		}
		if(S==0) {
			System.out.println(result-1);
		}else {
			System.out.println(result);
		}
	}
	static void subSet(int idx,int end,long sum,List<Long> list) {
		if(idx==end) {
			list.add(sum);
			return;
		}

		subSet(idx+1,end,sum+arr[idx],list);
		subSet(idx+1,end,sum,list);
	}
}
