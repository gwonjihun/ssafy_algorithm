package gwonjihun.baejjon;

import java.util.*;
import java.io.*;
public class main_ë¶?ë¶„ì§‘?•© {
	static int N=4, R=3, C=0;
	static int[] a = {1,2,3,4}, b= new int[R];
	static boolean[] v = new boolean[N];
	
	static void subs(int cnt) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				System.out.print((v[i]? a[i]: "X")+" ");
			}
			System.out.println();
			C++;
			return;
		}
		v[cnt]=true;
		subs(cnt+1);
		v[cnt]=false;
		subs(cnt+1);
	}
	
	static void subs(int cnt,int sum) {
		if(cnt == N) {
			for(int i=0;i<N;i++) {
				System.out.print((v[i]? a[i]: "X")+" ");
			}
			System.out.println();
			System.out.println("Sum= " + sum);
			C++;
			return;
		}
		v[cnt]=true;
		subs(cnt+1,sum+a[cnt]);
		v[cnt]=false;
		subs(cnt+1,sum);
	}
	
	public static void main(String[] args) {
		C=0;
		subs(0,0);
		System.out.println(C);// 2^n ë¶?ë¶„ì§‘?•©(subsets)
	}
}
