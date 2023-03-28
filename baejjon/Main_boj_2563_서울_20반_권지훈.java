package gwonjihun.baejjon;
import java.util.*;
import java.io.*;

public class Main_boj_2563_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[100][100];
		for(int i=0; i<N*2;i=i+2) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			for(int j=x-1;j<x+9;j++) {
				for(int k = y-1;k<y+9;k++) {
					arr[j][k]=1;
				}
			}
			

		}

		int cnt = 0;
		for(int i = 0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
