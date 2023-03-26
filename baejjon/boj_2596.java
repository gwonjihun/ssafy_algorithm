package gwonjihun.baejjon;

import java.io.*;
import java.util.Scanner;
public class boj_2596 {
/*1. ? μ²? λ¬Έμ?΄? μ€? 1κ°λ?? ??Έ?΄λ³΄κ³  
 * 
 * */
	static String[] sa = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	public static int check(String msg) {
		for(int z=0;z<8;z++) {
			if (msg.equals(sa[z])) return z;
		}
//		??Ό? κ°μ΄λ©? λ°λ‘ ?¨? μ’λ£	
		
//		?¬κΈ°μ ??€? ?»?? λ°°μ΄κ³? λ°λ‘ ??Ό?κ²μ΄ ??κ³? ?€λ₯κ? λ°μ? λ¬Έμ?΄?΄?Ό? ?λ―Έμ΄κΈ? ?λ¬Έμ
		int check_flag = 0;
		
		char[] a = msg.toCharArray();
		//λ¬Έμ ?¨?λ‘? λΉκ΅λ₯? ??΄ string.toCharArray?¨? ?¬?©
		for(int z = 0; z<8;z++) {
			check_flag=0;
			char[] b = sa[z].toCharArray();
			//λ¬Έμ ?¨?λ‘? λΉκ΅λ₯? ??΄ string.toCharArray?¨? ?¬?©
			for(int j = 0; j<6; j++) {
				// κ°? ?μΉμ λ¬Έμ?΄? κ°μ΄ ?€λ₯? κ²½μ° cnt μ¦κ?.
				if (a[j]!=b[j]) {check_flag++;}				
			}
			// check_flagκ°? 2?΄? ?€λ₯? κ²½μ°? ?΄?Ή λ¬Έμ?΄?΄ ??λ―?λ‘? ifλ¬ΈμΌλ‘? μ§??μ³μ€
			if (check_flag<2) {
				return z;
			}
			
		}
//		μ΅μ’? ?Όλ‘? saλ°°μ΄ ?΄λΆ?? λͺ¨λ  0,1 κ°μΌλ‘? ?΄λ£¨μ΄μ§? λ¬Έμ?΄κ³? λΉκ΅?΄? μ°Ύμ ? ??Όλ―?λ‘? -1? λ¦¬ν΄
		return -1;
	}
	
	public static void main(String[] args){
		/*
		 * 1. λ¨Όμ? ?? ₯? λ°μ? 6λΉνΈ ?¨?λ‘? μͺΌκ°? ???₯?΄μ€??€.
		 * 2. κ·Έλ€? λ¦¬ν΄κ°μ μ‘°ν?? λ°©μ? 
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String pw = sc.nextLine();
		String[] answer = {"A","B","C","D","E","F","G","H"};
		
		String[] str = new String[num];
		int[] ans = new int[num];
		
		//for? iκ°μ ?΅?΄? substring? ?? μ£Όμλ₯? μ°μ΄?¨κΈ? ?λ¬Έμ
		//str, ans??? ?΄?Ή κ°μ int/intλ‘? ???΄? array out of indexing??¬λ₯? λ°©μ??΄?Ό?λ©?
		//?? flag? κ°μ κΈ°λ°?Όλ‘? μ΅μ’? ?Όλ‘? κ²°κ³Ό λ¦¬ν΄?΄μ€??€.
		for(int i=0;i<pw.length();i+=6) {
			//		6κ°μ λ¬Έμλ§λ€ λ¬Έμ?΄ λ°°μ΄λ‘? ? ?
			str[i/6]=pw.substring(i, i+6);
			// 
			int flag = check(str[i/6]);
			
			//check?¨?λ₯? ?΅?΄? ??¨ κ²°κ³Ό? ?°?Ό ???΄λ©? ansλ°°μ΄? ???₯ λ¬Έμ?΄? λͺ»μ°Ύ??κ²½μ° λ°λ‘ ?΄?Ή ?μΉ? μΆλ ₯ ? μ’λ£
			if(flag < 0) {
				// ?λͺ»λ ?μΉλ?? μ°Ύκ³  main ?¨? μ’λ£
				System.out.println(i/6+1);
				return;
			}else {
				ans[i/6]=flag;
				// flagλ₯? ?΅?΄? ??Έ ?΄?? λ¬Έμ κ΄?? ¨ ?Έ?±?€ ???₯
			}
		
		}
		for(int i : ans) {
			//? ?΅ μΆλ ₯
			System.out.printf("%s",answer[i]);
		}
		

		sc.close();
	}
	
}