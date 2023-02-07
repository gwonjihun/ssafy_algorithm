package gwonjihun.baekjjon;
import java.io.*;
import java.util.*;
public class PerMain {
	static int N= 4,R=3, c;
	static int[] a= {1,2,3,4}, b= new int[R];
	static boolean[] v = new boolean[N];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		c= 0;
		//perm(0);//nPr= 4P3 순열(Permutation) : 순서중요(123!=321)
		comb(0,0); // nCr = 4C3 조합(Combination): 순서 상관 없음(123 == 321)
		System.out.println(c);
	}
	static void comb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(b)); c++;
			return;
		}
		for(int i=start; i<N;i++) {
			b[cnt] = a[i];
			comb(cnt+1,i+1);
//			comb(cnt+1,i); -> 이건 중복조합
		}
	}
	static void perm(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(b)); c++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i]=true;
			int T= b[cnt];
			b[cnt]= a[i];
			perm(cnt+1);
			b[cnt] =T;
			v[i]=false;
		}
	}
}
