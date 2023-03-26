package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1541_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;

		String[] cal = br.readLine().split("-"); // ë¹¼ê¸°ë¥? ê¸°ì??œ¼ë¡? ë¶„ë¦¬
		int res = 0;
		for(int i=0;i<cal.length;i++) {
			int sum = 0;
			String[] cal2 = cal[i].split("\\+");
			for(int j=0;j<cal2.length;j++) {
				sum += Integer.parseInt(cal2[j]);
			}
			if(i==0) {
				res += sum;
			}else {
				res -= sum;
			}
		}
		System.out.println(res);
	}
}
