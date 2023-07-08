package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_2170 {
	
	public static void main(String[] args) {
		
		int[] prices = {10,7,8,5,8,7,6,2,9};
		int k = 3;
		int tmp = Integer.MIN_VALUE;
        for(int i = 0 ; i <prices.length-k;i++){
            int sum = -1 * prices[i]*k;
            for(int j=1;j<=k;j++){
                sum+= prices[i+j];
                Integer.max
            }
            if(tmp < sum){
                tmp = sum;
            }
        }
        System.out.println( tmp>0? tmp: -1);
	}

}
