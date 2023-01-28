package algorithm;

import java.io.*;
import java.util.Scanner;
public class boj_2596 {
/*1. 전체 문자열을 중 1개를 확인해보고 
 * 
 * */
	static String[] sa = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	public static int check(String msg) {
		for(int z=0;z<8;z++) {
			if (msg.equals(sa[z])) return z;
		}
//		동일한 값이면 바로 함수 종료	
		
//		여기에 왔다는 뜻은 배열과 바로 동일한것이 아니고 오류가 발생한 문자열이라는 의미이기 때문에
		int check_flag = 0;
		
		char[] a = msg.toCharArray();
		//문자 단위로 비교를 위해 string.toCharArray함수 사용
		for(int z = 0; z<8;z++) {
			check_flag=0;
			char[] b = sa[z].toCharArray();
			//문자 단위로 비교를 위해 string.toCharArray함수 사용
			for(int j = 0; j<6; j++) {
				// 각 위치의 문자열의 값이 다른 경우 cnt 증가.
				if (a[j]!=b[j]) {check_flag++;}				
			}
			// check_flag가 2이상 다른 경우는 해당 문자열이 아니므로 if문으로 지나쳐줌
			if (check_flag<2) {
				return z;
			}
			
		}
//		최종적으로 sa배열 내부의 모든 0,1 값으로 이루어진 문자열과 비교해서 찾을 수 없으므로 -1을 리턴
		return -1;
	}
	
	public static void main(String[] args){
		/*
		 * 1. 먼저 입력을 받아서 6비트 단위로 쪼개서 저장해준다.
		 * 2. 그뒤에 리턴값을 조회하는 방식을 
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String pw = sc.nextLine();
		String[] answer = {"A","B","C","D","E","F","G","H"};
		
		String[] str = new String[num];
		int[] ans = new int[num];
		
		//for의 i값을 통해서 substring의 시작 주소를 찍어놨기 때문에
		//str, ans에서는 해당 값을 int/int로 나누어서 array out of indexing에러를 방지해야하며
		//또한 flag의 값을 기반으로 최종적으로 결과 리턴해준다.
		for(int i=0;i<pw.length();i+=6) {
			//		6개의 문자마다 문자열 배열로 전환
			str[i/6]=pw.substring(i, i+6);
			// 
			int flag = check(str[i/6]);
			
			//check함수를 통해서 나온 결과에 따라 양수이면 ans배열에 저장 문자열을 못찾은경우 바로 해당 위치 출력 후 종료
			if(flag < 0) {
				// 잘못된 위치를 찾고 main 함수 종료
				System.out.println(i/6+1);
				return;
			}else {
				ans[i/6]=flag;
				// flag를 통해서 암호 해독된 문자 관련 인덱스 저장
			}
		
		}
		for(int i : ans) {
			//정답 출력
			System.out.printf("%s",answer[i]);
		}
		

		sc.close();
	}
	
}