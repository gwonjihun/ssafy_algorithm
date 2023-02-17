package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_D3_6080_서울_20반_권지훈 {
	static int[] f, s, per;
	static boolean[] v;
	static boolean[] set;
	static int N = 9;
	static int winner, looser;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T; tc++) {
			f = new int[N];
			s = new int[N];
			per = new int[N];
			v = new boolean[N];
			set = new boolean[19];
			

			winner=0; looser= 0;
					
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				f[i] =Integer.parseInt(st.nextToken());
				set[f[i]] = true;
			}

			for (int i = 0; i < N; i++) {
				

				for (int j = 1; j < 19; j++) {
					if (set[j] !=true) { s[i] = j;
						set[j]= true;
						break;
					}
				}
			
			}
			System.out.println(Arrays.toString(f));
			System.out.println(Arrays.toString(s));
			perm(0);
			sb.append("#"+tc+" "+ looser+" "+winner+"\n");
		}
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt == N ) {
			int win = 0;
			// win 0 이면 무승부 
			for(int i = 0 ; i<N ; i++) {
				if(f[i]>per[i]) {
					win -= (f[i]+per[i]);
				}else if(f[i]<per[i]) win += (f[i]+per[i]);
			}
			if(win>0) {
				winner+=1;
			}
			else if(win<0){
				looser+=1;
			}
			return;
		}
		for(int i = 0;i<N;i++) {
			if(v[i]) continue;
			v[i]= true;
			per[cnt] = s[i];
			perm(cnt+1);
			v[i]= false;
		}
	}
	
}
