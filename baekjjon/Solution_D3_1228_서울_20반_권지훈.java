package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;
public class Solution_D3_1228_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int T = 1 ; T<=10; T++) {
			int len = Integer.parseInt(br.readLine());
			int[] str = new int[len];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<len;i++) {
				str[i] = Integer.parseInt(st.nextToken());
			}
			int clen = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(),"I");
			for(int i=0;i<clen;i++) {
				String tmp = st.nextToken();
				// tm 은 1,5 400905,...으로 분할했음.
				StringTokenizer tm = new StringTokenizer(tmp);
				int start = Integer.parseInt(tm.nextToken());
				int length = Integer.parseInt(tm.nextToken());
				int[] arr = new int[length];
				if(start> len || start+length>len) continue;

				for(int j = 0 ; j<length;j++) {
					arr[j]=Integer.parseInt(tm.nextToken());
					for(int k=0;k<length; k++) {
						if(start+k<len) {
						str[start+k]=arr[k];
						}
					}
				}

			}
			for(int i =0; i<10;i++) {
				System.out.print(str[i]+" ");
			}System.out.println();
		
		}
		
	}
}
