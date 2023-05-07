package gwonjihun.baejjon;
import java.io.*;
import java.util.*;

public class Main_boj_12919 {

	static String ans;
	static String goal;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = br.readLine();
		goal = br.readLine();
		
		System.out.println(check(ans,goal)? 1: 0);
		
		
	}
	static boolean check(String str,  String str_1) {
		if(str.length() == str_1.length()) {
			//여기서 결과를 비교해준다.
			if(str.equals(str_1)) {
				return true;
			}
			return false;
		}
		if(str_1.charAt(str_1.length()-1)=='A') {
			if(check(str,str_1.substring(0, str_1.length()-1))) {
				return true;
			}
		}
		if(str_1.charAt(0)=='B') {
			StringBuilder sb = new StringBuilder();
			sb.append(str_1.substring(1,str_1.length()));
			if(check(str,sb.reverse().toString())) {
				return true;
			}
		}
		return false;
	}
}
