package gwonjihun.studyb;

import java.io.*;
import java.util.*;

public class Solution_10726_2진수 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
			StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int toBinary = (1 << N) -1;
            String answer = "ON";
            if( (M & toBinary) != toBinary) answer = "OFF";
            System.out.println("#"+ tc+ " "+ answer);
		}
	}
}
