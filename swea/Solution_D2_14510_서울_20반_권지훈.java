package gwonjihun.swea;

import java.io.*;
import java.util.*;

public class Solution_D2_14510_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception{
		int[] a = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(a));
		add(a);
		System.out.println(Arrays.toString(a));
		
	}
	static void add(int[] s) {
		for(int i = 0; i<6;i++) {
			s[i] += 10;
		}
	}
}
