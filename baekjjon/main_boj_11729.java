package gwonjihun.baekjjon;

import java.util.Scanner;

public class main_boj_11729 {
	static StringBuilder sr = new StringBuilder();
	static int cnt = 0;
	static void hanoi(int n,int from, int mid , int to) {
		if (n==0) return;
		//가장 큰 원기둥중 n-1번째부터 1번째까지를 from에서 to를 거쳐 mid로 보낸다.
		hanoi(n-1,from,to,mid);
		// 3번 막대로 n번 도넛이 이동한다
		sr.append(from).append(" ").append(to).append("\n");
		cnt++;
		// 가장 큰 원기둥 중 n-1번째부터 1번째까지 2번기둥에 보여 있는 것을 1번을 들려 
		// 3번 기둥으로 보낸다.
		hanoi(n-1,mid,from,to);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		hanoi(n,1,2,3);
		sr.insert(0, cnt+"\n");
		System.out.println(sr);
	}
}
