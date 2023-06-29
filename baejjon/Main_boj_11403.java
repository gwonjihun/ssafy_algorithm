package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11403 {

	 
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        StringTokenizer st;
	 
	        int N = Integer.parseInt(br.readLine());
	        int[][] arr = new int[N][N];
	 
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        
	        for (int k = 0; k < N; k++) {
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    // 단순히 갈 수 있는 경로가 있는지만 체크함.
	                	arr[i][j] = arr[i][k]*arr[k][j]== 1? 1 : arr[i][j];
	                }
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < N; j++) {
	                sb.append(arr[i][j] + " ");
	            }
	            sb.append("\n");
	        }
	        
	        bw.write(sb.toString());
	        bw.flush();
	        bw.close();
	        br.close();
	    }
	 
	
	 
}
