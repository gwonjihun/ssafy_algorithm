package gwonjihun.baejjon;
import java.io.*;
import java.util.*;
public class Combmain {
	static int N= 4,R=3, c=0;
	static int[] a= {1,2,3,4}, b= new int[R];
	static boolean[] v = new boolean[N];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		perm(0);//nPr= 4P3 ??ด(Permutation) : ??์ค์(123!=321)
		percomb(0,0); // nCr = 4C3 ์กฐํฉ(Combination): ?? ?๊ด? ??(123 == 321)
		System.out.println(c);
	}
	static void percomb(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(b)); c++;
			return;
		}
		for(int i=start; i<N;i++) {

//			if(v[i]) continue;
//			v[i]=true;
			b[cnt] = a[i];
			percomb(cnt+1,i);// ์กฐํฉ
//			percomb(cnt+1,0);// ??ด
//			percomb(cnt+1,i);// ์ค๋ณต??ฉ์กฐํฉ
//			v[i]=false;
//			comb(cnt+1,i); -> ?ด๊ฑ? ์ค๋ณต์กฐํฉ
		}
	}
	static void perm(int cnt) {
//		System.out.println(cnt);
		if(cnt == R) {
			System.out.println(Arrays.toString(b)); c++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i]=true;
			int T= b[cnt];
			b[cnt]= a[i];  
			perm(++cnt); 
			--cnt;
			b[cnt] =T; 
			v[i]=false;
		}
	}
}
