package Boj;

import java.io.*;
import java.util.*;
public class Main_boj_4375 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {

            int num = scan.nextInt();
            int mod = 0;

            for(int i = 1;;i++){
                // 1로만 이뤄진 숫자 제작 1. 11. 111 ....
                // 입력 숫자 나눈 로 나머지가 0 이면 출력
                mod = (mod*10+1)%num;
                if(mod == 0) {
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}