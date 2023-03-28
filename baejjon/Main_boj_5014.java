package gwonjihun.baejjon;
import java.io.*;
import java.util.*;

public class Main_boj_5014 {
	
	static boolean[] visited;
	static int f,s,g,u,d;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int cnt =Integer.MAX_VALUE;
		visited = new boolean[f+1];
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {s,0});
		visited[0]=true;
		visited[s]=true;
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			if(cur[0]==g) {
				cnt = Math.min(cnt, cur[1]);
			}
			int up = cur[0]+u;
			if(inRange(up) && !visited[up])
			{
				q.add(new int[] {up,cur[1]+1});
				visited[up] =true;
			}
			int down = cur[0]-d;
			if(inRange(down) && !visited[down])
			{
				q.add(new int[] {down,cur[1]+1});
				visited[down] =true;
			}
			
		}
		System.out.println(cnt==Integer.MAX_VALUE? "use the stairs" : cnt);
	}
	static boolean inRange(int x) {
		return 1<=x&& x<=f;
	}
}
