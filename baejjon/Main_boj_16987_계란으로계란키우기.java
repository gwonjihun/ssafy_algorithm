package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Main_boj_16987_계란으로계란키우기 {

	static int[][] egg;
	static int n;
	static int Mcnt=0;
	static boolean[] broken;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		egg = new int[n][2];
		broken = new boolean[n];
		for(int i = 0 ; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0,egg,broken);
		System.out.println(Mcnt);
	}
	
	static void dfs(int left,int[][] eg, boolean[] broke) {
//		System.out.println("method start left : " + left);
		if(left==n) {
//			System.out.println("N 도달");
			int cnt=0 ;
			for(int i = 0 ; i <n ; i++) {
				if(broke[i]) {
					cnt++;
				}
			}
			if(Mcnt<cnt) Mcnt = cnt;
			return;
		}
		if(broke[left]) {//깨진경우

//			System.out.println("Left가 이미 꺠져있음");
			dfs(left+1,eg,broke);
		}else {
			boolean flag= true;
			for(int i=0;i<n;i++) {

//				System.out.println(left+ " -> broken :" + i);
				if(i==left) continue;
				if(broke[i]) continue;
				eg[i][0] -= eg[left][1];
				if(eg[i][0]<=0) {
					broke[i] = true;
				}
				eg[left][0] -= eg[i][1];
				if(eg[left][0]<=0) {
					broke[left] = true;
				}
//				System.out.println("DFS start");
				flag = false;
				dfs(left+1,eg,broke);
				eg[i][0] += eg[left][1];
				eg[left][0] += eg[i][1];
				if(eg[i][0]>0) {
					broke[i] = false;
				}
				if(eg[left][0]>0) {
					broke[left] = false;
				}
			}
			//이건 아무것도 깨지 않고 내려놓는 경우
			if(flag)
			dfs(left+1,eg,broke);
		}
		
	}
}
