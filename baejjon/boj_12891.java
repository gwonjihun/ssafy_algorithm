package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
* 1. 먼�? 0�??�� p-1번째까�??�� �??��?�� 중에 agct?�� �??��?�� 카운?���? ?��주면?��8,
* */
public class boj_12891 {
    static int length;
    static int part;
    static char[] str;
    static HashMap<Character,Integer> cnt;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        length = Integer.parseInt(st.nextToken());
        part = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray();
        cnt = new HashMap<>();
        st = new StringTokenizer(br.readLine()," ");
//        System.out.println(st.countTokens());
        cnt.put('A',Integer.parseInt(st.nextToken()));
        cnt.put('C',Integer.parseInt(st.nextToken()));
        cnt.put('G',Integer.parseInt(st.nextToken()));
        cnt.put('T',Integer.parseInt(st.nextToken()));
        //?��기까직�? ?��?��?�� ?��?�� �?�?
        int s = 0;
        int e = part-1;
        //초기?�� ???��?�� 계산
        for(int i = 0; i<part;i++){
            cnt.compute(str[i],(c,j)->j-1);
        }

        while (true){
            check();
            if (e==length-1){
                break;
            }
            cnt.compute(str[s++],(c,j)->j+1);
            cnt.compute(str[++e],(c,j)->j-1);

        }
        System.out.println(answer);
    }
    static void check(){
        for(Integer a:cnt.values()){
            if (a>0) return;
        }
        answer++;
    }
}
