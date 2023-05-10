package gwonjihun.baejjon;


import java.io.*;
import java.util.*;

public class Main_boj_1806 {

	static int[] arr;
	static int len, n, goal, left, right;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		arr = new int[n];
		len = Integer.MAX_VALUE;
		left = 0; right = 0;

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i <n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		//right -left +1로 길이 계산을 한다.

		int sum = arr[left];
		//초기 덧셈과정
		while(true) 
		{
//			System.out.println(sum);
			if(left>=n|| right>=n) {
//				System.out.println(left+" "+ right);
				break;
			}
			if(sum < goal) {
				right++;
				if(right<n) {
					sum+=arr[right];
				}
			}else {
//				System.out.println("!!!");
				len = Math.min(len, right-left+1);
				sum-=arr[left];
				left++;
			}
		}
		System.out.println(len==Integer.MAX_VALUE? 0:len);
	}
}
