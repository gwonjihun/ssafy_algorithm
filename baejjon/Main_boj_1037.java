package Boj;
import java.io.*;
import java.util.*;
public class Main_boj_1037 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for(int i = 0 ; i < m ; i ++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[0]*arr[m-1]);
    }
}
