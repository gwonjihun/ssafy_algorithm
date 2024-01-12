package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_11723 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int s = 0;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int m = 0 ; m<M ; m++) {
			st = new StringTokenizer(br.readLine());
			String menu = st.nextToken();
			if(menu.equals("all")) {
				s = (1<<21)-1;
			}
			else if(menu.equals("empty")) {
				s =0;
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				if(menu.equals("remove"))
				{
					s &= ~(1<<num);
				}else if(menu.equals("add"))
				{
					s |= (1<<num);
				}else if(menu.equals("check")) {
					sb.append(((s&(1<<num))!= 0 ? 1: 0)).append("\n");
				}else if(menu.equals("toggle")) {
					s ^=(1<<num);
				}
			}
		}
		System.out.println(sb);
	}

}
