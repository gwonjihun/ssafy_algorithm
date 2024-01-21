package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_15662_aga {
	static int t;
	static int[][] gears;
	//S는 1 N은 0
	static int k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		gears = new int[t][8];
		
		for(int i = 0 ; i < t ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < 8;j++) {
				gears[i][j] = str.charAt(j)-'0';
			}
		}
		
		k = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			int[] dirs = new int[t];
			dirs[start]= d;
			//dirs : 각 톱니 바퀴마다의 돌아가는 방향
			//start +1 부터 T까지 가능 경우

//			change(start,d);
			for(int s = start+1; s<t;s++) {
//				기준점 왼쪽
				if(gears[s-1][2]!=gears[s][6]) {
//					System.out.println(s+"가 회전이 일어남");
					//같은 극이면은 
					dirs[s]= dirs[s-1]*(-1);
				}else {
					break;
				}
			}
//			start -1 부터 0까지 검토해야겠지
			for(int s = start-1;s>=0;s--) {
//				기준점이 오른쪽
				if(gears[s+1][6]!=gears[s][2]) {

//					System.out.println(s+"가 회전이 일어남");
					//같은 극이면은 
					dirs[s]= dirs[s+1]*(-1);
				}else {
					break;
				}
			}
			//그러고 각 톱니바퀴를 먼저 회전시켜주고
			//start 톱니 바퀴를 회전한다.
			for(int T = 0 ; T < t;T++) {
				if(dirs[T]==0) continue;
//				if(T == start) continue;
				change(T, dirs[T]);
			}
//			System.out.println("히히힛");
			
		}
		int sum = 0 ;
		for(int[] arr : gears) {
			sum += arr[0];
		}
		System.out.println(sum);
		
	}
	
	static void change(int idx, int dir) {
//		System.out.println("change method call");
//		System.out.println(idx + " " + dir + "이거가 idx, dir이다");
		if(dir == 1 ) {
			int temp = gears[idx][7];
			// 시계방향
			// 0부터 7까지로 갈때 0이 12시 3이 6시이다.
			for(int i = 7; i>0;i--) {
				gears[idx][i]= gears[idx][i-1];
			}
			gears[idx][0]= temp;
		}else  {
//			System.out.println("reverse");
			int temp = gears[idx][0];
//			System.out.println(temp);
			//이게반시계방향
			for(int i = 0 ; i < 7;i++) {
				gears[idx][i] = gears[idx][i+1];
			}
			gears[idx][7] = temp;
			
		}
	}
}
