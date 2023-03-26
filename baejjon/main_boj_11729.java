package gwonjihun.baejjon;

import java.util.Scanner;

public class main_boj_11729 {
	static StringBuilder sr = new StringBuilder();
	static int cnt = 0;
	static void hanoi(int n,int from, int mid , int to) {
		if (n==0) return;
		//�??�� ?�� ?��기둥�? n-1번째�??�� 1번째까�?�? from?��?�� to�? 거쳐 mid�? 보낸?��.
		hanoi(n-1,from,to,mid);
		// 3�? 막�?�? n�? ?��?��?�� ?��?��?��?��
		sr.append(from).append(" ").append(to).append("\n");
		cnt++;
		// �??�� ?�� ?��기둥 �? n-1번째�??�� 1번째까�? 2번기?��?�� 보여 ?��?�� 것을 1번을 ?��?�� 
		// 3�? 기둥?���? 보낸?��.
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
