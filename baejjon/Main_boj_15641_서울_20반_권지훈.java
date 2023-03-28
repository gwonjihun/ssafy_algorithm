package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_15641_서울_20반_권지훈 {

		static int N,M;
		static int[] result;
		
		static StringBuilder sb = new StringBuilder();
		
		public static void main(String[] args) throws Exception{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			result= new int[M];
			
			// ?��?�� ?��?�� ?��?��
			
			perm(0);
			
			System.out.print(sb);
		}

		static void perm(int cnt) {
			
			if(cnt == M) {
				
				for(int i : result) sb.append(i).append(" ");
				sb.append("\n");
				
				return;
			}
			
			for(int i=0;i<N;i++) 
			{
				
				result[cnt]= i+1;
				perm(cnt+1);
				
				
			}
		}
	}
