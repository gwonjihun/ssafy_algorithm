package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

import javax.swing.text.html.MinimalHTMLWriter;

public class Main_boj_9663_aga {

	static int N;
	static int[] col;
	//col[idx]에는 idx행번에 몇번째 열에 있는지의 위치 값이 저장해서 진행한다.
	//이떄 당시에 col[i] == col[i+2]인 경우에는 퀸의 특성인 직선 위치가 겹치기 때문에 위치 불가능하다.
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1]; // 0이면 해당 위치는 아직 퀸이 없는 경우이다.
		cnt = 0 ;
		dfs(1);
		System.out.println(cnt);
	}
	static void dfs(int depth) {
		//depth : depth에 해당하는 행에 퀸을 놓을것이다는 의미.
		//풀이 방식 먼저 depth에 올때
		if(depth>N) {
			//이러면 퀸의 위치를 전부 놓았다는 의미이기 때문에 정상적으로 종료한다.
			cnt+=1;
			return;
		}
		
		for(int i = 1 ; i<=N;i++) {
			col[depth] = i;
			if(isAvailable(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	static boolean isAvailable(int idx) {
		for(int i =1;i<idx;i++) {
			if(col[i] == col[idx] || Math.abs(col[i]-col[idx]) == idx-i) 
				return false;
		}
		return true;
	}
}
