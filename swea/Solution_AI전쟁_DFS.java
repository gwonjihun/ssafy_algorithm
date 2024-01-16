package gwonjihun.swea;


import java.io.*;
import java.util.*;

public class Solution_AI전쟁_DFS{
    static int n;
    static int result;
    
    static int[][] sums;
	static boolean[] visited;//이거 비트 마스킹을 해준다.ㅋ
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 최정예 요원의 수 입력
            n = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            
            // 최정예 요원들의 능력치를 저장할 배열
            visited = new boolean[n];
            sums = new int[n][3];
            // 최정예 요원들의 능력치 입력
           	int[] agent =  new int[3];
            
            for (int j = 0; j < n; j++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    agent[k] = Integer.parseInt(st.nextToken());
                }
                for(int k = 0 ; k< 3;k++) {
                	for(int m = 0 ; m < 3;m++) {
                		if(m==k) continue;
                		sums[j][k] += agent[m]; 
                	}
                }
            }
            if(n<3) {
                System.out.println("#" + (t + 1) + " " + -1);
            	continue;
            }
            perm(0,0);
            // 출력
            System.out.println("#" + (t + 1) + " " + (result== Integer.MAX_VALUE? -1 : result));
        }
    }    
        private static void perm(int depth, int sum) {
        	if(depth==3) {
        		int temp = sum;
        		for(int i = 0 ; i<n;i++) {
        			if(visited[i]) continue;
        			temp += Math.min(sums[i][0], Math.min(sums[i][1], sums[i][2]));
        		}
        		result = Math.min(temp, result);
        		return;
        	}
        	
        	for(int i = 0 ; i <n;i++) {
        		if(visited[i]) continue;
        		visited[i]=true;
        		perm(depth+1,sum+sums[i][depth]);
        		visited[i]=false;
        	}
        }
    

}