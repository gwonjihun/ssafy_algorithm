package gwonjihun.baejjon;
import java.util.*;
import java.io.*;

public class Main_boj_15829_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String a= br.readLine();
		double[] b= new double[N];
		double answer = 0;
		for(int i = 0 ; i<N;i++) {
			answer+=(a.charAt(i)-'a'+1)*Math.pow(31, i);
		}
		System.out.printf("%.0f",answer%1234567891);
	}
}
