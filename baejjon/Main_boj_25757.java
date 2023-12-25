package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_25757 {
	static HashSet<String> userSet = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char menu = st.nextToken().charAt(0);
		int p;
		if (menu == 'Y') {
			p = 1;
		} else if (menu == 'F') {
			p = 2;
		} else {
			p = 3;
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			userSet.add(str);
			
		}
		System.out.println((int)userSet.size()/p);
	}
}
