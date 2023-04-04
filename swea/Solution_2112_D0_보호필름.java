package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_2112_D0_보호필름 {
	
	static int[][] arr;
	static int D,W,K,result;
	static boolean[] isSelect;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " " );
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr= new int[D][W];
			result=Integer.MAX_VALUE;
			isSelect = new boolean[D];
			for(int i = 0; i<D;i++) {
				 st = new StringTokenizer(br.readLine(), " " );
				 for(int j=0; j<W;j++) {
					 arr[i][j] = Integer.parseInt(st.nextToken());
				 }
			}
			if(check()) {
				System.out.println("#"+t+" 0");
			}else {
				subset(0);
				System.out.println("#"+t+" "+result);
			}
			
		}
	}
	static void subset(int cnt) {
		if(cnt==D) {
			int[][] temp = new int[D][W];
			for(int i =0 ; i <D;i++) {
				for(int j = 0 ; j<W;j++) {
					temp[i][j] = arr[i][j];
				}
			}
			dfs(arr,0,0);
			for(int i =0 ; i <D;i++) {
				for(int j = 0 ; j<W;j++) {
					arr[i][j]= temp[i][j] ;
				}
			}
			return;
		}
		isSelect[cnt]= true;
		subset(cnt+1);
		isSelect[cnt]= false;
		subset(cnt+1);
	}
	static void dfs(int[][] arr, int cnt, int index) {
		if(cnt>result) return;
		if(index==D) {
			if(check()) {
				if(cnt<result) result =cnt;
			}
			return;
		}
		if(isSelect[index]) {
			Arrays.fill(arr[index], 0);
			dfs(arr,cnt+1,index+1);
			Arrays.fill(arr[index], 1);
			dfs(arr,cnt+1,index+1);
		}else {

			dfs(arr,cnt,index+1);
		}
	}
	static boolean check() {
		for(int i=0;i<W;i++) {
			int cnt =1;
			int start = arr[0][i];
			boolean pass = false;
			
			for(int j=1;j<D;j++) {
				if(start == arr[j][i])
				{
					cnt++;
				}else {
					start = arr[j][i];
					cnt=1;
				}
				if(cnt==K) {
					pass= true;
					break;
				}
			}
			if(pass==false) {
				return false;
				
			}
		}
		return true;
	}
}
