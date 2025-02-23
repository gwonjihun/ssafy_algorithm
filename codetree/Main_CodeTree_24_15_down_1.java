package CodeTree;

import java.io.*;
import java.util.*;

public class Main_CodeTree_24_15_down_1 {

    static int n;
    static int[] customer;

    static int[] employs;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        customer = new int[n];
        employs = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            customer[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 2 ; i++){
            employs[i] = Integer.parseInt(st.nextToken());
        }
        long people = 0;

        for(int i = 0 ; i < n ; i++){
            //shop 단위로 계산해서 넣어주기
            //필요한 사람의 수는 people = 1 + ((customer[i]-employs)>0?)

            int temp = customer[i]-employs[0];
            people += 1;
            if(temp >0){
                people += temp/employs[1];

                if( temp%employs[1]>0){
                    people +=1;
                }
            }
        }
        System.out.println(people);

    }

}
