package gwonjihun.baejjon;
import java.io.*;
import java.util.*;

public class Main_boj_4803_ing_goal_0507 {
	static ArrayList<Integer>[] graph;
	static int N;
	static int cnt;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
		}
	}
	
	static void print(int cnt) {
		if(cnt>1) System.out.printf("A forest of {} trees.\n",cnt);
		else if(cnt==1) System.out.println("There is one tree.");
		else System.out.println("No tree.");
	}
}
