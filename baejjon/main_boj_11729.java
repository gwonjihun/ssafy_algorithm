package gwonjihun.baejjon;

import java.util.Scanner;

public class main_boj_11729 {
	static StringBuilder sr = new StringBuilder();
	static int cnt = 0;
	static void hanoi(int n,int from, int mid , int to) {
		if (n==0) return;
		//ê°??¥ ?° ?ê¸°ë¥ì¤? n-1ë²ì§¸ë¶??° 1ë²ì§¸ê¹ì?ë¥? from?? toë¥? ê±°ì³ midë¡? ë³´ë¸?¤.
		hanoi(n-1,from,to,mid);
		// 3ë²? ë§ë?ë¡? në²? ???´ ?´???¤
		sr.append(from).append(" ").append(to).append("\n");
		cnt++;
		// ê°??¥ ?° ?ê¸°ë¥ ì¤? n-1ë²ì§¸ë¶??° 1ë²ì§¸ê¹ì? 2ë²ê¸°?¥? ë³´ì¬ ?? ê²ì 1ë²ì ?¤? ¤ 
		// 3ë²? ê¸°ë¥?¼ë¡? ë³´ë¸?¤.
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
