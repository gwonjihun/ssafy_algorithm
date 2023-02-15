package gwonjihun.baekjjon;

import java.util.*;
import java.io.*;
public class Solution_D4_1233_서울_20반_권지훈 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int answer = 1;
			
			for(int node=1;node<=n;node++) {
				// 한줄을 nodeInfo에 저장 
				String[] nodeInfo = br.readLine().split(" ");
				
				// 리프노드가 아니면서 값이 숫자이거나 , 리프노드이면서 연산자일 경우 탈출
				if(nodeInfo.length>=3 && nodeInfo[1].charAt(0) >='0' || nodeInfo.length==2 && nodeInfo[1].charAt(0)<'0') {
					// 나머지 줄을 할당하지 않고 버림
					for(int i=node+1;i<=n;i++) {
						br.readLine();
					}
					answer = 0;
					break;
				}
				
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}