package gwonjihun.baejjon;
import java.util.*;
import java.io.*;
public class start_14889 {
	static int N;
	static int[][] arr ;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		// arr ?ž…? ¥
		for(int i=0;i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N ;j++) {
				arr[i][j] =Integer.parseInt( st.nextToken());
			}
		}

		visited = new boolean[N];
		back(0,0);
		System.out.println(min);
	}
	
	public static void back(int idx, int depth) {
		if(depth == N/2) {
			//?—¬ê¸°ì„œ ???› ?„ ? •?´ ? „ë¶? ??‚¬?Œ
			diff();
			return;
		}
		for(int i=idx;i<N;i++) {
			if(!visited[i]) {
				visited[i]= true;
				back(i+1,depth+1);
				visited[i]= false;
			}
		}
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i;j<N;j++){
				if(visited[i]==true && visited[j]==true) {
					start += arr[i][j];
					start += arr[j][i];
				}else if(visited[i]==false && visited[j]==false){
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		
		int abss = Math.abs(start - link);
//		System.out.println("min change:"+min);
		min = Math.min(min, abss);
	}

}
