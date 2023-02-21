package gwonjihun.baekjjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_boj_9663_서울_20반_권지훈 {
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 }, dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] arr;
	static int N,result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		// 체스 갯수
		dfs(0);
		System.out.println(result);
	}

	// che -> 체스 갯수
	// cnt -> 8개가 전부다 문제 없이 해결된 경우
	static void dfs(int cnt) {
		if(cnt==N) {
			result++;
			return;
		}
		// cnt행에서 가능한 열을 찾아준다는 거닌깐.
		for(int i = 0 ; i<N;i++) {
			if(arr[cnt][i]!= 0 ) continue;
			arr[cnt][i]= cnt+1;
			for(int j = 0; j<8;j++) {
				int nx = cnt;
				int ny = i;
				while(true) {
					if( 0>nx || 0>ny || N<=nx||N<=ny) break;
					if(arr[nx][ny]==0) {
					arr[nx][ny]=cnt+1;
					}
					nx += dx[j];
					ny += dy[j];
					
				}
			}
			
			dfs(cnt+1);
			arr[cnt][i] = 0;
			//이제 여기서 기존에 했던 것들을 빼줘야해
			for(int x=cnt; x<N;x++) {
				for(int y = 0 ; y<N;y++) {
					if(arr[x][y]==cnt+1) {
						arr[x][y]= 0;
						}
					}
				}
			}
	
		}
		
		
		
	}

