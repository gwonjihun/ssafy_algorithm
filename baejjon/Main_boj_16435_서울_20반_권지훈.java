package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_16435_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int sl = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		for(int i = 0;i<N; i++) {
			if(arr[i] <= sl) sl++;
		}
		
		System.out.println(sl);
		
		br.close();
	}
}
