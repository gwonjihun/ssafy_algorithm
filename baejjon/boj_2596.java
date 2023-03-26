package gwonjihun.baejjon;

import java.io.*;
import java.util.Scanner;
public class boj_2596 {
/*1. ?���? 문자?��?�� �? 1개�?? ?��?��?��보고 
 * 
 * */
	static String[] sa = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	public static int check(String msg) {
		for(int z=0;z<8;z++) {
			if (msg.equals(sa[z])) return z;
		}
//		?��?��?�� 값이�? 바로 ?��?�� 종료	
		
//		?��기에 ?��?��?�� ?��?? 배열�? 바로 ?��?��?��것이 ?��?���? ?��류�? 발생?�� 문자?��?��?��?�� ?��미이�? ?��문에
		int check_flag = 0;
		
		char[] a = msg.toCharArray();
		//문자 ?��?���? 비교�? ?��?�� string.toCharArray?��?�� ?��?��
		for(int z = 0; z<8;z++) {
			check_flag=0;
			char[] b = sa[z].toCharArray();
			//문자 ?��?���? 비교�? ?��?�� string.toCharArray?��?�� ?��?��
			for(int j = 0; j<6; j++) {
				// �? ?��치의 문자?��?�� 값이 ?���? 경우 cnt 증�?.
				if (a[j]!=b[j]) {check_flag++;}				
			}
			// check_flag�? 2?��?�� ?���? 경우?�� ?��?�� 문자?��?�� ?��?���?�? if문으�? �??��쳐줌
			if (check_flag<2) {
				return z;
			}
			
		}
//		최종?��?���? sa배열 ?���??�� 모든 0,1 값으�? ?��루어�? 문자?���? 비교?��?�� 찾을 ?�� ?��?���?�? -1?�� 리턴
		return -1;
	}
	
	public static void main(String[] args){
		/*
		 * 1. 먼�? ?��?��?�� 받아?�� 6비트 ?��?���? 쪼개?�� ???��?���??��.
		 * 2. 그뒤?�� 리턴값을 조회?��?�� 방식?�� 
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String pw = sc.nextLine();
		String[] answer = {"A","B","C","D","E","F","G","H"};
		
		String[] str = new String[num];
		int[] ans = new int[num];
		
		//for?�� i값을 ?��?��?�� substring?�� ?��?�� 주소�? 찍어?���? ?��문에
		//str, ans?��?��?�� ?��?�� 값을 int/int�? ?��?��?��?�� array out of indexing?��?���? 방�??��?��?���?
		//?��?�� flag?�� 값을 기반?���? 최종?��?���? 결과 리턴?���??��.
		for(int i=0;i<pw.length();i+=6) {
			//		6개의 문자마다 문자?�� 배열�? ?��?��
			str[i/6]=pw.substring(i, i+6);
			// 
			int flag = check(str[i/6]);
			
			//check?��?���? ?��?��?�� ?��?�� 결과?�� ?��?�� ?��?��?���? ans배열?�� ???�� 문자?��?�� 못찾??경우 바로 ?��?�� ?���? 출력 ?�� 종료
			if(flag < 0) {
				// ?��못된 ?��치�?? 찾고 main ?��?�� 종료
				System.out.println(i/6+1);
				return;
			}else {
				ans[i/6]=flag;
				// flag�? ?��?��?�� ?��?�� ?��?��?�� 문자 �??�� ?��?��?�� ???��
			}
		
		}
		for(int i : ans) {
			//?��?�� 출력
			System.out.printf("%s",answer[i]);
		}
		

		sc.close();
	}
	
}