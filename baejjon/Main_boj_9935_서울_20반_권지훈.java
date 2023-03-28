package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_9935_서울_20반_권지훈 {

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String goal= br.readLine();
		String target = br.readLine();
		
		for(int i = 0 ; i < (goal.length()/target.length())+1;i++) {
			goal = goal.replaceAll(target, "");
		}
		if(goal.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(goal);
		}
		
	}
}
