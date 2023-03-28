package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1181_서울_20반_권지훈 {
	static int N;
	static List<String> s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		s = new ArrayList<>();
		for(int i = 0; i<N;i++) {
			String tmp = br.readLine();
				s.add(tmp);

		}

		Set<String> q = new HashSet<>(s);
		s = new ArrayList<>(q);
		Collections.sort( s, 
		   (String o1, String o2)-> {
		    	int r = o1.length()-o2.length();
		    	if(r!=0) {
		    		return r;
		    	}
		    	return o1.compareTo(o2);
		    }
		);
		for(String t : s) {
		System.out.println(t);
		}
	}
}
