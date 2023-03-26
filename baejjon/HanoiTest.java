package gwonjihun.baejjon;

import java.util.Scanner;

public class HanoiTest {
	static void Hanoi(int n, int from, int mid, int to) {
			if (n==0) return;
			Hanoi(n-1,from,to,mid);
			System.out.println(n +":"+from+ "->" + to);
			Hanoi(n-1,mid,from,to);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Hanoi(n,1,2,3);
		sc.close();
	}

}
