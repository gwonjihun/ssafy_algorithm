package gwonjihun.swea;
import java.io.*;
import java.util.*;

public class Solution_D0_벌꿀_서울_20반_권지훈 {

	static int[][] map; // 꿀의 위치
	static boolean[][] visited;
	static int N, M, C,answer;// N은 꿀통의크기, M 채위가능 길이, C는 통값의 최대
	static int cost1, cost2;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<= tc ;t++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			v = new boolean[M];
			for (int i = 0 ; i< N ; i ++) {
				answer = 0;
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j <N ; j++){
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			//4개고 2개씩 선택이면 0 1 2 4-1+1
			//4개고 3개씩 선택이면 최대 2개
			//4-
			boolean flag;
			for(int i = 0; i < N;i++){
				for(int j = 0; j<= N-M;j++){
					for(int k=j; k<j+M;k++){
						visited[i][k]=true;
						//일꿀1이 채취하는 벌꿀 라인
					}

					for(int a= 0 ; a<N;a++){
						for(int b=0; b<= N-M;b++){
							flag= true;
							for(int c = b ;c < b+M ; c++){
								if(visited[a][c]) {
									flag = false;
									break;
								}
							}
							//여기까지 해서 벌꿀 채취 지역에 대한 반복문이고
							//if 문을 통해서 꿀통이 겹치는지를 체크해준다.
							if(!flag) continue;
							//여기서부터는 해당 위치의 값을 기반으로 최적으로 뽑을 수 있는가를 확인해 줘야한다.
							//여기서는 부분집합
							check(i,j,a,b,0);
							answer = Math.max(cost1+cost2,answer);
							cost1 =0;
							cost2 = 0 ;
							//여기서
						}
					}
					// 백트래킹이고
					for(int k=j; k<j+M;k++){
						visited[i][k]=false;
						//일꿀1이 채취하는 벌꿀 라인
					}
				}
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
//	12 / 21
//	21 / 12
//	똑같아
	static void check(int x, int y, int a, int b ,int  depth) {
		if(depth == M){
			int c1=0,c2=0,count1=0,count2=0;
			for(int i=0;i<M;i++) {
				if (v[i]) {
					count1 += map[x][y + i];
					c1 += map[x][y + i] * map[x][y + i];
					count2 += map[a][b + i];
					c2 += map[a][b + i] * map[a][b + i];
				}
			}
			if (count1 <= C) cost1 = Math.max(cost1,c1);
			if (count2 <= C) cost2 = Math.max(cost2,c2);
			return;
		}
		v[depth]=true;
		check(x,y,a,b,depth+1);
		v[depth]=false;
		check(x,y,a,b,depth+1);
	}
}
