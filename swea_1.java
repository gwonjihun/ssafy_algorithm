import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swea_1 {
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int Max_count = 0;

	public static void DFS(char[][] arr,boolean[][] vis, int x,int y, int cnt,String str) {
		vis[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if (((0<=nx && nx<arr.length)&&(0<=ny && ny<arr[0].length))&&(vis[nx][ny]==false)&&(str.contains(String.valueOf(arr[nx][ny]))==false)) {
				vis[nx][ny]=true;
				str = str+ arr[nx][ny];
				DFS(arr,vis,nx,ny,cnt+1,str);
				vis[nx][ny]=false;
			}
			Max_count = Math.max(Max_count, cnt);
		}
	}
	public static void main(String args[]) throws Exception
	{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = Integer.parseInt(bf.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int X,Y;
			StringTokenizer xy_input = new StringTokenizer( bf.readLine()," ");
			X = Integer.parseInt(xy_input.nextToken());
			Y = Integer.parseInt(xy_input.nextToken());
			char[][] arr = new char[X][Y];
			boolean[][] vis = new boolean[X][Y];
			for(int i=0; i< X; i++) {
				char[] input_temp = bf.readLine().toCharArray();
				for(int j=0; j< Y; j++) {
					arr[i][j]= input_temp[j];
					vis[i][j]= false;
				}
			}
			Max_count = 0;
			DFS(arr,vis,0,0,1,String.valueOf(arr[0][0]));
			
			System.out.printf("#%d %d\n",test_case,Max_count);
			
//			for(int i=0; i< X; i++) {
//				for(int j=0; j< Y; j++) {
//					System.out.printf("%c",arr[i][j]);
//				}
//			}
			
			
		}
	}
}
