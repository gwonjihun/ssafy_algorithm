package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
 1,2,3이 알고 있을때 
 해당 파티에서 true가 있으면 그파티 전부가 true가되기때문에 문제가 발생한다
 ㅈ
 * */
public class Main_boj_1043 {
	static int N,M;
	static boolean[] trues;
	static List<Integer>[] party;
	static boolean[] part_true;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new List[M];
		part_true = new boolean[M];
		trues = new boolean[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		int listener = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < listener;i++) {
			int idx = Integer.parseInt(st.nextToken());
			trues[idx]= true;
		}
		for(int i=1;i<=M;i++) {
			int idx = Integer.parseInt(st.nextToken());
			for(int j=0;j<idx;j++) {
				party[j].add(Integer.parseInt(st.nextToken()));
			}
		}
		

	}
}
