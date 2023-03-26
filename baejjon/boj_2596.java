package gwonjihun.baejjon;

import java.io.*;
import java.util.Scanner;
public class boj_2596 {
/*1. ? „ì²? ë¬¸ì?—´?„ ì¤? 1ê°œë?? ?™•?¸?•´ë³´ê³  
 * 
 * */
	static String[] sa = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	public static int check(String msg) {
		for(int z=0;z<8;z++) {
			if (msg.equals(sa[z])) return z;
		}
//		?™?¼?•œ ê°’ì´ë©? ë°”ë¡œ ?•¨?ˆ˜ ì¢…ë£Œ	
		
//		?—¬ê¸°ì— ?™”?‹¤?Š” ?œ»?? ë°°ì—´ê³? ë°”ë¡œ ?™?¼?•œê²ƒì´ ?•„?‹ˆê³? ?˜¤ë¥˜ê? ë°œìƒ?•œ ë¬¸ì?—´?´?¼?Š” ?˜ë¯¸ì´ê¸? ?•Œë¬¸ì—
		int check_flag = 0;
		
		char[] a = msg.toCharArray();
		//ë¬¸ì ?‹¨?œ„ë¡? ë¹„êµë¥? ?œ„?•´ string.toCharArray?•¨?ˆ˜ ?‚¬?š©
		for(int z = 0; z<8;z++) {
			check_flag=0;
			char[] b = sa[z].toCharArray();
			//ë¬¸ì ?‹¨?œ„ë¡? ë¹„êµë¥? ?œ„?•´ string.toCharArray?•¨?ˆ˜ ?‚¬?š©
			for(int j = 0; j<6; j++) {
				// ê°? ?œ„ì¹˜ì˜ ë¬¸ì?—´?˜ ê°’ì´ ?‹¤ë¥? ê²½ìš° cnt ì¦ê?.
				if (a[j]!=b[j]) {check_flag++;}				
			}
			// check_flagê°? 2?´?ƒ ?‹¤ë¥? ê²½ìš°?Š” ?•´?‹¹ ë¬¸ì?—´?´ ?•„?‹ˆë¯?ë¡? ifë¬¸ìœ¼ë¡? ì§??‚˜ì³ì¤Œ
			if (check_flag<2) {
				return z;
			}
			
		}
//		ìµœì¢…? ?œ¼ë¡? saë°°ì—´ ?‚´ë¶??˜ ëª¨ë“  0,1 ê°’ìœ¼ë¡? ?´ë£¨ì–´ì§? ë¬¸ì?—´ê³? ë¹„êµ?•´?„œ ì°¾ì„ ?ˆ˜ ?—†?œ¼ë¯?ë¡? -1?„ ë¦¬í„´
		return -1;
	}
	
	public static void main(String[] args){
		/*
		 * 1. ë¨¼ì? ?…? ¥?„ ë°›ì•„?„œ 6ë¹„íŠ¸ ?‹¨?œ„ë¡? ìª¼ê°œ?„œ ???¥?•´ì¤??‹¤.
		 * 2. ê·¸ë’¤?— ë¦¬í„´ê°’ì„ ì¡°íšŒ?•˜?Š” ë°©ì‹?„ 
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String pw = sc.nextLine();
		String[] answer = {"A","B","C","D","E","F","G","H"};
		
		String[] str = new String[num];
		int[] ans = new int[num];
		
		//for?˜ iê°’ì„ ?†µ?•´?„œ substring?˜ ?‹œ?‘ ì£¼ì†Œë¥? ì°ì–´?†¨ê¸? ?•Œë¬¸ì—
		//str, ans?—?„œ?Š” ?•´?‹¹ ê°’ì„ int/intë¡? ?‚˜?ˆ„?–´?„œ array out of indexing?—?Ÿ¬ë¥? ë°©ì??•´?•¼?•˜ë©?
		//?˜?•œ flag?˜ ê°’ì„ ê¸°ë°˜?œ¼ë¡? ìµœì¢…? ?œ¼ë¡? ê²°ê³¼ ë¦¬í„´?•´ì¤??‹¤.
		for(int i=0;i<pw.length();i+=6) {
			//		6ê°œì˜ ë¬¸ìë§ˆë‹¤ ë¬¸ì?—´ ë°°ì—´ë¡? ? „?™˜
			str[i/6]=pw.substring(i, i+6);
			// 
			int flag = check(str[i/6]);
			
			//check?•¨?ˆ˜ë¥? ?†µ?•´?„œ ?‚˜?˜¨ ê²°ê³¼?— ?”°?¼ ?–‘?ˆ˜?´ë©? ansë°°ì—´?— ???¥ ë¬¸ì?—´?„ ëª»ì°¾??ê²½ìš° ë°”ë¡œ ?•´?‹¹ ?œ„ì¹? ì¶œë ¥ ?›„ ì¢…ë£Œ
			if(flag < 0) {
				// ?˜ëª»ëœ ?œ„ì¹˜ë?? ì°¾ê³  main ?•¨?ˆ˜ ì¢…ë£Œ
				System.out.println(i/6+1);
				return;
			}else {
				ans[i/6]=flag;
				// flagë¥? ?†µ?•´?„œ ?•”?˜¸ ?•´?…?œ ë¬¸ì ê´?? ¨ ?¸?±?Š¤ ???¥
			}
		
		}
		for(int i : ans) {
			//? •?‹µ ì¶œë ¥
			System.out.printf("%s",answer[i]);
		}
		

		sc.close();
	}
	
}