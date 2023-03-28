package gwonjihun.baejjon;
import java.util.*;
import java.io.*;
public class Main_boj_1244_서울_20반_권지훈 {
	static int N;
	static int[] arr;
	static int T;
	static int[][] menu;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		T = Integer.parseInt(br.readLine());
		menu = new int[T][2];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;j++) {
				menu[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<T;i++) {
			// if�? ?��?�� 구분
			if(menu[i][0]==1) {
				int temp=1 ;
				//1~8번으�? 계산?��?��
				//1~8번으�? 계산?���? ?��문에 
				while(menu[i][1]*temp <= N) { 
					arr[menu[i][1]*temp-1] = arr[menu[i][1]*temp-1]==0 ? 1: 0;
					temp++;
				}
			}else {
				//
				int idx = 0;
				int si = menu[i][1];
				while(true) {
					if (si-idx-1 <0 || si+idx-1 >=N) break;
					if(arr[si-idx-1] == arr[si+idx-1]) {
						arr[si-idx-1] = arr[si-idx-1]==0 ? 1: 0;
						arr[si+idx-1] = arr[si-idx-1];
					}else {
						break;
					}
					idx++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			if((i+1)%20==0) {
				sb.append(arr[i]).append("\n");
			}else {
				sb.append(arr[i]).append(" ");
			}
		}
		System.out.println(sb);
	}
}
