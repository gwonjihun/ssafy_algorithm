package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_12904 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer s = new StringBuffer(br.readLine());
		StringBuffer t = new StringBuffer(br.readLine());
		
		
		while(t.length()>s.length()) {
			if(t.charAt(t.length()-1)=='A') {
				t.deleteCharAt(t.length()-1);
			}else if(t.charAt(t.length()-1)=='B') {
				t.deleteCharAt(t.length()-1);
				t.reverse();
			}
		}
		
		if(s.toString().equals(t.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
