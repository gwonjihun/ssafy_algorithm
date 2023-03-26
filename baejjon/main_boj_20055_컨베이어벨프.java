package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class main_boj_20055_Ïª®Î≤†?ù¥?ñ¥Î≤®ÌîÑ {



	static int[]balt;
	static int N, K;
	static boolean[] robot;
	static int step = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		balt = new int[2*N];
		robot = new boolean[N];
		for (int i = 0; i < 2*N; i++) {
			balt[i] = Integer.parseInt(st.nextToken());
		}

		while(check()) {

			//Î∞∞Ïó¥?ùÑ ?öå?†Ñ?ïú?ã§
			int temp = balt[balt.length - 1];
			for (int i =balt.length - 1; i > 0; i--) {
				balt[i] = balt[i - 1];
			}
			balt[0] = temp;
			//Î°úÎ¥á?öå?†Ñ
			for(int i=robot.length-1; i>0;i--){
				robot[i] = robot[i-1];
			}
			robot[0] = robot[N-1] =false;

			for(int i = N-1; i>0 ; i--){
				if(robot[i-1] && !robot[i] && balt[i]>=1){
					robot[i] = robot[i-1];
					robot[i-1] = false;
					balt[i]--;
				}
			}
			if(balt[0]>0){
				robot[0]= true;
				balt[0]--;
			}


			step++;
		}
		System.out.println(step);
	}
	public static boolean check(){
		int cnt = 0;
		for(int i = 0 ; i< balt.length;i++){
			if (balt[i]==0) cnt++;
		}
		if (cnt>=K) return false;
		return true;
	}


}
