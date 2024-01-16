package gwonjihun.swea;

import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;
public class Solution_삼각김밥 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			int firstHeight = getHeight(first);
			int secondHeight = getHeight(second);
			
//			System.out.println(firstHeight + " , " + secondHeight);
			int firstIdx = findPosition(first, firstHeight);
			int secondIdx = findPosition(second, secondHeight);
			
			int a = secondIdx - firstIdx;
			int b = secondHeight - firstHeight;
//			System.out.println("(fh, fi) : "+ firstHeight + " , "+ firstIdx +" )");
//			System.out.println("(sh, si) : "+ secondHeight + " , "+ secondIdx +" )");
//			System.out.println(a+ " " + b );
			int result;
			if((a>=0 && b<0) ||(b>=0 && a<0)) {
				result = Math.abs(a-b);
			}else {
				result = Math.max(Math.abs(a),Math.abs(b));
			}
			System.out.println("#"+test_case+" "+result);
			//ㄷ둘의 부호가 다른 경우 둘을 뺀 절대값이 나와야한다.
		}

    }


    private static int getHeight(int num) {
        // 높이 = (루트(8 * num - 7) - 1) / 2
//        return (int) ((Math.sqrt(8 * num - 7) + 1) / 2);
        return  (int) Math.ceil((-1 + Math.sqrt(1 + 8 * num)) / 2);

    }
    private static int findPosition(int value, int height) {
        int position = value - (height * (height - 1) / 2);
        return position;
    }

}