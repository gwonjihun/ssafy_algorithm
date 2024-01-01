package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_1748 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int answer = 0 ;
        for(int i = 1; i <= str.length();i++){
            if(i==str.length()){
                int temp = str.length()*(N-(int)Math.pow(10,str.length()-1)+1);
                answer += temp;
            }else{
                answer += i*9*(int)Math.pow(10,i-1);
            }
        }
        System.out.println(answer);
    }
}
